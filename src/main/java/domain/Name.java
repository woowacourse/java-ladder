package domain;

public class Name {

    String name;

    public Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 5글자를 초과할 수 없습니다.");
        }
    }


}
