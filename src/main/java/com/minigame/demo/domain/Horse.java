package com.minigame.demo.domain;

import com.minigame.demo.enums.HorseColor;

public class Horse extends Thread {
    private int number;
    private HorseColor horseColor;
    private int position;
    private boolean isFirst;
    private Horse[] track;


    public Horse(int number, HorseColor horseColor, Horse[] track) {
        this.number = number;
        this.horseColor = horseColor;
        this.track = track;
        position = 0;
    }

    @Override
    public void run() {
        while (position != Race.TRACK_LENGTH) {
            if(Race.isFinished(track)) {

                return;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Race.moveForward(this, track);
        }
    }



    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position++;
    }

    public void moveBackward() {
        position--;
    }

    public void setFirst(boolean isFirst) {
        this.isFirst = isFirst;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public HorseColor getColor() {
        return horseColor;
    }
}
