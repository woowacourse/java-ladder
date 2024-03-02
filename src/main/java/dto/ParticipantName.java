package dto;

import model.participant.Participant;

public record ParticipantName(String name) {
    public ParticipantName(Participant participant) {
        this(participant.getName());
    }
}
