package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Members {
    private final List<Member> members;

    public Members(final List<Member> members) {
        this.members = members;
    }

    public List<Member> allMembers() {
        return new ArrayList<>(members);
    }
}
