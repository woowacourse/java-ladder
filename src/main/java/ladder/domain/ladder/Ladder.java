package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.Prize;
import ladder.domain.Prizes;
import ladder.domain.participant.Name;
import ladder.domain.participant.Participants;

public class Ladder {

    private static final int MIN_HEIGHT_RANGE = 1;
    private static final int MAX_HEIGHT_RANGE = 100;

    private final List<Floor> floors;

    public Ladder(int height, int personCount, RungGenerator rungGenerator) {
        validateHeightRange(height);
        floors = makeFloors(height, personCount, rungGenerator);
    }

    private void validateHeightRange(int height) {
        if (height < MIN_HEIGHT_RANGE || MAX_HEIGHT_RANGE < height) {
            throw new IllegalArgumentException(
                    "입력된 높이는 " + MIN_HEIGHT_RANGE + " 이상,"
                            + " " + MAX_HEIGHT_RANGE + " 이하여야 합니다. 입력값 : " + height);
        }
    }

    private List<Floor> makeFloors(int height, int personCount, RungGenerator rungGenerator) {
        return IntStream.range(0, height)
                .mapToObj(currentHeight -> new Floor(rungGenerator, personCount))
                .toList();
    }


    public Prizes getSortedPrizesResult(Participants participants, Prizes prizes) {
        List<Name> copiedNames = participants.getNames();

        List<Name> ladderResultNames = climbDown(copiedNames);

        List<Prize> sortedPrizeResult = getSortedPrizeResult(participants, ladderResultNames, prizes);

        return new Prizes(sortedPrizeResult);
    }

    private List<Name> climbDown(List<Name> copiedNames) {
        for (Floor floor : floors) {
            List<Integer> existRungPositions = floor.getExistRungPositions();
            swapPosition(copiedNames, existRungPositions);
        }
        return copiedNames;
    }

    private void swapPosition(List<Name> copiedNames, List<Integer> existRungPositions) {
        for (Integer existRungPosition : existRungPositions) {
            Collections.swap(copiedNames, existRungPosition, existRungPosition + 1);
        }
    }

    private List<Prize> getSortedPrizeResult(Participants participants, List<Name> ladderResultNames,
                                             Prizes prizes) {
        List<Prize> sortedPrizeNames = new ArrayList<>();
        for (Name participantName : participants.getNames()) {
            int resultPosition = ladderResultNames.indexOf(participantName);
            sortedPrizeNames.add(prizes.getPrizeByIndex(resultPosition));
        }
        return sortedPrizeNames;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
