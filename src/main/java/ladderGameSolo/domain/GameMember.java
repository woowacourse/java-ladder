package ladderGameSolo.domain;

import java.util.List;

public class GameMember {
    List<Member> members;

    public GameMember(List<Member> members) {
        this.members = members;
    }

    public int getSize() {
        return members.size();
    }

    public Member getMemberByIndex(int index) {
        return members.get(index);
    }
}
