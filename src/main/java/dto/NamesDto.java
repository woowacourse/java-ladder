package dto;

import domain.Names;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NamesDto {
    private final List<String> names;

    private NamesDto(List<String> names) {
        this.names = names;
    }

    public static NamesDto from(Names names){
        return new NamesDto(names.getNames());
    }

    public List<String> getNames() {
        return names;
    }

    public int getMaxNameLength() {
        return Collections.max(names.stream()
                .map(String::length)
                .collect(Collectors.toList()));
    }
}
