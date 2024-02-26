package domain;

public class Member {

    private final Name name;

    public Member(String rawName) {
        this.name = new Name(rawName);
    }

    public String getName() {
        return name.getName();
    }
}
