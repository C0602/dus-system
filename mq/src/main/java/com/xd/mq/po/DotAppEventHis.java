package com.xd.mq.po;

import java.io.Serializable;

public class DotAppEventHis implements Serializable {

	private static final long serialVersionUID = -5349993237162943212L;

	// 主键
	private String id;
	// 应用ID
	private String appId;
	// 应用名称
	private String appName;
	// 事件ID
	private String eventId;
	// 事件名称
	private String eventName;
	// 轨迹ID
	private String traceId;
	// 客户端ip
	private String cip;
	// 服务端ip
	private String sip;
	// 设备ID  IMEI/IDFA
	private String deviceId;
	// 用户唯一标识
	private String userId;
	// 版本号
	private String version;
	// 渠道
	private String channel;
	// 来源
	private String source;
	// 打点时间
	private String dotTime;
	// 创建时间
	private String createDate;
	// 业务关键字段1
	private String b1;
	// 业务关键字段2
	private String b2;
	// 业务关键字段3
	private String b3;
	// 业务关键字段4
	private String b4;
	// 业务关键字段5
	private String b5;
	// 业务完整参数
	private String jsonParam;
	// 对应表名
	private String tableName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getTraceId() {
		return traceId;
	}
	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public String getSip() {
		return sip;
	}
	public void setSip(String sip) {
		this.sip = sip;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDotTime() {
		return dotTime;
	}
	public void setDotTime(String dotTime) {
		this.dotTime = dotTime;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getB1() {
		return b1;
	}
	public void setB1(String b1) {
		this.b1 = b1;
	}
	public String getB2() {
		return b2;
	}
	public void setB2(String b2) {
		this.b2 = b2;
	}
	public String getB3() {
		return b3;
	}
	public void setB3(String b3) {
		this.b3 = b3;
	}
	public String getB4() {
		return b4;
	}
	public void setB4(String b4) {
		this.b4 = b4;
	}
	public String getB5() {
		return b5;
	}
	public void setB5(String b5) {
		this.b5 = b5;
	}
	public String getJsonParam() {
		return jsonParam;
	}
	public void setJsonParam(String jsonParam) {
		this.jsonParam = jsonParam;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	

}