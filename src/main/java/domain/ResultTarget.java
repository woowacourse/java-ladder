package domain;

import java.util.List;

public class ResultTarget {

    private final String name;
    private final Boolean isAll;

    private ResultTarget(String name, Boolean isAll) {
        this.name = name;
        this.isAll = isAll;
    }

    public static ResultTarget of(String targetName, List<Member> members) {
        validate(targetName, members);
        if (targetName.equals("all")) {
            return new ResultTarget(targetName, true);
        }
        return new ResultTarget(targetName, false);
    }

    private static void validate(String targetName, List<Member> members) {
        boolean isExist = members.stream()
                .anyMatch(member -> member.getName().equals(targetName));
        if (!isExist && !targetName.equals("all")) {
            throw new IllegalArgumentException("해당 이름을 가진 참여자가 없습니다.");
        }
    }

    public boolean isAllMembers() {
        return isAll;
    }

    public String getName() {
        return name;
    }
}
