package domain;

import static domain.Name.MAX_NAME_LENGTH;

class NameStringMaker {
    private NameStringMaker() {
        
    }

    static String make(Name name) {
        String nameString = name.getName();
        if (nameString.length() < MAX_NAME_LENGTH) {
            nameString = nameString + " ";
        }
        int nameStringLength = nameString.length();
        return " ".repeat(MAX_NAME_LENGTH - nameStringLength) + nameString;
    }
}
