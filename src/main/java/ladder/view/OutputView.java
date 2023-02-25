package ladder.view;

public class OutputView {

    public void printLadderShape(String ladder) {
        printInfo();
        System.out.println(ladder);
    }

    private void printInfo() {
        printEmptyLine();
        System.out.println("사다리 결과");
        printEmptyLine();
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printMatchResult(String matchResult) {
        printEmptyLine();
        System.out.println("실행 결과");
        System.out.println(matchResult);
        printEmptyLine();
    }
}
