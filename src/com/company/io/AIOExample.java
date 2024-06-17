package com.company.io;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

public class AIOExample {
//    异步非阻塞I/O，在Java中通过Future和Callable实现异步操作
//    异步 IO 是基于事件和回调机制实现的，也就是应用操作之后会直接返回，不会堵塞在那里，当后台处理完成，操作系统会通知相应的线程进行后续的操作
//目前来说 AIO 的应用还不是很广泛

    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8087));

        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel socketChannel, Void attachment) {
                serverSocketChannel.accept(null, this);
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                Future<Integer> future = socketChannel.read(buffer);
                try {
                    int bytesRead = future.get();
                    if (bytesRead > 0) {
                        buffer.flip();
                        System.out.println("收到消息： " + new String(buffer.array(), 0, bytesRead));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });

        System.in.read();
    }
}
