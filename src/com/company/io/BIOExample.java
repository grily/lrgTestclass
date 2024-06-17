package com.company.io;

import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;

public class BIOExample {
//    BIO（Blocking I/O）：同步阻塞I/O，是Java IO的基础，每个请求都会阻塞直到数据返回。
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8087);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println("收到消息： " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
