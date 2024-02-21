package model.dto;

import model.Participant;

public record ParticipantName(String name) {
    public ParticipantName(Participant participant) {
        this(participant.getName());
    }
}
