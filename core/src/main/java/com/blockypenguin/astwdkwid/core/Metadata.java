package com.blockypenguin.astwdkwid.core;

public record Metadata(String fullName, String shortName, short port) {
    public static final Metadata DEFAULT = new Metadata(
        "Aperture Science Thing We Don't Know What It Does",
        "ASTWDKWID",
        (short) 8080
    );

    public String prefixFullName(String prefix) {
        return prefix.trim() + " " + fullName.trim();
    }

    public String postfixFullName(String postfix) {
        return fullName.trim() + " " + postfix.trim();
    }

    public String prefixShortName(String prefix) {
        return prefix.trim() + " " + shortName.trim();
    }

    public String postfixShortName(String postfix) {
        return shortName.trim() + " " + postfix.trim();
    }
}