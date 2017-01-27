package com.deveddy.projecthomedroid.hw.board;

class Rpi3BoardFactory extends BoardFactory {

    @Override
    public String ledGpio() {
        return "BCM21";
    }

    @Override
    public String buttonGpio() {
        return "BCM23";
    }

}
