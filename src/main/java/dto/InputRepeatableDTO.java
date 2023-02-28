package dto;

import java.util.List;

public class InputRepeatableDTO {

    private final List<String> names;
    private final boolean repeatable;

    private InputRepeatableDTO(final List<String> names, final boolean repeatable) {
        this.names = names;
        this.repeatable = repeatable;
    }

    public static InputRepeatableDTO repeatable(final List<String> data) {
        return new InputRepeatableDTO(data, true);
    }

    public static InputRepeatableDTO unrepeatable(final List<String> data) {
        return new InputRepeatableDTO(data, false);
    }

    public List<String> getNames() {
        return names;
    }

    public boolean isRepeatable() {
        return repeatable;
    }
}
