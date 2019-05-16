package com.woowacourse.ladder;

import com.woowacourse.ladder.domain.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private static final String QUERY_TOKEN_DELIMITER = ",";
    private static final String QUERY_ALL = "all";

    /**
     * @param participants participants list
     * @param destinations destinations list
     * @param height       height of the ladder
     * @return Created Ladder object
     * @throws NullPointerException     if one or more of the arguments are null
     * @throws IllegalStateException    if the participants list or destinations list is empty
     * @throws IllegalArgumentException if each size of participant list and destinations list is not equal, or height is less than zero or equal.
     */
    static Ladder createLadder(List<String> participants, List<String> destinations, int height) {
        checkAndThrowIfArgumentsInvalid(participants, destinations, height);
        return new Ladder(participants.size(), height, new RandomBooleanGenerator());
    }

    private static void checkAndThrowIfArgumentsInvalid(List<String> participants, List<String> destination, int height) {
        checkAndThrowIfListInvalid(participants, destination);
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
    }

    private static void checkAndThrowIfListInvalid(List<String> participants, List<String> destination) {
        if (participants == null || destination == null) {
            throw new NullPointerException("Null is included in arguments");
        }
        if (participants.isEmpty() || destination.isEmpty()) {
            throw new IllegalStateException("Participants and destination lists cannot be empty");
        }
        if (participants.size() != destination.size()) {
            throw new IllegalArgumentException("Sizes of participants list and destination list must be same");
        }
    }

    static List<MatchPair> executeResultQuery(LadderResult result, String query, List<String> participants) {
        List<String> tokens = Arrays.stream(query.split(QUERY_TOKEN_DELIMITER)).map(String::trim).collect(Collectors.toList());

        return handleQuery(result, tokens, participants);
    }

    private static List<MatchPair> handleQuery(LadderResult result, List<String> tokens, List<String> participants) {
        if (checkIfShouldPrintAllResult(tokens)) {
            return participants.stream()
                .map(result::matchResult)
                .collect(Collectors.toList());
        }
        if (checkIfAllTokensMatch(result, tokens)) {
            return getMatchPairs(result, tokens);
        }
        throw new IllegalArgumentException("Query cannot be handled");
    }

    private static List<MatchPair> getMatchPairs(LadderResult result, List<String> tokens) {
        if (tokens.size() == 1) {
            return Collections.singletonList(result.matchResult(tokens.get(0)));
        }
        return tokens.stream()
            .map(result::matchResult)
            .collect(Collectors.toList());
    }

    private static boolean checkIfShouldPrintAllResult(List<String> tokens) {
        if (tokens.isEmpty()) {
            return false;
        }
        return tokens.size() == 1 && tokens.get(0).toLowerCase().equals(QUERY_ALL);
    }

    private static boolean checkIfAllTokensMatch(LadderResult result, List<String> tokens) {
        return tokens.stream()
            .filter(result::hasMatchResult)
            .count() == tokens.size();
    }
}
