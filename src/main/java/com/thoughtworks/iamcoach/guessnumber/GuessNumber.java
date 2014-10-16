package com.thoughtworks.iamcoach.guessnumber;

import java.io.InputStream;

/**
 * Created by apple on 14-10-15.
 */
public class GuessNumber {

    public String compare(String guess, String input) {
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (guess.charAt(i) == input.charAt(j) && i != j) {
                    countB = countB + 1;
                }
            }
            if (guess.charAt(i) == input.charAt(i)) {
                countA = countA + 1;
            }
        }
        return countA + "A" + countB + "B";
    }
}
