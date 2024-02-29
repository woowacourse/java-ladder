package ladder.domain.ladderGame;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.dto.MadeLadderDto;

public class LadderResult {

    private final Map<Integer, Integer> ladderStartEndMapping;

    public LadderResult(MadeLadderDto madeLadder, int stepSpaceCount) {
        this.ladderStartEndMapping = mapLadderPosition(madeLadder, stepSpaceCount,
                madeLadder.madeLines().size());
    }

    public Integer getEndPosition(int participantPosition) {
        return ladderStartEndMapping.get(participantPosition);
    }

    private Map<Integer, Integer> mapLadderPosition(MadeLadderDto madeLadder, int stepSpaceCount,
                                                    int lineCount) {
        Map<Integer, Integer> ladderMap = new HashMap<>();
        List<Integer> initPosition = initStartPosition(stepSpaceCount);

        for (int position = 0; position < lineCount; position++) {
            findMapPosition(position, madeLadder, stepSpaceCount - 1, initPosition);
        }

        for (int stepPosition = 0; stepPosition < stepSpaceCount; stepPosition++) {
            ladderMap.put(initPosition.get(stepPosition), stepPosition);
        }
        return Collections.unmodifiableMap(ladderMap);
    }

    private List<Integer> initStartPosition(int participantCount) {
        return IntStream.range(0, participantCount)
                .boxed()
                .collect(Collectors.toList());
    }

    private void findMapPosition(int linePosition, MadeLadderDto ladder, int maxPosition,
                                 List<Integer> startPosition) {
        for (int position = 0; position < maxPosition; position++) {
            swapStartPositions(linePosition, ladder, startPosition, position);
        }
    }

    private void swapStartPositions(int linePosition, MadeLadderDto madeLines, List<Integer> startPositionMock,
                                    int position) {
        if (madeLines.checkLineStepStatus(linePosition, position)) {
            Collections.swap(startPositionMock, position, position + 1);
        }
    }
}
