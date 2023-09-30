package com.blockypenguin.overlord;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Overlord {
	private static final Logger LOGGER = LogManager.getLogger();
	
	static {
		LOGGER.debug("Loaded.");
	}
	
	public static void main(String[] args) {
		LOGGER.info("Starting Overlord...");
		Server.run(8080);
	}
}