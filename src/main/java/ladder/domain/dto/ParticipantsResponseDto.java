package ladder.domain.dto;

import java.util.List;
import ladder.domain.participant.Name;
import ladder.domain.participant.Participants;

public record ParticipantsResponseDto(List<String> participantNames) {

    public static ParticipantsResponseDto from(Participants participants) {
        List<String> participantsNames = participants.getNames().stream()
                .map(Name::getName)
                .toList();

        return new ParticipantsResponseDto(participantsNames);
    }
}
