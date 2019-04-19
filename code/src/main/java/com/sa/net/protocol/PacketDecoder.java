package com.sa.net.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;


import java.util.List;

public class PacketDecoder extends ByteToMessageDecoder {

    @SuppressWarnings("unchecked")
	@Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, @SuppressWarnings("rawtypes") List out) {
        out.add(PacketCodec.INSTANCE.decode(in));
    }
}