package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

// Consider rename this class to "LadderBoard"
public class Ladder {

    private List<String> result;
    private List<LadderRow> rows;

    public Ladder(List<String> names, int height, BooleanGenerator booleanGenerator) {
        rows = new ArrayList<>();
        result = new ArrayList<>(names);

        // height 만큼의 Row 생성
        for (int i = 0; i < height; i++) {
            // 각 Row는 n(name) - 1 만큼의 Boolean 리스트를 가짐
            rows.add(new LadderRow(names.size() - 1, booleanGenerator));
        }

        explore();
    }

    private void explore() {
        for (LadderRow row : rows) {
            result = row.swapNames(result);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderRow row : rows) {
            sb.append(row).append('\n');
        }
        return sb.toString();
    }


    public int findDestination(String name) {
        return result.indexOf(name);
    }
}
