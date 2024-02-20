package laddergame.view;

import java.util.List;

public class OutputView {

    public static void printNames(final List<String> names, final int width) {
        System.out.print(names.get(0) + " ");

        for (int i = 1; i < names.size() - 1; i++) {
            final String name = names.get(i);
            final String formattedName = String.format("%" + (width + 1) + "s", name);
            System.out.print(formattedName);
        }

        System.out.printf("%" + width + "s", names.get(names.size() - 1));
    }
}
