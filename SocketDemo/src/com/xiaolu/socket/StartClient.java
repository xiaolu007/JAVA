package com.xiaolu.socket;

import java.io.IOException;

public class StartClient {
	 public static void main(String[] args) throws IOException {
		SocketClient client = new SocketClient();
		client.showMainMenu();
	}
}
