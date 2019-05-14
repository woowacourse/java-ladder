package domain;

import util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private List<User> users;

    public LadderGame(String s) {
        this.users = createUser(s);
    }

    private List<User> createUser(String s) {
        List<User> users = new ArrayList<>();
        for(String name : StringUtil.splitComma(s)){
            users.add(new User(name));
        }
        return users;
    }

    public List<User> getUsers() {
        return users;
    }
}
