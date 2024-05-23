package com.minigame.demo.domain;

public class Horse extends Thread {
    private int number;
    private int position;
    private boolean isFirst;


    public Horse(int number) {

        this.number = number;
        position = 0;
    }

    @Override
    public void run() {
        while (position != 50) {
            if(Race.isFinished()) {
                return;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Race.moveForward(this);
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
}
