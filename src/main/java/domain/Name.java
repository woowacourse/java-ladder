package domain;

public class Name {

    private final String name;

    public Name(final String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("5글자 이하를 입력해주세요.");
        }

        if(name.length() == 0){
            throw new IllegalArgumentException("한글자 이상 입력해주세요.");
        }
        this.name = name;
    }
}
