package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import ladder.dto.NamesDto;
import ladder.util.StringSplitter;

public class Names {

    private final List<Name> names;

    public Names(String names) {
        this.names = StringSplitter.split(names, ",")
                .stream()
                .map(Name::new)
                .collect(Collectors.toList());
        validateNames();
    }

    private void validateNames() {
        if (isAlone()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isAlone() {
        return names.size() <= 1;
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
