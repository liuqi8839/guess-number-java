package com.thoughtworks.iamcoach.guessnumber;

/**
 * Created by apple on 14-10-15.
 */
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class GuessNumberTest {
    @Test
    public void integration_test() {
        ProduceNumber produceNumber = mock(ProduceNumber.class);
        when(produceNumber.getNumber()).thenReturn("1234");

        GuessNumber guessNumber = new GuessNumber();
        assertThat(guessNumber.returnGuess(produceNumber.getNumber(), "5678")).isEqualTo("0A0B");
        assertThat(guessNumber.returnGuess(produceNumber.getNumber(), "4321")).isEqualTo("0A4B");
        assertThat(guessNumber.returnGuess(produceNumber.getNumber(), "1324")).isEqualTo("2A2B");
        assertThat(guessNumber.returnGuess(produceNumber.getNumber(), "1234")).isEqualTo("4A0B");
    }

    @Test
    public  void test_random() {
        ProduceNumber produceNumber = new ProduceNumber();
        String Guess1 = produceNumber.getNumber();
        //如果抛出异常，说明返回的值不是int类型
        Boolean flag = true;
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(Guess1.charAt(i) == Guess1.charAt(j) && i != j) {
                    flag = false;
                }
            }
        }
        assertThat(flag).isEqualTo(true);
        //测试每一位都不重复

        String Guess2 = produceNumber.getNumber();
        boolean random = true;
        if(Guess1.equals(Guess2)) {
            random = false;
        }
        assertThat(random).isEqualTo(true);
        //测试产生的是随机数

        assertThat(Guess1.length()).isEqualTo(4);
        //测试位数为4
    }

    @Test
    public void match_test() {
        GuessNumber guessNumber = new GuessNumber();
        assertThat(guessNumber.returnGuess("1234", "5678")).isEqualTo("0A0B");
        assertThat(guessNumber.returnGuess("1234", "4321")).isEqualTo("0A4B");
        assertThat(guessNumber.returnGuess("1234", "1324")).isEqualTo("2A2B");
        assertThat(guessNumber.returnGuess("1234", "1234")).isEqualTo("4A0B");
    }

    @Test
    public void out__print_test() {
        Counter counter = mock(Counter.class);
        when(counter.getCount()).thenReturn(6);

        PrintOut printOut = new PrintOut();
        assertThat(printOut.print_out(counter.getCount())).isEqualTo("Welcome!/nPlease input your number (6)/n");
        when(counter.getCount()).thenReturn(5);
        assertThat(printOut.print_out(counter.getCount())).isEqualTo("Please input your number (5)/n");
        when(counter.getCount()).thenReturn(0);
        assertThat(printOut.print_out(counter.getCount())).isEqualTo("Game Over");
    }
}