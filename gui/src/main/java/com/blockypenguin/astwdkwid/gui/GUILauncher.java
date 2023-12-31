package com.blockypenguin.astwdkwid.gui;

import com.blockypenguin.astwdkwid.core.Metadata;
import com.blockypenguin.astwdkwid.server.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final class GUILauncher {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info("Launching GUI...");
        GUI.getInstance().display();

        Server.run(Metadata.DEFAULT.port());
    }
}
