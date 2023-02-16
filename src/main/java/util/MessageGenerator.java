package util;

import domain.Names;

public class MessageGenerator {

    public static String generateNamesMessage(Names names) {
        int maxNameLength = names.findMaxNameLength();
        StringBuilder stringBuilder = new StringBuilder();

        for (String name : names.getNames()) {
            stringBuilder.append(alignLeft(name, maxNameLength));
        }

        return stringBuilder.toString();
    }

    private static String alignLeft(final String name, final int length) {
        return String.format("%-" + length + "s ", name);
    }
}
