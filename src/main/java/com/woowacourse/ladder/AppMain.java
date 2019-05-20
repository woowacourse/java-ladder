package com.woowacourse.ladder;

import com.woowacourse.ladder.domain.*;
import com.woowacourse.ladder.view.InputView;
import com.woowacourse.ladder.view.OutputView;

public class AppMain {
    private static final String QUERY_ALL = "all";

    public static void main(String[] args) {
        ParticipantGroup participants = createParticipantGroup();
        DestinationGroup destinations = createDestinationGroup();
        while (participants.size() != destinations.size()) {
            OutputView.printError("참가자와 실행 결과의 수가 다릅니다.");
            participants = createParticipantGroup();
            destinations = createDestinationGroup();
        }
        LadderHeight height = getLadderHeight();
        LadderState state = new LadderState(participants.size(), height, new RandomBooleanGenerator());
        OutputView.printLadder(state, participants, destinations);

        String query = InputView.promptResultQuery();
        while (!query.isEmpty()) {
            tryHandleQuery(query, participants, destinations, state);
            query = InputView.promptResultQuery();
        }
    }

    private static ParticipantGroup createParticipantGroup() {
        ParticipantGroup participants = tryCreateParticipantGroup();
        while (participants == null) {
            participants = tryCreateParticipantGroup();
        }
        return participants;
    }

    private static ParticipantGroup tryCreateParticipantGroup() {
        try {
            return new ParticipantGroup(InputView.promptNames());
        } catch (IllegalArgumentException e) {
            OutputView.printError("올바르지 않은 참가자 입력입니다.");
        }
        return null;
    }

    private static DestinationGroup createDestinationGroup() {
        DestinationGroup destinations = tryCreateDestinationGroup();
        while (destinations == null) {
            destinations = tryCreateDestinationGroup();
        }
        return destinations;
    }

    private static DestinationGroup tryCreateDestinationGroup() {
        try {
            return new DestinationGroup(InputView.promptResults());
        } catch (IllegalArgumentException e) {
            OutputView.printError("올바르지 않은 결과 입력입니다.");
        }
        return null;
    }

    private static LadderHeight getLadderHeight() {
        LadderHeight height = tryGetLadderHeight();
        while (height == null) {
            height = tryGetLadderHeight();
        }
        return height;
    }

    private static LadderHeight tryGetLadderHeight() {
        try {
            return new LadderHeight(InputView.promptHeight());
        } catch (IllegalArgumentException e) {
            OutputView.printError("올바르지 않은 높이입니다.");
        }
        return null;
    }

    private static void tryHandleQuery(String query, ParticipantGroup participants, DestinationGroup destinations, LadderState state) {
        try {
            handleQuery(query, participants, destinations, state);
        } catch (IllegalArgumentException e) {
            OutputView.printError("올바르지 않은 입력입니다.");
        }
    }

    private static void handleQuery(String query, ParticipantGroup participants, DestinationGroup destinations, LadderState state) {
        ParticipantGroup participantsToPrint = getParticipantsToPrint(query, participants);
        ResultPair resultPairs = new ResultPair();

        participantsToPrint.forEachParticipants(p -> {
            Position pos = new Position(participants.positionOf(p), participants.size());
            resultPairs.addPair(p, Ladder.match(pos, state).getMatchDestination(destinations));
        });

        OutputView.printResult(resultPairs);
    }

    private static ParticipantGroup getParticipantsToPrint(String query, ParticipantGroup allParticipants) {
        if (isQueryAll(query)) {
            return allParticipants;
        }
        ParticipantGroup participantsToMatch = new ParticipantGroup(query);
        if (allParticipants.contains(participantsToMatch)) {
            return new ParticipantGroup(query);
        }

        throw new IllegalArgumentException();
    }

    private static boolean isQueryAll(String query) {
        return query.trim().toLowerCase().equals(QUERY_ALL);
    }


}
