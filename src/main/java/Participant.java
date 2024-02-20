public class Participant {

    private final String name;

    public Participant(String name) {
        this.name = name;
        throw new IllegalArgumentException("참여자의 이름은 최대 5글자입니다.");
    }
}
