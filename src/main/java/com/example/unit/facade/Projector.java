package com.example.unit.facade;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
public class Projector {
    private static final Logger logger = LoggerFactory.getLogger(Projector.class);

    public void on() {
       logger.info("Projector is on");
    }

    public void off() {
        logger.info("Projector is off");
    }

}
