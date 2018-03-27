package com.xiaolu.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Provider.Service;

public class StartServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(5656);
			Socket socket = null;
			System.out.println("服务器端已经启动，等待客户端连接！");
			while(true) {
				socket=serverSocket.accept();
				System.out.println("欢迎您！");
				ServiceThread sThread = new ServiceThread(socket);
				sThread.start();
			}
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}
