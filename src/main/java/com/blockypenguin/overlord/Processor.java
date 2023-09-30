package com.blockypenguin.overlord;

public final class Processor {
	public static StatusCode process(String message) {
		return switch(message) {
			case "EXIT" -> {
				Server.shutdown();
				yield StatusCode.OK;
			}
			default -> StatusCode.ERROR;
		};
	}
}