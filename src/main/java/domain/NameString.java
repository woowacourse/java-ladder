package domain;

class NameString {
    static String from(Name name) {
        String nameString = name.getName();
        if (nameString.length() < 5) {
            nameString = nameString + " ";
        }
        int nameStringLength = nameString.length();
        return " ".repeat(5 - nameStringLength) + nameString;
    }
}
