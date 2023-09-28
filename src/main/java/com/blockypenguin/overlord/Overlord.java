package com.blockypenguin.overlord;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public final class Overlord {
	private static boolean keepRunning = true;
	
	public static void main(String[] args) throws IOException {
		int port = 8080;
		try(ServerSocket serverSocket = new ServerSocket(port)) {
			while(keepRunning) {
				Socket socket = serverSocket.accept();

				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

				String message = inFromClient.readLine();
				System.out.println("Received message: " + message);

				int code = Processor.process(message).getCode();

				outToClient.writeByte(code);
				outToClient.flush();

				socket.close();
			}
		}
	}
	
	public static void shutdown() {
		keepRunning = false;
	}
}
