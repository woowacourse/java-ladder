package domain.player;

public class Name {
    private final String value;
    public Name(String value){
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    private void validate(String inputName){
        validateAvailableLength(inputName);
        validateBlank(inputName);
        validateContainBlankInName(inputName);
    }
    private void validateAvailableLength(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
    private void validateBlank(String initialInput) {
        if(initialInput.isBlank()) {
            throw new IllegalArgumentException("공백으로 이루어진 이름은 사용할 수 없습니다.");
        }
    }
    private void validateContainBlankInName(String inputName) {
        if(inputName.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

}
