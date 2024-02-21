import java.util.List;
import java.util.Scanner;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        List<String> name = inputView.readPlayersName();
        System.out.println("name = " + name);

        inputView.readHeight();
    }
}
