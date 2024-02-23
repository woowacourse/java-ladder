package domain;

public class Member {

    private final Name name;

    private Member(Name name) {
        this.name = name;
    }

    public static Member from(String rawName) {
        return new Member(Name.from(rawName));
    }

    public String getName() {
        return name.getName();
    }
}
