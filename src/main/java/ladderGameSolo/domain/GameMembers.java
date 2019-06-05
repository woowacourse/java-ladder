package ladderGameSolo.domain;

import java.util.List;

public class GameMembers {
    private List<Member> members;

    public GameMembers(List<Member> members) {
        this.members = members;
    }

    public int getSize() {
        return members.size();
    }

    public Member getMemberByIndex(int index) {
        return members.get(index);
    }
}
