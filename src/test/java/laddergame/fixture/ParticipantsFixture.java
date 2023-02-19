package laddergame.fixture;

import laddergame.domain.Participants;

import java.util.List;

public abstract class ParticipantsFixture {
    public static Participants createParticipantsSize2() {
        final List<String> names = List.of("rosie", "hyena");
        return new Participants(names);
    }

    public static Participants createParticipantsSize3() {
        final List<String> names = List.of("rosie", "hyena", "jayon");
        return new Participants(names);
    }
}
