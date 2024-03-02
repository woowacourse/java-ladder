package dto;

import java.util.Map;

public record GameResultsDto(Map<ParticipantName, PrizeName> gameResults) {
}
