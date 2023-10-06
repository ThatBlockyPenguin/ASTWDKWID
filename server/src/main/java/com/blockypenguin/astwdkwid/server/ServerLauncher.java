package com.blockypenguin.astwdkwid.server;

import com.blockypenguin.astwdkwid.core.Metadata;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final class ServerLauncher {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.debug("Launching Server...");
        Server.run(Metadata.DEFAULT.port());
    }
}
