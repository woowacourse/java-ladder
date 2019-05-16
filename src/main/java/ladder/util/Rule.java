package ladder.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 데이터 형식 규칙 클래스
 * <br> 입력 등 데이터를 규칙에 따라 판별하는 클래스로 규칙에 맞지 않을 시 예외 발생
 *
 * @author heebg, hyojaekim
 * @version 1.0 2019-05-15
 */
public class Rule {
    /**
     * 규칙 : 이름은 5글자 이하여야하며 사용자는 1명 이상이어야한다.
     *
     * @param inputNames 입력받은 사용자 이름들
     * @return inputNames
     * @throws IllegalArgumentException
     */
    public static String ruleInputPlayerNames(String inputNames) {
        inputNames = inputNames.replaceAll(" ","");
        List<String> names = rulePlayerCountSize(
                Arrays.asList(inputNames.split(","))
        );
        for (String name : names) {
            rulePlayerNameLength(name);
        }
        return inputNames;
    }

    /**
     * 규칙 : 이름 하나의 길이는 5자 이하여야한다
     * <br> 기준 : Const.MAX_NAME_LENGTH
     *
     * @param name 이름 하나
     * @return name
     * @throws IllegalArgumentException Const.EX_NAME
     */
    public static String rulePlayerNameLength(String name) {
        if (StringUtils.isBlank(name) || name.length() > Const.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Const.EX_NAME);
        }
        return name;
    }

    /**
     * 규칙 : 사용자는 한 명 이상이어야 한다
     * <br> 기준 : Const.MIN_PLAYER_COUNT
     *
     * @param names 사용자 이름들
     * @return names
     * @throws IllegalArgumentException EX_PLAYER_COUNT
     */
    public static List<String> rulePlayerCountSize(List<String> names) {
        if (names.size() < Const.MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(Const.EX_PLAYER_COUNT);
        }
        return names;
    }

    /**
     * 규칙 : 사용자는 한 명 이상이어야 한다
     * <br> 기준 : Const.MIN_PLAYER_COUNT
     *
     * @param playerCount 사용자 수
     * @return playerCount
     * @throws IllegalArgumentException EX_PLAYER_COUNT
     */
    public static int rulePlayerCountSize(int playerCount) {
        if (playerCount < Const.MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(Const.EX_PLAYER_COUNT);
        }
        return playerCount;
    }

    /**
     * 규칙 : 사다리 깊이는 1 이상이어야 한다.
     * <br> 기준 : Const.MIN_LINE_COUNT
     *
     * @param depth 사다리 깊이
     * @return depth
     * @throws IllegalArgumentException Const_EX_LINE_COUNT
     */
    public static int ruleLadderDepthRange(int depth) {
        if (depth < Const.MIN_LINE_COUNT) {
            throw new IllegalArgumentException(Const.EX_LINE_COUNT);
        }
        return depth;
    }

    /**
     * 규칙 : 실행 결과는 참여자 수와 같아야하며 각 결과는 5글자 이하여야한다
     *
     * @param reward 입력받은 실행 결과
     * @param playerCount 참여자 수
     * @return reward
     * @throws IllegalArgumentException
     */
    public static String ruleInputReward(String reward, int playerCount) {
        List<String> rewards = Arrays.asList(ruleInputPlayerNames(reward).split(","));
        ruleRewardSize(rewards.size() != playerCount);

        return reward;
    }

    /**
     * 규칙 : 실행 결과는 참여자 수와 같아야 한다.
     *
     * @param isOverSize 규칙
     * @throws IllegalArgumentException
     */
    private static void ruleRewardSize(boolean isOverSize) {
        if (isOverSize) {
            throw new IllegalArgumentException(Const.EX_REWARDS_COUNT);
        }
    }
}
