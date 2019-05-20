package ladder.view;

import ladder.domain.LadderResult;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerException {
    public static final int MIN_PLAYER_COUNT = 1;
    public static final int MAX_NAME_LENGTH = 5;

    public static final String EX_PLAYER_COUNT = "참여자는 한명 이상이어야합니다.";
    public static final String EX_NAME_DUPLE = "이름은 중복 없이 넣어주세요";
    public static final String EX_NAME_ALL = "all은 이름으로 사용할 수 없습니다.";
    public static final String EX_NAME = "이름은 1글자 이상 5글자 이하로 입력하셔야 합니다.";

    /**
     * 규칙 : 이름은 5글자 이하
     * <br> 규칙 : 사용자는 1명 이상
     * <br> 규칙 : 중복 허용 불가
     * <br> 규칙 : 이름이 all이면 안됨(LADDERRESULT_GET_RESULT_ALL)
     *
     * @param inputNames 입력받은 사용자 이름들
     * @return inputNames
     * @throws IllegalArgumentException
     */
    public static String playerNames(String inputNames) {
        inputNames = inputNames.replaceAll(" ", "");
        List<String> names = playerNamesMinSize(
                Arrays.asList(inputNames.split(","))
        );
        for (String name : playerDuple(names)) {
            playerNameOverLength(name);
            playerNameCheckAll(name);
        }
        return inputNames;
    }

    /**
     * 규칙 : 사용자는 한 명 이상이어야 한다
     * <br> 기준 : MIN_PLAYER_COUNT
     *
     * @param names 사용자 이름들
     * @return names
     * @throws IllegalArgumentException EX_PLAYER_COUNT
     */
    public static List<String> playerNamesMinSize(List<String> names) {
        if (names.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(EX_PLAYER_COUNT);
        }
        return names;
    }

    /**
     * 규칙 : 중복 허용 불가
     *
     * @param names 사용자 이름들
     * @return names
     * @throws IllegalArgumentException
     */
    private static List<String> playerDuple(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException(EX_NAME_DUPLE);
        }
        return names;
    }

    /**
     * 규칙 : 이름은 all이면 안된다.
     * <br> 기준 : LadderResult.LADDERRESULT_GET_RESULT_ALL
     *
     * @param name 이름 하나
     * @return name
     * @throws IllegalArgumentException EX_NAME_ALL
     */
    private static String playerNameCheckAll(String name) {
        if (name.equals(LadderResult.LADDERRESULT_GET_RESULT_ALL)) {
            throw new IllegalArgumentException(EX_NAME_ALL);
        }
        return name;
    }

    /**
     * 규칙 : 이름 하나의 길이는 5자 이하여야한다
     * <br> 기준 : MAX_NAME_LENGTH
     *
     * @param name 이름 하나
     * @return name
     * @throws IllegalArgumentException EX_NAME
     */
    public static String playerNameOverLength(String name) {
        if (StringUtils.isBlank(name) || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(EX_NAME);
        }
        return name;
    }

    /**
     * 규칙 : 사용자는 한 명 이상이어야 한다
     * <br> 기준 : MIN_PLAYER_COUNT
     *
     * @param playerCount 사용자 수
     * @return playerCount
     * @throws IllegalArgumentException EX_PLAYER_COUNT
     */
    public static int playersMinCount(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(EX_PLAYER_COUNT);
        }
        return playerCount;
    }
}
