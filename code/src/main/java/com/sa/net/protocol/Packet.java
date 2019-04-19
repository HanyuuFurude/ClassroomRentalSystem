package com.sa.net.protocol;

//使用阿里的fastjson
import com.alibaba.fastjson.annotation.JSONField;
//lombok奉行简化代码主义  @Data 表示自动获得代码中的Getter 和 Setter方法

public class Packet {
	/**
	 * 协议版本
	 */
	@JSONField(deserialize = false, serialize = false)
	private Byte version = 1;
	public void setVersion(Byte version) {
		this.version = version;
	}
	public Byte getVersion() {
		return version;
	}
	@JSONField(serialize = false)
	public  Byte getCommand() {
		return null;
	}

	
}
