package view;

class NamePrinter {
    static final int MAX_NAME_LENGTH = 5;

    static String from(String name) {
        if (name.length() < MAX_NAME_LENGTH) {
            name = name + " ";
        }
        int nameStringLength = name.length();
        return " ".repeat(MAX_NAME_LENGTH - nameStringLength) + name;
    }
}
