package com.company.io;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class SocketClient {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8087;

        try {
            // 创建一个Socket对象，连接到指定的主机和端口
            Socket socket = new Socket(host, port);

            // 获取输入输出流
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // 向服务器发送数据
            out.println("Hello, Server!Hello, Server!\nHello, Server!Hello, Server!Hello, Server!Hello, Server!\nHello, Server!Hello, Server!\nHello, Server!");

            // 从服务器接收数据
            String response = in.readLine();
            System.out.println("Server response: " + response);

            // 关闭资源
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
