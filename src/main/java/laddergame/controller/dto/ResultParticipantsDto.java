package laddergame.controller.dto;

import laddergame.domain.participant.Participant;

import java.util.List;

public class ResultParticipantsDto {

    private final boolean isProceed;
    private final List<Participant> participants;

    public ResultParticipantsDto(final List<Participant> participants, final boolean isProceed) {
        this.participants = participants;
        this.isProceed = isProceed;
    }

    public static ResultParticipantsDto create(final List<Participant> participants, final boolean isProceed) {
        return new ResultParticipantsDto(participants, isProceed);
    }

    public boolean isProceed() {
        return isProceed;
    }

    public List<Participant> getParticipants() {
        return List.copyOf(participants);
    }
}
