package dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NamesDto {
    private final List<String> names;

    public NamesDto(List<String> names) {
        this.names = names;
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
