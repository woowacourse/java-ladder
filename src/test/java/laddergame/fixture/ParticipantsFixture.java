package laddergame.fixture;

import laddergame.domain.Participants;

import java.util.ArrayList;
import java.util.List;

public abstract class ParticipantsFixture {
    public static Participants createParticipants(final int size) {
        final List<String> nameValues = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            nameValues.add("name" + count);
        }
        return new Participants(nameValues);
    }
}
