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
        isAvailableLength(inputName);

    }
    private void isAvailableLength(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
