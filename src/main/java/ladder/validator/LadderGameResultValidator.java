package ladder.validator;

import ladder.MessageCollection;

public class LadderGameResultValidator {

    public static String checMatchPlayerAndGoal(String targetGoal){
        if(targetGoal == null){
            throw new IllegalArgumentException(MessageCollection.ERROR_PLAYER_NOT_EXIST);
        }
        return  targetGoal;
    }
}
