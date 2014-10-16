import com.thoughtworks.iamcoach.guessnumber.CompareNumber;
import com.thoughtworks.iamcoach.guessnumber.Game;
import com.thoughtworks.iamcoach.guessnumber.RandomNumber;
import java.io.BufferedInputStream;

public class App {
    public static void main(String[] args) {
        //TODO: Need to implement.

        RandomNumber randomNumber = new RandomNumber();
        String randomNum = randomNumber.get();

        Game game = new Game();
        game.start_game();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(System.in);

        CompareNumber compareNumber = new CompareNumber();
        String result1 = compareNumber.compare(randomNum, bufferedInputStream.toString());
        String result2 = compareNumber.compare(randomNum, bufferedInputStream.toString());
        String result3 = compareNumber.compare(randomNum, bufferedInputStream.toString());
        String result4 = compareNumber.compare(randomNum, bufferedInputStream.toString());
        String result5 = compareNumber.compare(randomNum, bufferedInputStream.toString());
        String result6 = compareNumber.compare(randomNum, bufferedInputStream.toString());

        game.showResult(result1);
        game.showResult(result2);
        game.showResult(result3);
        game.showResult(result4);
        game.showResult(result5);
        game.showResult(result6);
    }
}
