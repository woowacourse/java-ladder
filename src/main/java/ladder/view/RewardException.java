package ladder.view;

import java.util.Arrays;
import java.util.List;

public class RewardException {
    public static final String EX_REWARDS_COUNT = "플레이어 수랑 결과 개수는 같아야 합니다.";

    /**
     * 규칙 : 실행 결과는 참여자 수와 같아야하며 각 결과는 5글자 이하여야한다
     *
     * @param reward      입력받은 실행 결과
     * @param playerCount 참여자 수
     * @return reward
     * @throws IllegalArgumentException
     */
    public static void reward(String reward, int playerCount) {
        checkReward(reward);
        List<String> rewards = Arrays.asList(reward.split(","));
        checkRewardSize(rewards.size() != playerCount);
    }

    /**
     * 규칙 : 이름은 5글자 이하
     * <br> 규칙 : 사용자는 1명 이상
     *
     * @param inputNames 입력받은 실행 결과들
     * @return inputNames
     * @throws IllegalArgumentException
     */
    public static void checkReward(String inputNames) {
        List<String> names = PlayerException.playerNamesMinSize(
                Arrays.asList(inputNames.split(","))
        );
        for (String name : names) {
            PlayerException.playerNameOverLength(name);
        }
    }

    /**
     * 규칙 : 실행 결과는 참여자 수와 같아야 한다.
     *
     * @param isOverSize 규칙
     * @throws IllegalArgumentException
     */
    private static void checkRewardSize(boolean isOverSize) {
        if (isOverSize) {
            throw new IllegalArgumentException(EX_REWARDS_COUNT);
        }
    }
}
