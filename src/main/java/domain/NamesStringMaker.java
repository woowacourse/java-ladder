package domain;

import java.util.stream.Collectors;

class NamesStringMaker {
    private NamesStringMaker() {

    }

    static String make(Names names) {
        return names.getNames().stream()
                .map(NameStringMaker::make)
                .collect(Collectors.joining(" "));
    }
}
