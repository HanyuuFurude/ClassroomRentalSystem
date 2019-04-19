package com.sa.net.protocol;    

import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.Map;

import com.sa.net.serialize.Serializer;
import com.sa.net.serialize.JSONSerializer.JSONSerializer;

import com.sa.net.protocol.Command;

public class PacketCodec {
	//魔数
	/*
	假设我们在服务器上开了一个端口，比如 80 端口，如果没有这个魔数，任何数据包传递到服务器，服务器都会根据自
	定义协议来进行处理，包括不符合自定义协议规范的数据包。例如，我们直接通过 http://服务器ip 来访问服务器
	（默认为 80 端口）， 服务端收到的是一个标准的 HTTP 协议数据包，但是它仍然会按照事先约定好的协议来处理 HTTP 
	协议，显然，这是会解析出错的。而有了这个魔数之后，服务端首先取出前面四个字节进行比对，能够在第一时间识别出这
	个数据包并非是遵循自定义协议的，也就是无效数据包，为了安全考虑可以直接关闭连接以节省资源。在 Java 的字节码
	的二进制文件中，开头的 4 个字节为0xcafebabe 用来标识这是个字节码文件，亦是异曲同工之妙。
	*/
    public static final int MAGIC_NUMBER = 0x12345678;
    public static final PacketCodec INSTANCE = new PacketCodec();

    //先用MAP数据结构存取，Command-packet类型，序列化算法序号-转换算法类型（这里就用ali的FASTJSON）
    private final Map<Byte, Class<? extends Packet>> packetTypeMap;
    private final Map<Byte, Serializer> serializerMap;

    
    private PacketCodec() {
        packetTypeMap = new HashMap<>();
        //这里添加Command与packet建立对应关系
        packetTypeMap.put(Command.LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(Command.LOGIN_RESPONSE, LoginResponsePacket.class);
        packetTypeMap.put(Command.UPDATE_REQUEST, UpdateRequestPacket.class);
        packetTypeMap.put(Command.UPDATE_RESPONSE, UpdateResponsePacket.class);
        packetTypeMap.put(Command.ORDER_REQUEST, OrderRequestPacket.class);
        packetTypeMap.put(Command.ORDER_RESPONSE, OrderResponsePacket.class);
        packetTypeMap.put(Command.LOGOUT_REQUEST, LogoutRequestPacket.class);
        packetTypeMap.put(Command.LOGOUT_RESPONSE, LogoutResponsePacket.class);

        serializerMap = new HashMap<>();
        Serializer serializer = new JSONSerializer();
        serializerMap.put(serializer.getSerializerAlogrithm(), serializer);
    }

    //封装成二进制过程
    public void encode(ByteBuf byteBuf, Packet packet) {
        // 1. 序列化 java 对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        // 2. 实际编码过程
        //前7个字节协议内容
        //4B
        byteBuf.writeInt(MAGIC_NUMBER);
        //1B
        byteBuf.writeByte(packet.getVersion());
        //1B
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlogrithm());
        //1B
        byteBuf.writeByte(packet.getCommand());
        //后面是数据
        //4B数据长度
        byteBuf.writeInt(bytes.length);
        //N字节
        byteBuf.writeBytes(bytes);
    }

    //解析 Java 对象的过程
    public Packet decode(ByteBuf byteBuf) {
    	//层层解码
        // 跳过 magic number
        byteBuf.skipBytes(4);

        // 跳过版本号
        byteBuf.skipBytes(1);

        // 序列化算法
        byte serializeAlgorithm = byteBuf.readByte();

        // 指令
        byte command = byteBuf.readByte();

        // 数据包长度
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serializeAlgorithm);

        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, bytes);
        }

        return null;
    }

    private Serializer getSerializer(byte serializeAlgorithm) {

        return serializerMap.get(serializeAlgorithm);
    }

    private Class<? extends Packet> getRequestType(byte command) {

        return packetTypeMap.get(command);
    }
}
