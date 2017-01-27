package com.deveddy.projecthomedroid;

import android.app.Activity;
import android.os.Bundle;

import com.deveddy.projecthomedroid.hw.board.BoardFactory;
import com.deveddy.projecthomedroid.hw.io.Button;
import com.deveddy.projecthomedroid.hw.io.GpioButton;
import com.deveddy.projecthomedroid.hw.io.GpioLed;
import com.deveddy.projecthomedroid.hw.io.Led;
import com.google.android.things.pio.PeripheralManagerService;

public class HomeActivity extends Activity {

    private Button button;
    private Led led;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BoardFactory boardFactory = BoardFactory.getBoardFactory();
        PeripheralManagerService service = new PeripheralManagerService();

        button = GpioButton.create(boardFactory.buttonGpio(), service);
        led = GpioLed.create(boardFactory.ledGpio(), service);

        button.setListener(new Button.Listener() {
            @Override
            public void onButtonPressed(Button button) {
                led.turnOn();
            }

            @Override
            public void onButtonReleased(Button button) {
                led.turnOff();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            button.close();
            led.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
