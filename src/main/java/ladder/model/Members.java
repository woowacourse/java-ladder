package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Members {

    public static List<Member> generateMembers(String[] names) {
        List<Member> members = new ArrayList<>();

        for (String name : names) {
            members.add(new Member(name));
        }

        return members;
    }
}
