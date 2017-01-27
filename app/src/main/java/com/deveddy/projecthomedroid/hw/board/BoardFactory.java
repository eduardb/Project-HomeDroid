package com.deveddy.projecthomedroid.hw.board;

import android.os.Build;

public abstract class BoardFactory {

    private static final String DEVICE_EDISON = "edison";
    private static final String DEVICE_RPI3 = "rpi3";
    private static final String DEVICE_NXP = "imx6ul";

    private static BoardFactory boardFactory;

    public static BoardFactory getBoardFactory() {
        if (boardFactory != null) {
            return boardFactory;
        }

        switch (Build.DEVICE) {
            case DEVICE_EDISON:
                throw new RuntimeException("Not implemented yet");
            case DEVICE_RPI3:
                boardFactory = new Rpi3BoardFactory();
                break;
            case DEVICE_NXP:
                throw new RuntimeException("Not implemented yet");
            default:
                throw new RuntimeException("Unknown board " + Build.DEVICE);
        }
        return boardFactory;
    }

    public abstract String ledGpio();

    public abstract String buttonGpio();

}
