package com.woowacourse.laddergame.domain.vo;

import com.woowacourse.laddergame.util.Duplicate;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerNamesVo {
    private static final Pattern TOTAL_PLAYER_NAMES_PATTERN = Pattern.compile("^([A-Za-z]{1,5})(,([A-Za-z]{1,5}))+$");
    private static final String ILLEGAL_NAME = "all";
    private static final String DELIMINATOR = ",";
    private final List<String> playerNames;

    public PlayerNamesVo(String names) {
        checkValidation(names);
        playerNames = Arrays.asList(names.split(DELIMINATOR));
    }

    private void checkValidation(String names) {
        checkNull(names);
        checkPattern(names);
        checkIllegalName(names);
        checkDuplicate(names);
    }

    private void checkNull(String names) {
        if (names == null) {
            throw new IllegalArgumentException("Null 은 입력할 수 없습니다");
        }
    }

    private void checkPattern(String names) {
        Matcher matcher = TOTAL_PLAYER_NAMES_PATTERN.matcher(names);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Player 이름들이 잘못되었습니다");
        }
    }

    private void checkIllegalName(String names) {
        List<String> playerNames = Arrays.asList(names.split(DELIMINATOR));
        if (playerNames.contains(ILLEGAL_NAME)) {
            throw new IllegalArgumentException("all은 player 이름으로 입력할 수 없습니다");
        }
    }

    private void checkDuplicate(String names) {
        List<String> playerNames = Arrays.asList(names.split(DELIMINATOR));
        if (Duplicate.check(playerNames)) {
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다");
        }
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public int size() {
        return playerNames.size();
    }

    public boolean contains(String name) {
        return playerNames.contains(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerNamesVo)) return false;
        PlayerNamesVo that = (PlayerNamesVo) o;
        return Objects.equals(getPlayerNames(), that.getPlayerNames());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayerNames());
    }
}
