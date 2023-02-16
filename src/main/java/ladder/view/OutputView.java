package ladder.view;


import java.util.List;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printPlayerNames(List<String> playerNames) {
        System.out.print("  ");
        playerNames.stream().forEach(name -> System.out.print(String.format("%-6s", name)));
    }

    public void printRow(List<Boolean> points) {
        System.out.println();
        System.out.print("  |");
        for (boolean point : points) {
            if (point) {
                System.out.print("-----|");
            }
            if (!point) {
                System.out.print("     |");
            }
        }
    }


}
