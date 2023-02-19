package laddergame.fixture;

import laddergame.domain.Name;
import laddergame.domain.Participants;

import java.util.List;

public abstract class ParticipantsFixture {
    public static Participants createParticipantsSize2() {
        return new Participants(List.of(new Name("rosie"), new Name("hyena")));
    }

    public static Participants createParticipantsSize3() {
        return new Participants(List.of(new Name("rosie"), new Name("hyena"), new Name("jayon")));

    }
}
