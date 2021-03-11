package com.gexx.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyServerHander extends ChannelInboundHandlerAdapter {


    /**
     * @Description 读取数据
     * @author gexx
     * @Date 2021/3/11
     **/
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
        System.out.println("server ctx :" + ctx);
        ByteBuf buf = (ByteBuf) msg;
        System.out.println(" 客户端消息:" + buf.toString(CharsetUtil.UTF_8));
        System.out.println(" 客户端地址:" + ctx.channel().remoteAddress());
    }


    /**
     * @Description 数据读取完成
     * @author gexx
     * @Date 2021/3/11
     **/
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        super.channelReadComplete(ctx);

        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端", CharsetUtil.UTF_8));
    }


    /**
     * @Description 异常处理 关闭通道
     * @author gexx
     * @Date 2021/3/11
     **/
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}