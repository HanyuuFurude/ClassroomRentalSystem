package com.sa.net.attributes;
import com.sa.net.session.Session;

import io.netty.util.AttributeKey;
//会话信息

//添加channel里属性，使用SESSION来标识，建立通道
public interface Attributes {
	AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
