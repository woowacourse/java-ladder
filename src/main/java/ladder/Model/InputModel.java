package ladder.Model;

import java.util.*;

public class InputModel {
    String name;
    int ladderHeight;

    List<String> getValidNames(String names) {
        if(isBlank(names)) return null;

        List<String> validNames = Arrays.asList(names.split(","));
        if(validNames.size() ==0) return null;

        Set<String> overlapNames = new HashSet<>(validNames);
        if(overlapNames.size() != validNames.size()) return null;

        for (String name : validNames) {
            if (isInValidNameLength(name)) return null;
        }

        return validNames;
    }

    private boolean isInValidNameLength(String name) {
        if(name.length() > 5){
            return true;
        }
        return false;
    }

    private boolean isBlank(String names) {
        if(names == null || names == ""){
            return true;
        }
        return false;
    }


}
