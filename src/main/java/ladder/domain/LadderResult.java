package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.dto.ResultStepLadderDto;
import ladder.domain.dto.StepStatusDto;

public class LadderResult {

    private final Map<Integer, Integer> ladderMapping;

    public LadderResult(ResultStepLadderDto resultStepLadderDto, int participantCount) {
        this.ladderMapping = mapLadderPosition(resultStepLadderDto, participantCount,
                resultStepLadderDto.stepStatusDtos().size());
    }

    public Integer getEndPosition(int participantPosition) {
        return ladderMapping.get(participantPosition);
    }

    private Map<Integer, Integer> mapLadderPosition(ResultStepLadderDto resultStepLadderDto,
                                                    int totalStepAvailableCount,
                                                    int sero) {
        List<StepStatusDto> stepStatusDtos = resultStepLadderDto.stepStatusDtos();
        Map<Integer, Integer> ladderMap = new HashMap<>();
        List<Integer> initPosition = initPosition(totalStepAvailableCount);

        for (int i = 0; i < sero; i++) {// 세로 4번 == 사람 수
            initPosition = findMapPosition(i, stepStatusDtos, totalStepAvailableCount - 1, initPosition);
        }

        for (int k = 0; k < totalStepAvailableCount; k++) { // 가로 수
            ladderMap.put(initPosition.get(k), k);
        }
        return Collections.unmodifiableMap(ladderMap);
    }

    public List<Integer> findMapPosition(int startIdx, List<StepStatusDto> stepStatusDtos, int max,
                                         List<Integer> participantPosition) {
        for (int j = 0; j < max; j++) {
            if (stepStatusDtos.get(startIdx).builtStep().get(j).getBuildStatus()) {
                Collections.swap(participantPosition, j, j + 1);
            }
        }
        return participantPosition;
    }

    private List<Integer> initPosition(int participantCount) {
        return IntStream.range(0, participantCount)
                .boxed()
                .collect(Collectors.toList());
    }

}
