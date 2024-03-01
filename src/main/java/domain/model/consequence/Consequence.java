package domain.model.consequence;

public class Consequence {
    private final String value;

    public Consequence(String value) {
        validateSize(value);
        this.value = value;
    }
    private void validateSize(String value){
        if(value.isBlank()){
            throw new IllegalArgumentException("결과에 공백값은 허용되지 않습니다.");
        }
    }
    public String getValue() {
        return value;
    }
}
