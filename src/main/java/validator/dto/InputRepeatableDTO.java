package validator.dto;

import domain.vo.Names;

public class InputRepeatableDTO {

    private final Names names;
    private final boolean repeatable;

    private InputRepeatableDTO(final Names names, final boolean repeatable) {
        this.names = names;
        this.repeatable = repeatable;
    }

    public static InputRepeatableDTO repeatable(final Names data) {
        return new InputRepeatableDTO(data, true);
    }

    public static InputRepeatableDTO unrepeatable(final Names data) {
        return new InputRepeatableDTO(data, false);
    }

    public Names getNames() {
        return names;
    }

    public boolean isRepeatable() {
        return repeatable;
    }
}
