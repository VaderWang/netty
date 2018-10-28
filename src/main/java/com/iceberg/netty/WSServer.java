package com.iceberg.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class WSServer {
    public static void main(String[] args) throws Exception{

        //主线程组
        NioEventLoopGroup masterGroup = new NioEventLoopGroup();
        NioEventLoopGroup slaveGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(masterGroup, slaveGroup).channel(NioServerSocketChannel.class).childHandler(new WSServerInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            masterGroup.shutdownGracefully();
            slaveGroup.shutdownGracefully();
        }
    }
}
