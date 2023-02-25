package ladder.view;

public class OutputView {

    public static void printLadder(String names, String ladder, String results) {
        System.out.println(System.lineSeparator() + "사다리 결과" + System.lineSeparator());
        System.out.println(names);
        System.out.println(ladder);
        System.out.println(results);
    }

    public static void printSingleResult(String result) {
        System.out.println(System.lineSeparator() + "실행 결과");
        System.out.println(result);
    }

    public static void printAllResult(String allResult) {
        System.out.print(System.lineSeparator() + "실행 결과" + System.lineSeparator());
        System.out.print(allResult);
    }
}
