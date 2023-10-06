package com.blockypenguin.astwdkwid.gui;

import com.blockypenguin.astwdkwid.core.Metadata;
import com.blockypenguin.astwdkwid.server.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class GUI extends JFrame {
    private static final Logger LOGGER = LogManager.getLogger();
    public static GUI instance = null;

    public GUI() {
        super(Metadata.DEFAULT.postfixShortName("Settings"));

        setupClosingHandler();
        this.setSize(300, 300);
        setupContent();
    }

    public void display() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static GUI getInstance() {
        if(instance == null)
            instance = new GUI();

        return instance;
    }

    private void setupContent() {
//        this.getContentPane().add();
    }

    private void setupClosingHandler() {
        LOGGER.debug("Setting up GUI Closing Handler...");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Server.shutdown();
            }
        });
    }
}