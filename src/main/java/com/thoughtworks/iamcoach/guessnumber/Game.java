package com.thoughtworks.iamcoach.guessnumber;

/**
 * Created by apple on 14-10-15.
 */
public class Game {
    private int count = 6;
    String systemOut = "";

    public String showResult(String result) {
        if(result.equals("4A0B")) {
            systemOut =  "Congratulations!";
        }
        else {
            this.count -= 1;
            if (this.count == 0) {
                systemOut = result + "\nGame Over";
            }
            else{
                systemOut = result + "\nPlease input your number (" + count + ")\n";
            }
        }
        System.out.println(systemOut);
        return systemOut;
    }

    public String start_game() {
        System.out.println("Welcome!\nPlease input your number (6)\n");
        return "Welcome!\nPlease input your number (6)\n";
    }
}
