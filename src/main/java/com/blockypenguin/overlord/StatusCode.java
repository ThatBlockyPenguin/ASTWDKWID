package com.blockypenguin.overlord;

public enum StatusCode {
	OK(200),
	ERROR(100);
	
	private final int code;
	
	public int getCode() {
		return code;
	}
	
	StatusCode(int code) {
		this.code = Byte.toUnsignedInt((byte) code);
	}
}