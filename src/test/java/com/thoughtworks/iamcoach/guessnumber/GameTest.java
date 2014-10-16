package com.thoughtworks.iamcoach.guessnumber;

/**
 * Created by apple on 14-10-16.
 */
import com.javafx.tools.doclets.internal.toolkit.util.DocFinder;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

public class GameTest {


    @Test
    public void game_start_test() {

        Game game = new Game();
        assertThat(game.start_game()).isEqualTo("Welcome!/nPlease input your number (6)/n");
        //测试游戏开始时的输出
    }

    @Test
    public void guess_wrong() throws IOException {
        GuessNumber guessNumber = new GuessNumber();

        Game game = new Game();

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("4321");

        ProduceNumber produceNumber = mock(ProduceNumber.class);
        when(produceNumber.getNumber()).thenReturn("1234");

        assertThat(game.showResult(guessNumber.compare(produceNumber.getNumber(), bufferedReader.readLine()))).isEqualTo("0A4B/nPlease input your number (5)/n");
        assertThat(game.showResult(guessNumber.compare(produceNumber.getNumber(), bufferedReader.readLine()))).isEqualTo("0A4B/nPlease input your number (4)/n");
        assertThat(game.showResult(guessNumber.compare(produceNumber.getNumber(), bufferedReader.readLine()))).isEqualTo("0A4B/nPlease input your number (3)/n");
        assertThat(game.showResult(guessNumber.compare(produceNumber.getNumber(), bufferedReader.readLine()))).isEqualTo("0A4B/nPlease input your number (2)/n");
        assertThat(game.showResult(guessNumber.compare(produceNumber.getNumber(), bufferedReader.readLine()))).isEqualTo("0A4B/nPlease input your number (1)/n");
        assertThat(game.showResult(guessNumber.compare(produceNumber.getNumber(), bufferedReader.readLine()))).isEqualTo("0A4B/nGame Over");
    }

        @Test
    public void guess_right() {
        GuessNumber guessNumber = new GuessNumber();
        Game game = new Game();
        ProduceNumber produceNumber = mock(ProduceNumber.class);
        when(produceNumber.getNumber()).thenReturn("1234");
        InputNumber inputNumber = mock(InputNumber.class);
        when(inputNumber.getNumber()).thenReturn("4321");
        assertThat(game.showResult(guessNumber.compare(produceNumber.getNumber(), inputNumber.getNumber()))).isEqualTo("0A4B/nPlease input your number (5)/n");
        when(inputNumber.getNumber()).thenReturn("1234");
        assertThat(game.showResult(guessNumber.compare(produceNumber.getNumber(), inputNumber.getNumber()))).isEqualTo("Congratulations!");
    }
}
