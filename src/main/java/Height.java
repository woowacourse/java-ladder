public class Height {

    private final int height;

    public Height(String inputNumber){
        validate(inputNumber);
        this.height = Integer.parseInt(inputNumber);
    }

    private void validate(String inputNumber){
        validateIsNumeric(inputNumber);
        validateSize(inputNumber);
    }

    private void validateIsNumeric(String inputNumber) {
        if (!inputNumber.matches("\\d+")) {
            throw new IllegalArgumentException("높이는 숫자만 입력 가능합니다.");
        }
    }
    private void validateSize(String inputNumber){
        if(Integer.valueOf(inputNumber) <= 0){
            throw new IllegalArgumentException("높이는 1 이상이여야 합니다.");
        }
    }
    public int getHeight() {
        return height;
    }
}
