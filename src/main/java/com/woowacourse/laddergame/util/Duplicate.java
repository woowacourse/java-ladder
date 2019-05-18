package com.woowacourse.laddergame.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Duplicate {
    public static <E> boolean check(List<E> target) {
        Set<E> set = new HashSet<>(target);
        return set.size() != target.size();
    }
}
