package ladder.domain;

public class GameResult {
    public GameResult(UserNames userNames, final String requestUser) {
        if (!requestUser.equals("all") || !userNames.isExist(requestUser)) {
            throw new IllegalArgumentException("존재하지 않는 참여자입니다.");
        }
    }
}
