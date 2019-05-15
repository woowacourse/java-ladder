package com.woowacourse.ladder;

import com.woowacourse.ladder.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private static final String QUERY_TOKEN_DELIMITER = ",";

    public static <P, D> Ladder<P, D> createLadder(List<P> participants, List<D> destinations, int height) {
        checkAndThrowIfArgumentsInvalid(participants, destinations, height);
        return new LadderBuilder<P, D>()
            .withParticipants(participants)
            .withDestinations(destinations)
            .withGenerator(new RandomBooleanGenerator())
            .withHeight(height)
            .build();
    }

    private static <P, D> void checkAndThrowIfArgumentsInvalid(List<P> participants, List<D> destination, int height) {
        checkAndThrowIfListInvalid(participants, destination);
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
    }

    private static <P, D> void checkAndThrowIfListInvalid(List<P> participants, List<D> destination) {
        if (participants == null || destination == null) {
            throw new IllegalArgumentException("Null is included in arguments");
        }
        if (participants.isEmpty() || destination.isEmpty()) {
            throw new IllegalArgumentException("Participants and destination lists cannot be empty");
        }
        if (participants.size() != destination.size()) {
            throw new IllegalArgumentException("Sizes of participants list and destination list must be same");
        }
    }

    public static <D> List<MatchPair<String, D>> executeResultQuery(Ladder<String, D> ladder, String query) {
        List<String> tokens = Arrays.stream(query.split(QUERY_TOKEN_DELIMITER)).map(String::trim).collect(Collectors.toList());
        List<String> participants = new ArrayList<>();
        ladder.forEachParticipants(participants::add);

        return handleQuery(ladder.getResult(), tokens, participants);
    }

    private static <D> List<MatchPair<String, D>> handleQuery(LadderResult<String, D> result, List<String> tokens, List<String> participants) {
        if (checkIfShouldPrintAllResult(tokens)) {
            return participants.stream()
                .map(result::matchResult)
                .collect(Collectors.toList());
        }
        if (checkIfAllTokensMatch(result, tokens)) {
            if (tokens.size() == 1) {
                return Collections.singletonList(result.matchResult(tokens.get(0)));
            }
            return tokens.stream()
                .map(result::matchResult)
                .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("Query cannot be handled");
    }

    private static boolean checkIfShouldPrintAllResult(List<String> tokens) {
        if (tokens.isEmpty()) {
            return false;
        }
        return tokens.size() == 1 && tokens.get(0).toLowerCase().equals("all");
    }

    private static <D> boolean checkIfAllTokensMatch(LadderResult<String, D> result, List<String> tokens) {
        return tokens.stream()
            .filter(result::hasMatchResult)
            .count() == tokens.size();
    }
}
