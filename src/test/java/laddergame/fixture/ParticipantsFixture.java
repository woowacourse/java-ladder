package laddergame.fixture;

import laddergame.domain.Name;
import laddergame.domain.Participants;

import java.util.List;

public abstract class ParticipantsFixture {
    public static Participants getParticipantsSize2() {
        return new Participants(List.of(new Name("rosie"), new Name("hyena")));
    }

    public static Participants getParticipantsSize3() {
        return new Participants(List.of(new Name("rosie"), new Name("hyena"), new Name("jayon")));

    }
}
