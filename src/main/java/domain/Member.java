package domain;

public class Member {

    private final int id;
    private final Name name;

    private Member(int id, Name name) {
        this.id = id;
        this.name = name;
    }

    public static Member from(int id, String rawName) {
        return new Member(id, Name.from(rawName));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name.getName();
    }
}
