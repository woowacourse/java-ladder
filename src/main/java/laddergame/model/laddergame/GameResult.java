package laddergame.model.laddergame;

import laddergame.model.executionresults.ExecutionResult;
import laddergame.model.participants.Participant;

public record GameResult(Participant participant, ExecutionResult executionResult) {
}
