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
    private static GpioPinDigitalOutput gpioPinDigitalOutput_04 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_05 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_06 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_07 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_08 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_09 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_10 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_11 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_12 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_13 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_14 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_15 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_16 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_17 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_18 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_19 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_20 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_21 = null;

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
            case 4:
                if (gpioPinDigitalOutput_04 == null) {
                    gpioPinDigitalOutput_04 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
                }
                setState(state, gpioPinDigitalOutput_04);
                pinState = gpioPinDigitalOutput_04.getState().getName();
                break;
            case 5:
                if (gpioPinDigitalOutput_05 == null) {
                    gpioPinDigitalOutput_05 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05);
                }
                setState(state, gpioPinDigitalOutput_05);
                pinState = gpioPinDigitalOutput_05.getState().getName();
                break;
            case 6:
                if (gpioPinDigitalOutput_06 == null) {
                    gpioPinDigitalOutput_06 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06);
                }
                setState(state, gpioPinDigitalOutput_06);
                pinState = gpioPinDigitalOutput_06.getState().getName();
                break;
            case 7:
                if (gpioPinDigitalOutput_07 == null) {
                    gpioPinDigitalOutput_07 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07);
                }
                setState(state, gpioPinDigitalOutput_07);
                pinState = gpioPinDigitalOutput_07.getState().getName();
                break;
            case 8:
                if (gpioPinDigitalOutput_08 == null) {
                    gpioPinDigitalOutput_08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08);
                }
                setState(state, gpioPinDigitalOutput_08);
                pinState = gpioPinDigitalOutput_08.getState().getName();
                break;
            case 9:
                if (gpioPinDigitalOutput_09 == null) {
                    gpioPinDigitalOutput_09 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09);
                }
                setState(state, gpioPinDigitalOutput_09);
                pinState = gpioPinDigitalOutput_09.getState().getName();
                break;
            case 10:
                if (gpioPinDigitalOutput_10 == null) {
                    gpioPinDigitalOutput_10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10);
                }
                setState(state, gpioPinDigitalOutput_10);
                pinState = gpioPinDigitalOutput_10.getState().getName();
                break;
            case 11:
                if (gpioPinDigitalOutput_11 == null) {
                    gpioPinDigitalOutput_11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11);
                }
                setState(state, gpioPinDigitalOutput_11);
                pinState = gpioPinDigitalOutput_11.getState().getName();
                break;
            case 12:
                if (gpioPinDigitalOutput_12 == null) {
                    gpioPinDigitalOutput_12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12);
                }
                setState(state, gpioPinDigitalOutput_12);
                pinState = gpioPinDigitalOutput_12.getState().getName();
                break;
            case 13:
                if (gpioPinDigitalOutput_13 == null) {
                    gpioPinDigitalOutput_13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13);
                }
                setState(state, gpioPinDigitalOutput_13);
                pinState = gpioPinDigitalOutput_13.getState().getName();
                break;
            case 14:
                if (gpioPinDigitalOutput_14 == null) {
                    gpioPinDigitalOutput_14 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14);
                }
                setState(state, gpioPinDigitalOutput_14);
                pinState = gpioPinDigitalOutput_14.getState().getName();
                break;
            case 15:
                if (gpioPinDigitalOutput_15 == null) {
                    gpioPinDigitalOutput_15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15);
                }
                setState(state, gpioPinDigitalOutput_15);
                pinState = gpioPinDigitalOutput_15.getState().getName();
                break;
            case 16:
                if (gpioPinDigitalOutput_16 == null) {
                    gpioPinDigitalOutput_16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16);
                }
                setState(state, gpioPinDigitalOutput_16);
                pinState = gpioPinDigitalOutput_16.getState().getName();
                break;
            case 17:
                if (gpioPinDigitalOutput_17 == null) {
                    gpioPinDigitalOutput_17 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17);
                }
                setState(state, gpioPinDigitalOutput_17);
                pinState = gpioPinDigitalOutput_17.getState().getName();
                break;
            case 18:
                if (gpioPinDigitalOutput_18 == null) {
                    gpioPinDigitalOutput_18 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18);
                }
                setState(state, gpioPinDigitalOutput_18);
                pinState = gpioPinDigitalOutput_18.getState().getName();
                break;
            case 19:
                if (gpioPinDigitalOutput_19 == null) {
                    gpioPinDigitalOutput_19 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19);
                }
                setState(state, gpioPinDigitalOutput_19);
                pinState = gpioPinDigitalOutput_19.getState().getName();
                break;
            case 20:
                if (gpioPinDigitalOutput_20 == null) {
                    gpioPinDigitalOutput_20 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_20);
                }
                setState(state, gpioPinDigitalOutput_20);
                pinState = gpioPinDigitalOutput_20.getState().getName();
                break;
            case 21:
                if (gpioPinDigitalOutput_21 == null) {
                    gpioPinDigitalOutput_21 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21);
                }
                setState(state, gpioPinDigitalOutput_21);
                pinState = gpioPinDigitalOutput_21.getState().getName();
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
            TimeUnit.MILLISECONDS.sleep(150);
        }
        if (OFF.equals(state) || ON_OFF.equals(state)) {
            gpioPinDigitalOutput.high();
        }
    }

}
