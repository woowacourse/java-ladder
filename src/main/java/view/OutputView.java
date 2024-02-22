package view;

import domain.Bridge;
import domain.Ladder;
import domain.Name;

import java.util.List;

public class OutputView {
    private static final String LADDER_LEFT_SIDE = "     |";
    private static final String BRIDGE_EXIST = "-----|";
    private static final String BRIDGE_EMPTY = "     |";

    public static void printResult(final List<Name> names,final Ladder ladder, final int height) {
        System.out.println("실행 결과\n");

        printPlayers(names);
        printLadder(names, ladder, height);
    }

    private static void printPlayers(final List<Name> names) {
        for (Name name : names) {
            System.out.printf("%6s", name.name());
        }
        System.out.println();
    }

    private static void printLadder(final List<Name> names, final Ladder bridges, final int ladderHeight) {
        for (int height = 0; height < ladderHeight; height++) {
            System.out.print(LADDER_LEFT_SIDE);
            printOneLine(names, bridges, height);
            System.out.println();
        }
    }

    private static void printOneLine(final List<Name> names, final Ladder bridges, final int y) {
        for (int x = 0; x < names.size() - 1; x++) {
            Bridge bridge = new Bridge(x, y);
            System.out.print(getBridgeSymbol(bridges, bridge));
        }
    }

    private static String getBridgeSymbol(final Ladder bridges, final Bridge bridge) {
        if (bridges.getBridges().contains(bridge)) {
            return BRIDGE_EXIST;
        }
        return BRIDGE_EMPTY;
    }
}
