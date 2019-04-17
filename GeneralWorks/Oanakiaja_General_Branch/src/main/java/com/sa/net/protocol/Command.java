package com.sa.net.protocol;

// 指令码 对应服务端客户端的响应操作
public interface Command {

	Byte LOGIN_REQUEST = 1;

	Byte LOGIN_RESPONSE = 2;
	
	Byte MESSAGE_REQUEST =3 ;

	Byte MESSAGE_RESPONSE = 4;
	
    Byte LOGOUT_REQUEST = 5;

    Byte LOGOUT_RESPONSE = 6;

	Byte UPDATE_REQUEST = 7;
	
	Byte UPDATE_RESPONSE = 8;
	
	Byte ORDER_REQUEST = 9;
	
	Byte ORDER_RESPONSE = 10;
}
