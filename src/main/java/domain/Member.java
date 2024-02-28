package domain;

public class Member {

    private final MemberName name;

    public Member(String rawName) {
        this.name = new MemberName(rawName);
    }

    public String getName() {
        return name.getName();
    }
}
