package util;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class RandomBinaryNumbers {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 1;

    private RandomBinaryNumbers() {
    }

    public static List<Integer> pickNumbers(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> getBinaryNumber())
                .collect(toList());
    }

    private static int getBinaryNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
