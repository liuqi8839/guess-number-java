package com.thoughtworks.iamcoach.guessnumber;

/**
 * Created by apple on 14-10-15.
 */
public class Game {
    private int count = 6;

    public String showResult(String result) {
        if(result.equals("4A0B")) {
            return "Congratulations!";
        }
        this.count -= 1;
        if (this.count == 0) {
            return result + "/nGame Over";
        }
        return result + "/nPlease input your number (" + count + ")/n";
    }

    public String start_game() {
        return "Welcome!/nPlease input your number (6)/n";
    }
}
