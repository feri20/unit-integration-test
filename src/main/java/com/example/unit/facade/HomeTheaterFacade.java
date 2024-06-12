package com.example.unit.facade;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class HomeTheaterFacade {
    private static final Logger logger = LoggerFactory.getLogger(HomeTheaterFacade.class);

    private Amplifier amplifier;
    private Projector projector;
    private DVDPlayer dvdPlayer;


    public void watchMovie(){
        logger.info("Get ready to watch a movie...");
        projector.on();
        amplifier.on();
        amplifier.setVolume(10);
        dvdPlayer.on();
    }

    public void endMovie(){
        projector.off();
        amplifier.off();
        dvdPlayer.off();
    }

}
