package com.iceberg.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class HelloServer {
    public static void main(String[] args) throws Exception{

        //主线程组
        NioEventLoopGroup masterGroup = new NioEventLoopGroup();
        NioEventLoopGroup slaveGroup = new NioEventLoopGroup();

        //启动类
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        //简单设置
        serverBootstrap.group(masterGroup, slaveGroup).channel(NioServerSocketChannel.class).childHandler(null);

        //启动server
        ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();

        channelFuture.channel().closeFuture().sync();


    }
}
