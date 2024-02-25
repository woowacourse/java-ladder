package ladder.domain;

public class GameResults {
    public GameResults(UserNames userNames, final String requestUser) {
        validateRequestUser(userNames, requestUser);
    }

    private static void validateRequestUser(UserNames userNames, final String requestUser) {
        boolean isNotAll = !requestUser.equals("all");
        boolean isNotExist = !userNames.isExist(requestUser);
        if (isNotAll || isNotExist) {
            throw new IllegalArgumentException("존재하지 않는 참여자입니다.");
        }
    }
}
