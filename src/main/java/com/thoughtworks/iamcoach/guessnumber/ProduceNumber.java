package com.thoughtworks.iamcoach.guessnumber;

/**
 * Created by apple on 14-10-15.
 */
public class ProduceNumber {
    public String getNumber() {
        String Number = "";
        String newNum;
        for(int i = 0; i < 4; i++ ){
            newNum = "" + (int)(Math.random()*10);
            while (Number.contains(newNum)) {
                newNum = "" + (int)(Math.random()*10);
            }
            Number += newNum;
        }
        return Number;
    }
}
