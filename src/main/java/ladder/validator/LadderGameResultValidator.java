package ladder.validator;

import ladder.constant.MessageConstant;

public class LadderGameResultValidator {

    public static String checMatchPlayerAndGoal(String targetGoal){
        if(targetGoal == null){
            throw new IllegalArgumentException(MessageConstant.ERROR_PLAYER_NOT_EXIST);
        }
        return  targetGoal;
    }
}
