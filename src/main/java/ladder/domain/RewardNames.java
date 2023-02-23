package ladder.domain;

public class RewardNames extends Names {

    public RewardNames(String names, int playerNamesSize) {
        super(names);
        validateNamesSize(playerNamesSize);
    }

    private void validateNamesSize(int playerNamesSize) {
        if (this.names.size() != playerNamesSize) {
            throw new IllegalArgumentException(
                String.format("실행 결과의 개수는 플레이어의 인원 수(%d)와 같아야 합니다.(입력된 실행 결과의 수 : %d)",
                    playerNamesSize, this.names.size()));
        }
    }
}
