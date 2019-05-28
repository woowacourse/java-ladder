package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class BooleanListGenerator {
    public static List<Boolean> generateBoolList(int nameLength) {
        List<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < nameLength - 1; i++) {
            booleans = addBoolean(booleans, i);
        }
        return booleans;
    }

    private static List<Boolean> addBoolean(List<Boolean> booleans, int i) {
        if (i == 0) {
            booleans = addBooleanIfZero(booleans);
            return booleans;
        }
        if (!booleans.get(i - 1) && (isBuildBridge())) {
            booleans.add(true);
            return booleans;
        }

        booleans.add(false);
        return booleans;
    }

    private static List<Boolean> addBooleanIfZero(List<Boolean> booleans) {
        booleans.add(isBuildBridge());
        return booleans;
    }

    private static boolean isBuildBridge() {
        return (int) (Math.random() * 2) == 1;
    }


}
