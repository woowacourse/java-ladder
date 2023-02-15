package laddergame;

import laddergame.domain.Height;
import laddergame.domain.Participants;
import laddergame.domain.Person;

import java.util.List;

public class TestDummy {
    public static final Person PERSON_HYENA = new Person("헤나");
    public static final Person PERSON_ROSIE = new Person("로지");
    public static final Participants PARTICIPANTS = new Participants(List.of(PERSON_ROSIE, PERSON_ROSIE));
    public static final Height HEIGHT = new Height(1);
}
