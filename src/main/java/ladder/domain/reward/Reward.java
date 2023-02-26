package ladder.domain.reward;

public class Reward {

    public static final int REWARD_MAXIMUM_LENGTH = 5;
    private static final char START_KOREAN = '가';
    private static final char END_KOREAN = '힣';

    private final String reward;

    public Reward(String reward) {
        validateBlank(reward);
        validateLength(reward);
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }

    private void validateLength(String reward) {
        if (calculateLength(reward) > REWARD_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("보상은 최대 " + REWARD_MAXIMUM_LENGTH + "글자 입니다. 영어, 숫자, 공백 = 길이 1 / 한글 = 길이 2");
        }
    }

    private void validateBlank(String reward) {
        if (reward.isBlank()) {
            throw new IllegalArgumentException("보상은 빈 문자열을 입력할 수 없습니다.");
        }
    }

    private int calculateLength(String content) {
        int countKorean = 0;
        for (int index = 0; index < content.length(); index++) {
            char charAt = content.charAt(index);
            countKorean += countKorean(charAt);
        }
        return content.length() + countKorean;
    }

    private int countKorean(char letter) {
        if (letter >= START_KOREAN && letter <= END_KOREAN) {
            return 1;
        }
        return 0;
    }

}
