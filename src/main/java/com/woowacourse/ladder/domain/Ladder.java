package com.woowacourse.ladder.domain;

import com.woowacourse.ladder.interfaces.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Ladder {
    private List<LadderRow> rows;

    public Ladder(int numOfParticipants, int height, BooleanGenerator booleanGenerator) {
        rows = new ArrayList<>();
        createRowsAndExplore(numOfParticipants, height, booleanGenerator);
    }

    private void createRowsAndExplore(int numOfParticipants, int height, BooleanGenerator booleanGenerator) {
        // height 만큼의 Row 생성
        for (int i = 0; i < height; i++) {
            // 각 Row는 numOfParticipants - 1 크기의 Boolean 리스트를 가짐
            rows.add(new LadderRow(numOfParticipants - 1, booleanGenerator));
        }
    }

    /**
     * 생성된 사다리에 인자로 명시된 참가자와 목적지 그룹을 매치한 결과를 생성
     * @param participants 참가자 리스트
     * @param destinations 목적지 리스트
     * @return 사다리 매치 결과
     */
    public LadderResult explore(List<String> participants, List<String> destinations) {
        ParticipantGroup result = new ParticipantGroup(participants);
        for (LadderRow row : rows) {
            result = row.swapNames(result);
        }

        return new LadderResult(result, new DestinationGroup(destinations));
    }

    public void forEachRows(Consumer<LadderRow> consumer) {
        rows.forEach(consumer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderRow row : rows) {
            sb.append(row).append('\n');
        }
        return sb.toString();
    }
}
