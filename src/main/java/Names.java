import java.util.ArrayList;
import java.util.List;

public class Names {
    private final List<Name> value;

    private Names(List<Name> value) {
        this.value = value;
    }

    public static Names from(List<String> value){
        return new Names(value.stream().map(Name::new).toList());
    }
    public List<Name> getValue() {
        return value;
    }
}
