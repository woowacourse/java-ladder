package ladder.validator;

import ladder.MessageCollection;

public class LadderGameResultValidator {

    public static String checMatchPlayerAndGoal(String targetPlayer) {
        if (targetPlayer == null || targetPlayer.equals("")) {
            throw new IllegalArgumentException(MessageCollection.ERROR_PLAYER_NOT_EXIST);
        }
        return targetPlayer;
    }
}
