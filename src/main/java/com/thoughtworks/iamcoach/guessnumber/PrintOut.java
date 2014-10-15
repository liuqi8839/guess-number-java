package com.thoughtworks.iamcoach.guessnumber;

/**
 * Created by apple on 14-10-15.
 */
public class PrintOut {
    public String print_out(int count) {
        String total = "Please input your number ("+ count + ")/n";
        if(count == 6){
            total = "Welcome!/nPlease input your number ("+ count + ")/n";
        }
        if(count == 0) {
            total = "Game Over";
        }
        return total;
    }
}
