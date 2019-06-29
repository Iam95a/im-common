package com.chen.im.common.client;

import com.chen.im.common.constant.Constant;
import com.chen.im.common.protobuf.RequestMessageProto;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        sendLoginRequest(ctx);
//        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", //2
//                CharsetUtil.UTF_8));
    }


    private void sendLoginRequest(ChannelHandlerContext ctx) {
        RequestMessageProto.RequestMessage.Builder builder = RequestMessageProto.RequestMessage.newBuilder();
        builder.setCommand(Constant.CMD_LOGIN);
        RequestMessageProto.RequestMessage.User.Builder userBuilder = RequestMessageProto.RequestMessage.User.newBuilder();
        userBuilder.setNickname("chen");
        userBuilder.setPassword("123456");
        builder.setUser(userBuilder.build());
        ctx.writeAndFlush(builder.build());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx,
                             Object o) {
        System.out.println(o);    //3
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {                    //4
        cause.printStackTrace();
        ctx.close();
    }
}
