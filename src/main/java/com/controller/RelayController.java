package com.controller;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class RelayController {

    private static String ON = "on";
    private static String OFF = "off";
    private static String ON_OFF = "onoff";

    private static GpioPinDigitalOutput gpioPinDigitalOutput = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_01 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_02 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_03 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_08 = null;

    @RequestMapping(value = "relay/{gpioNumber}/{state}")
    public String onOff(@PathVariable Integer gpioNumber, @PathVariable String state) throws InterruptedException {

        final GpioController gpio = GpioFactory.getInstance();

        String pinState;
        switch (gpioNumber) {
            case 1:
                if (gpioPinDigitalOutput_01 == null) {
                    gpioPinDigitalOutput_01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
                }
                setState(state, gpioPinDigitalOutput_01);
                pinState = gpioPinDigitalOutput_01.getState().getName();
                break;
            case 2:
                if (gpioPinDigitalOutput_02 == null) {
                    gpioPinDigitalOutput_02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
                }
                setState(state, gpioPinDigitalOutput_02);
                pinState = gpioPinDigitalOutput_02.getState().getName();
                break;
            case 3:
                if (gpioPinDigitalOutput_03 == null) {
                    gpioPinDigitalOutput_03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
                }
                setState(state, gpioPinDigitalOutput_03);
                pinState = gpioPinDigitalOutput_03.getState().getName();
                break;
            case 8:
                if (gpioPinDigitalOutput_08 == null) {
                    gpioPinDigitalOutput_08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08);
                }
                setState(state, gpioPinDigitalOutput_08);
                pinState = gpioPinDigitalOutput_08.getState().getName();
                break;
            default:
                if (gpioPinDigitalOutput == null) {
                    gpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
                }
                setState(state, gpioPinDigitalOutput);
                pinState = gpioPinDigitalOutput.getState().getName();
                break;
        }

        return pinState;
    }

    private void setState(final String state, final GpioPinDigitalOutput gpioPinDigitalOutput) throws InterruptedException {
        if (ON.equals(state) || ON_OFF.equals(state)) {
            gpioPinDigitalOutput.low();
        }
        if (ON_OFF.equals(state)) {
            TimeUnit.MILLISECONDS.sleep(100);
        }
        if (OFF.equals(state) || ON_OFF.equals(state)) {
            gpioPinDigitalOutput.high();
        }
    }

}
