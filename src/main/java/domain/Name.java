package domain;

public class Name {
    private static final String NAME_STYLE = "^[a-zA-Z0-9_-]+$";

    private final String name;

    public Name (String inputName) {
        validateLength(inputName);
        validateStyle(inputName);
        this.name = inputName;
    }

    private void validateLength(String inputName) {
        if (inputName.length() < 1 || inputName.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 1글자 이상 5글자 이하여야 합니다.");
        }
    }

    private void validateStyle(String inputName) {
//        Pattern pattern = Pattern.compile("^a-zA-Z0-9_-]+$");
//        if (!pattern.matcher(inputName).find()) {
//            throw new IllegalArgumentException("이름은 영어, 숫자, '_', '-'로만 이루어져야 합니다.");
//        }
//        위의 코드와 아래의 코드가 같은 기능을 하는데, 우리가 생각하는 차이점은 Pattern 객체를 만드는 것 외에는 없는 것 같다.
//        그 외의 차이점이 있거나, 위의 코드를 사용해야 할 일이 있는지 궁금합니다. 물어보기

        if (!inputName.matches(NAME_STYLE)){
            throw new IllegalArgumentException("이름은 영어, 숫자, '_', '-'로만 이루어져야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
