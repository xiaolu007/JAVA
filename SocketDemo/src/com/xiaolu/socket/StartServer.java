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
			System.out.println("���������Ѿ��������ȴ��ͻ������ӣ�");
			while(true) {
				socket=serverSocket.accept();
				System.out.println("��ӭ����");
				ServiceThread sThread = new ServiceThread(socket);
				sThread.start();
			}
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}
