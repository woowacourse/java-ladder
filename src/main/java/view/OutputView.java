package view;

import domain.Floors;
import domain.Name;
import java.util.List;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printResult(List<Name> names, Floors floors) {
        System.out.println("실행결과\n");
        names.forEach(name -> System.out.printf("%-5s", name.getName()));
    }
}
