package com.deveddy.projecthomedroid.hw.io;

public interface Button extends AutoCloseable {

    void setListener(Listener listener);

    interface Listener {

        void onButtonPressed(Button button);

        void onButtonReleased(Button button);

    }
}
