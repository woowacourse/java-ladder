package view;

import domain.name.Names;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printPlayerNames(Names players) {
        int maxLength = players.findMaxNameLength();
        players.getNames().stream()
                .map(name -> alignNameCenter(name, maxLength + 1))
                .forEach(System.out::print);
        System.out.println();
    }

    private static String alignNameCenter(String name, int length) {
        int spaces = length - name.length();
        int left = spaces / 2;
        int right = spaces - left;
        return " ".repeat(left) + name + " ".repeat(right);
    }

    public static String printLadder(int length, List<Boolean> rungs) {
        String DISCONNECTED_RUNG = " ";
        String CONNECTED_RUNG = "-";
        String LADDER_SIDE = "|";

        return " ".repeat(length) + rungs.stream()
                .map(rung -> makeRung(length, rung))
                .collect(Collectors.joining("|", "|", "|"));
    }

    private static String makeRung(int length, boolean rung) {
        if (rung) {
            return "-".repeat(length);
        }
        return " ".repeat(length);
    }
}
