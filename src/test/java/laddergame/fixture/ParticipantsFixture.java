package laddergame.fixture;

import laddergame.domain.Name;
import laddergame.domain.Participants;

import java.util.List;

public abstract class ParticipantsFixture {
    public static final Participants PARTICIPANTS_SIZE_2
            = new Participants(List.of(new Name("rosie"), new Name("hyena")));
    public static final Participants PARTICIPANTS_SIZE_3
            = new Participants(List.of(new Name("rosie"), new Name("hyena"), new Name("jayon")));
}
