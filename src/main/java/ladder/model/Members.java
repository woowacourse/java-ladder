package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Members {

    public static List<Member> generateMembers(String[] names) {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            members.add(new Member(names[i], i));
        }

        return members;
    }
}
