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
        RandomNumber randomNumber = mock(RandomNumber.class);
        when(randomNumber.get()).thenReturn("1234");

        CompareNumber compareNumber = new CompareNumber();
        assertThat(compareNumber.compare(randomNumber.get(), "5678")).isEqualTo("0A0B");
        assertThat(compareNumber.compare(randomNumber.get(), "4321")).isEqualTo("0A4B");
        assertThat(compareNumber.compare(randomNumber.get(), "1324")).isEqualTo("2A2B");
        assertThat(compareNumber.compare(randomNumber.get(), "1234")).isEqualTo("4A0B");
    }

    @Test
    public void test_random() {
        RandomNumber randomNumber = new RandomNumber();
        String Guess1 = randomNumber.get();
        //如果抛出异常，说明返回的值不是int类型
        Boolean flag = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Guess1.charAt(i) == Guess1.charAt(j) && i != j) {
                    flag = false;
                }
            }
        }
        assertThat(flag).isEqualTo(true);
        //测试每一位都不重复

        String Guess2 = randomNumber.get();
        boolean random = true;
        if (Guess1.equals(Guess2)) {
            random = false;
        }
        assertThat(random).isEqualTo(true);
        //测试产生的是随机数

        assertThat(Guess1.length()).isEqualTo(4);
        //测试位数为4
    }

    @Test
    public void match_test() {
        CompareNumber compareNumber = new CompareNumber();
        assertThat(compareNumber.compare("1234", "5678")).isEqualTo("0A0B");
        assertThat(compareNumber.compare("1234", "4321")).isEqualTo("0A4B");
        assertThat(compareNumber.compare("1234", "1324")).isEqualTo("2A2B");
        assertThat(compareNumber.compare("1234", "1234")).isEqualTo("4A0B");
    }

}