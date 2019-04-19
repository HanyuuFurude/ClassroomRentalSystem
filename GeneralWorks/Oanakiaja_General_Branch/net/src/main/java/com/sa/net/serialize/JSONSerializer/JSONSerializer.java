package com.sa.net.serialize.JSONSerializer;
import com.alibaba.fastjson.JSON;
import com.sa.net.serialize.Serializer;
import com.sa.net.serialize.SerializerAlogrithm;

public class JSONSerializer implements Serializer {

	//返回序列化标识
    public byte getSerializerAlogrithm() {
        return SerializerAlogrithm.JSON;
    }
    //序列化 由object转换成JSON字符串
    public byte[] serialize(Object object) {

        return JSON.toJSONBytes(object);
    }
    //反序列化 由JSON字符串转换成object数组
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {

        return JSON.parseObject(bytes, clazz);
    }
}
