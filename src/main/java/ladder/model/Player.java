package ladder.model;

import ladder.constant.MessageConstant;

public class Player {

    public static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Player(String name) {
        this.name = validatedName(name);;
    }

    private String validatedName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(MessageConstant.ERROR_HASEMPTY);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MessageConstant.ERROR_OVERLENGTH);
        }
        return name;
    }

    public String getName() {
        return name;
    }

}
