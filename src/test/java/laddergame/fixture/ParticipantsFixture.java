package laddergame.fixture;

import laddergame.domain.Name;
import laddergame.domain.Names;
import laddergame.domain.Participants;

import java.util.List;

public abstract class ParticipantsFixture {
    public static Participants createParticipantsSize2() {
        final List<Name> names = List.of(new Name("rosie"), new Name("hyena"));
        return new Participants(new Names(names));
    }

    public static Participants createParticipantsSize3() {
        final List<Name> names = List.of(new Name("rosie"), new Name("hyena"), new Name("jayon"));
        return new Participants(new Names(names));
    }
}
