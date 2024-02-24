import game.LadderGame;
import java.util.Random;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner::nextLine);
        OutputView outputView = new OutputView();

        Random random = new Random();

        LadderGame ladderGame = new LadderGame(inputView, outputView, random::nextBoolean);
        ladderGame.play();
    }
}
