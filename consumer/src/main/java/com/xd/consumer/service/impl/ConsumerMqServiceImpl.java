package com.xd.consumer.service.impl;

import com.google.gson.Gson;
import com.xd.consumer.base.CmBaseMqService;
import com.xd.mq.service.ProducerMqService;
import com.xd.mq.vo.DotAppEventHisVo;
import com.xd.consumer.service.ConsumerMqService;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MQ消费者
 *
 * @author Minbo
 */
@Service
public class ConsumerMqServiceImpl implements ConsumerMqService {

    protected static Logger logger = LoggerFactory.getLogger(com.xd.consumer.service.impl.ConsumerMqServiceImpl.class);

    @Override
    public boolean consume() {
        try {
            DefaultMQPushConsumer consumer = CmBaseMqService.getConsumer();
            // 订阅所有消息
            consumer.subscribe(ProducerMqService.TOPIC, "*");
            logger.info("消费者，订阅所有消息");

            consumer.registerMessageListener(new MessageListenerConcurrently() {
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {
                    for (MessageExt msg : msgs) {
                        Gson gson = new Gson();

                        logger.info("消费者，准备消费消息：tag= " + msg.getTags());

                        // 区分不同Tag，不同处理方式
                        switch (msg.getTags()) {
                            // 应用事件打点
                            case ProducerMqService.TAG_DOT_APP_EVENT_HIS:
                                DotAppEventHisVo dotAppEventHisVo = gson.fromJson(new String(msg.getBody()),
                                        DotAppEventHisVo.class);
                                logger.info("消费消息:得到内容为：" + dotAppEventHisVo.toString());
                                break;
                            default:
                                logger.error("无处理类型，请检查。tag=" + msg.getTags(), new RuntimeException("未知Tag类型"));
                                break;
                        }
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });

            consumer.start();
            logger.info("消费者，启动成功...");

        } catch (Exception e) {
            logger.error("消费者，启动异常：" + e.getMessage(), e);
        }
        return true;
    }
}
