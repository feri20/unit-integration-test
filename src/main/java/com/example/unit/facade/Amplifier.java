package com.example.unit.facade;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
public class Amplifier {

    private static final Logger logger = LoggerFactory.getLogger(Amplifier.class);

    public void on() {
        logger.info("Amplifier is on");
    }

    public void off() {
        logger.info("Amplifier is off");
    }

    public void setVolume(int level) {
       logger.info("Setting volume to {}" , level);
    }
}
