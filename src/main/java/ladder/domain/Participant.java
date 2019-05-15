package ladder.domain;

public class Participant {
    private final String name ;
    public Participant(final String name){
        validateNameLength(name);
        this.name=name;
    }

    private void validateNameLength(String name){
        if(name.length()>5) throw new IllegalArgumentException("이름이 5글자가 넘어갑니다.");
    }


}
