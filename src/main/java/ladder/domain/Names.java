package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import ladder.dto.NamesDto;

public class Names {

    private final List<Name> names;

    public Names(String names) {
        this.names = new NameSplitter(names).split()
                .stream()
                .map(Name::new)
                .collect(Collectors.toList());
        validateNames();
    }

    private void validateNames() {
        if (names.size() <= 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getCount() {
        return names.size();
    }

    public NamesDto toDto() {
        return new NamesDto(names.stream()
                .map(Name::toDto)
                .collect(Collectors.toList()));
    }
}
