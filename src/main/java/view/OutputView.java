package view;

import domain.Bridge;
import domain.Name;
import java.util.List;

public class OutputView {

    public static void printLadder(List<Name> names, List<Bridge> bridges, int height) {
        System.out.println("실행 결과\n");

        for (Name name : names) {
            System.out.printf("%6s", name.getName());
        }
        System.out.println();

        for (int y = 0; y < height; y++) {
            System.out.print("     |");
            for (int x = 0; x < names.size() - 1; x++) {
                Bridge bridge = new Bridge(x, y);
                if (bridges.contains(bridge)) {
                    System.out.print("-----|");
                } else {
                    System.out.print("     |");
                }
            }
            System.out.println();
        }
    }

}
