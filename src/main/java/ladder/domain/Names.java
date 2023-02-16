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

    private static void validateNames(String names) {
        //todo 형식1 : 형식2 와 비교했을 때, 어떤 메서드가 더 적절한 것 같나요?
        validateNull(names);
        validateFormat(names);
    }

    private static void validateFormat(String names) {
        if (!NAMES_FORMAT.matcher(names).matches()) {
            throw new IllegalArgumentException("이름이 형식과 맞지 않습니다");
        }
    }

    private static void validateNull(String names) {
        if (names == null) {
            throw new IllegalArgumentException("이름이 null 입니다");
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
