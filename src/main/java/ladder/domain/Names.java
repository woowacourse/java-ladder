package ladder.domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import ladder.dto.NamesDto;
import ladder.util.StringSplitter;

public class Names {

    protected static final Pattern NAMES_FORMAT = Pattern.compile("[^,]+(,[^,]+)+");
    protected final List<Name> names;

    public Names(String names) {
        validateNames(names);

        this.names = StringSplitter.split(names, ",")
            .stream()
            .map(Name::new)
            .collect(Collectors.toList());
    }

    private void validateNames(String names) {
        isNull(names);
        isFormat(names);
    }

    private void isNull(String names) {
        if (names == null) {
            throw new IllegalArgumentException("이름이 null 입니다");
        }
    }

    private void isFormat(String names) {
        if (!NAMES_FORMAT.matcher(names).matches()) {
            throw new IllegalArgumentException("이름이 형식과 맞지 않습니다");
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
