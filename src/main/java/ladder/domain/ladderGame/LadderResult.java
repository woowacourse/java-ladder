package ladder.domain.ladderGame;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.dto.MadeLadderDto;
import ladder.domain.dto.MadeLineDto;

public class LadderResult {

    private final Map<Integer, Integer> ladderStartEndMapping;

    public LadderResult(MadeLadderDto madeLadder, int stepSpaceCount) {
        this.ladderStartEndMapping = mapLadderPosition(madeLadder, stepSpaceCount,
                madeLadder.madeLine().size());
    }

    public Integer getEndPosition(int participantPosition) {
        return ladderStartEndMapping.get(participantPosition);
    }

    private Map<Integer, Integer> mapLadderPosition(MadeLadderDto madeLadder, int stepSpaceCount,
                                                    int lineCount) {
        List<MadeLineDto> MadeLineDtos = madeLadder.madeLine();

        Map<Integer, Integer> ladderMap = new HashMap<>();

        List<Integer> initPosition = initPosition(stepSpaceCount);

        for (int i = 0; i < lineCount; i++) {// 세로 4번 == 사람 수
            findMapPosition(i, MadeLineDtos, stepSpaceCount - 1, initPosition);
        }

        for (int k = 0; k < stepSpaceCount; k++) { // 가로 수
            ladderMap.put(initPosition.get(k), k);
        }
        return Collections.unmodifiableMap(ladderMap);
    }

    private void findMapPosition(int startIdx, List<MadeLineDto> madeLines, int max,
                                 List<Integer> participantPosition) {
        for (int j = 0; j < max; j++) {
            if (madeLines.get(startIdx).line().get(j).getBuildStatus()) {
                Collections.swap(participantPosition, j, j + 1);
            }
        }
    }

    private List<Integer> initPosition(int participantCount) {
        return IntStream.range(0, participantCount)
                .boxed()
                .collect(Collectors.toList());
    }

}
