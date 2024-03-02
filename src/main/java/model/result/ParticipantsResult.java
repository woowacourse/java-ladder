package model.result;

import model.participant.Participant;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ParticipantsResult {
    protected static final String NOT_EXIST_PARTICIPANT = "존재하지 않는 참가자 입니다.";
    private final Map<Participant, Result> participantsResult;

    public ParticipantsResult(Map<Participant, Result> participantsResult) {
        this.participantsResult = new LinkedHashMap<>(participantsResult);
    }

    public Map<Participant, Result> getParticipantsResult() {
        return new LinkedHashMap<>(participantsResult);
    }

    public Result getResult(Participant participant) {
        if (participantsResult.containsKey(participant)) {
            return participantsResult.get(participant);
        }
        throw new IllegalArgumentException(NOT_EXIST_PARTICIPANT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantsResult that = (ParticipantsResult) o;
        return Objects.equals(participantsResult, that.participantsResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantsResult);
    }
}
