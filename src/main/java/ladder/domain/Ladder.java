//package ladder.domain;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Ladder {
//    private final List<Line> ladder;
//
//    private Ladder(List<Line> ladder) {
//        this.ladder = ladder;
//    }
//
//
//    public static Ladder createLadder(String names, int ladderHeight, BarGenerator barGenerator) {
//        List<String> namesList = PeopleNamesSplitor.namesSplit(names);
//        List<Line> tmpLadder = new ArrayList<>();
//        for (int i = 0; i < ladderHeight; i++) {
//            tmpLadder.add(Line.of(namesList.size(), barGenerator));
//        }
//
//        return new Ladder(tmpLadder);
//    }
//}
