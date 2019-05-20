package ladderGameSolo.controller;

import ladderGameSolo.constant.MessageContants;
import ladderGameSolo.domain.Ladder;
import ladderGameSolo.domain.Member;
import ladderGameSolo.domain.Position;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static final int START_POSITION = 0;

    public static Ladder getLadders(int countOfPeople, int height) {
        return new Ladder(countOfPeople, height);
    }

    public static List<Member> makeMembers(String[] names, String targetName, int height) {
        List<Member> members = new ArrayList<>();

        String[] targetNames = getTargetNames(names, targetName);
        for (int i = 0; i < targetNames.length; i++) {
            members.add(new Member(targetNames[i], new Position(START_POSITION, height), i));
        }

        return members;
    }

    public static String getResult(Ladder ladder, Member member, String[] result) {
        int resultIndex = member.getResultIndex(ladder);
        return result[resultIndex];
    }

    private static String[] getTargetNames(String[] names, String targetName) {
        if (MessageContants.MESSAGE_ALL.equals(targetName)) {
            return names;
        }

        return new String[]{targetName};
    }
}
