package com.blockypenguin.overlord;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Server {
	private static final Logger LOGGER = LogManager.getLogger();
	private static boolean keepRunning = true;
	
	static {
		LOGGER.debug("Loaded.");
	}

	public static void run(int port) {
		LOGGER.info("Starting Server...");
		
		try(ServerSocket serverSocket = new ServerSocket(port)) {
			serverSocket.setReuseAddress(true);
			
			LOGGER.debug("Entering main loop");
			while(keepRunning) {
				LOGGER.debug("Awaiting connection...");
				Socket socket = serverSocket.accept();
				
				LOGGER.debug("Connection accepted!");
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

				String message = inFromClient.readLine();
				LOGGER.info("Received message: {}", message);

				LOGGER.debug("Processing message...");
				int code = Processor.process(message).getCode();
				LOGGER.debug("Returning status code {}...", code);

				outToClient.writeByte(code);
				outToClient.flush();
				LOGGER.info("Message acknowledged. Communications complete.");

				socket.close();
				LOGGER.debug("Closed connection!");
			}
			
			LOGGER.debug("Main loop exited safely");
		}catch(Exception e) {
			LOGGER.error("An error occurred!", e);
		}finally {
			LOGGER.debug("Main loop exited");
		}
		
		LOGGER.info("Server closed!");
	}
	
	public static void shutdown() {
		LOGGER.info("Shutting down server...");
		keepRunning = false;
	}
}