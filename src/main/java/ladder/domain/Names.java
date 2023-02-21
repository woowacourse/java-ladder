package ladder.domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import ladder.dto.NamesDto;
import ladder.util.StringSplitter;

public class Names {

    private static final Pattern NAMES_FORMAT = Pattern.compile("[^,]+(,[^,]+)+");
    private final List<Name> names;

    public Names(String names) {
        validateNames(names);

        this.names = StringSplitter.split(names, ",")
            .stream()
            .map(Name::new)
            .collect(Collectors.toList());
    }

    private void validateNames(String names) {
        if (isNull(names)) {
            throw new IllegalArgumentException("이름이 null 입니다");
        }
        if (isFormat(names)) {
            throw new IllegalArgumentException("이름이 형식과 맞지 않습니다");
        }
    }

    private boolean isNull(String names) {
        return names == null;
    }

    private boolean isFormat(String names) {
        return !NAMES_FORMAT.matcher(names).matches();
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
