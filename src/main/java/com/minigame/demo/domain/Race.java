package com.minigame.demo.domain;

import com.minigame.demo.constant.ANSIColor;
import com.minigame.demo.utils.SimpleOutputUtils;

import static com.minigame.demo.constant.MeaningfulNumber.*;

public class Race {
    static int TRACK_LENGTH = 50;

    public static synchronized void moveForward(Horse horse, Horse[] track) {
        horse.setPriority(Thread.MIN_PRIORITY);

        int currentPosition = horse.getPosition();

        remove();
        horse.setFirst(isFirst(currentPosition, track));

        if (currentPosition == ZERO) {
            if (track[currentPosition + ONE] == null) {
                horse.moveForward();
                track[horse.getPosition()] = horse;
            }

        } else {
            if (track[currentPosition + ONE] == null) {
                track[currentPosition] = null;
                horse.moveForward();

                if (!horse.isFirst() && currentPosition + TWO <= TRACK_LENGTH && track[currentPosition + TWO] == null) {
                    horse.moveForward();
                }

                track[horse.getPosition()] = horse;
            } else {
                Horse caughtHorse = track[currentPosition + ONE];
                caughtHorse.moveBackward();
                track[caughtHorse.getPosition()] = caughtHorse;
                horse.moveForward();
                track[horse.getPosition()] = horse;
                printOutrun(horse, caughtHorse);


                if (track[horse.getPosition() + ONE] == null) {
                    track[horse.getPosition()] = null;
                    horse.moveForward();
                    track[horse.getPosition()] = horse;
                }
            }

        }


        printTrack(track);
        horse.setPriority(Thread.NORM_PRIORITY);
    }

    public static int getWinner(Horse[] track) {
        return track[TRACK_LENGTH].getNumber();
    }

    private static boolean isFirst(int currentPosition, Horse[] track) {
        for (int i = currentPosition+1; i <= 50; i++) {
            if (track[i] != null) {
                return false;
            }
        }

        return true;
    }

    private static void remove() {
        for (int i = 0; i < 150; i++) {
            System.out.print("\b");
        }
    }

    private static void printTrack(Horse[] track) {
        for (int i = 1; i < track.length; i++) {
            if (track[i] == null) {
                SimpleOutputUtils.printNoLineBreak("[ ]");
            } else {
                SimpleOutputUtils.printNoLineBreak("[");
                SimpleOutputUtils.printNoLineBreak(String.valueOf(track[i].getNumber()), track[i].getColor().getColor());
                SimpleOutputUtils.printNoLineBreak("]");
            }
        }
    }

    private static void printOutrun(Horse horse, Horse caughtHorse) {
        SimpleOutputUtils.print("[" + horse.getColor().getColor() + horse.getNumber() + ANSIColor.ANSI_RESET + "]번이 " + "[" + caughtHorse.getColor().getColor() + caughtHorse.getNumber() + ANSIColor.ANSI_RESET + "]번 추월! ");
    }

    public static boolean isFinished(Horse[] track) {
        if (track[50] != null) {
            return true;
        }

        return false;
    }


}
