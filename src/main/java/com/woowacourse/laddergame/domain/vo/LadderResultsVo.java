package com.woowacourse.laddergame.domain.vo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LadderResultsVo {
    private static final Pattern TOTAL_RESULT_PATTERN = Pattern.compile("^([ㄱ-ㅎㅏ-ㅣ가-힣A-Za-z0-9]{1,5})(,[ㄱ-ㅎㅏ-ㅣ가-힣A-Za-z0-9]{1,5})+$");
    private static final String DELIMINATOR = ",";
    private final List<String> ladderResults;

    public LadderResultsVo(String results) {
        checkValidation(results);
        ladderResults = Arrays.asList(results.split(DELIMINATOR));
    }

    void checkValidation(String results) {
        checkNull(results);
        checkPattern(results);
    }

    void checkNull(String results) {
        if (results == null) {
            throw new IllegalArgumentException("Null 은 입력할 수 없습니다");
        }
    }

    void checkPattern(String results) {
        Matcher matcher = TOTAL_RESULT_PATTERN.matcher(results);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Result 값이 잘못 되었습니다");
        }
    }

    public List<String> getLadderResults() {
        return ladderResults;
    }

    public int size() {
        return ladderResults.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderResultsVo)) return false;
        LadderResultsVo that = (LadderResultsVo) o;
        return Objects.equals(getLadderResults(), that.getLadderResults());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLadderResults());
    }
}
