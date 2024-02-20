import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> value;

    public Names(List<String> value){
        validate(value);
        this.value = from(value);
    }

    private List<Name> from(List<String> value){
        return value.stream()
                    .map(Name::new)
                    .toList();
    }

    private void validate(List<String> value) {
        validateDuplicated(value);
    }

    private void validateDuplicated(List<String> value) {
        Set<String> duplicateSize = new HashSet<>(value);
        if (duplicateSize.size() != value.size()) {
            throw new IllegalArgumentException("중복된 이름이 포함되어 있습니다.");
        }
    }

    public List<Name> getValue() {
        return value;
    }
}
