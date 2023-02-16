package ladder.view;


import java.util.List;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }
    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printPlayerNames(List<String> playerNames){
        playerNames.stream().forEach(name->System.out.print(String.format("%6s", name)));
    }

}
