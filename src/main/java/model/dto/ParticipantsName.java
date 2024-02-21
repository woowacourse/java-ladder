package model.dto;

import java.util.List;
import model.Participant;
import model.Participants;

public record ParticipantsName(List<String> names) {
    public ParticipantsName(Participants participants) {
        this(participants.getParticipants().stream().map(Participant::getName).toList());
    }
}
