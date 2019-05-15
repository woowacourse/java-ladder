package ladder.validator;

import ladder.constant.MessageConstant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PlayerValidator {

    public static void checkPlayerInputAccuracy(String[] inputs){
         if(isOnePlayer(inputs)){
             throw new IllegalArgumentException(MessageConstant.ERROR_ONE_PLAYER);
         }

        if(isOverlapPlayer(inputs)){
            throw new IllegalArgumentException(MessageConstant.ERROR_OVERLAP_PLAYERS);
        }
    }

    private static boolean isOnePlayer(String[] inputs) {
        return inputs.length == 1;
    }

    private static boolean isOverlapPlayer(String[] inputs){
        Set<String> checkOverlapNames = new HashSet<>(Arrays.asList(inputs));
        return checkOverlapNames.size() != inputs.length;
    }
}
