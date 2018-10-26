package com.iceberg.netty;

import io.netty.channel.nio.NioEventLoopGroup;

public class HelloServer {
    public static void main(String[] args) {

        NioEventLoopGroup masterGroup = new NioEventLoopGroup();

        NioEventLoopGroup slaveGroup = new NioEventLoopGroup();


    }
}
