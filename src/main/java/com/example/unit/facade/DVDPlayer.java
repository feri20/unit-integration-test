package com.example.unit.facade;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
public class DVDPlayer {
    private static final Logger logger = LoggerFactory.getLogger(DVDPlayer.class);
    public void on() {
        logger.info("DVD Player is on");
    }

    public void off() {
        logger.info("DVD Player is off");
    }

}
