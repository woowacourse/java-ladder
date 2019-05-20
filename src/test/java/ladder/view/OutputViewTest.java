//package ladder.view;
//
//import ladder.domain.LadderLineTest;
//import ladder.domain.LadderRow;
//import ladder.domain.LadderResults;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class OutputViewTest {
//
//    @Test
//    public void 사다리_한줄_출력_문자열() {
//
//        OutputView view = new OutputView();
//        LadderRow row = new LadderRow(Arrays.asList(LadderLineTest.line(1),
//                LadderLineTest.line(-1), LadderLineTest.line(0),
//                LadderLineTest.line(1), LadderLineTest.line(-1)));
//        view.print(row);
//        assertEquals("   |-----|     |     |-----|", view.line(row));
//
//    }
//
//    @Test
//    public void 사다리_한줄_출력_문자열2() {
//        OutputView view = new OutputView();
//        LadderRow row = new LadderRow(Arrays.asList(LadderLineTest.line(0),
//                LadderLineTest.line(0), LadderLineTest.line(0),
//                LadderLineTest.line(0), LadderLineTest.line(0)));
//        view.print(row);
//        assertEquals("   |     |     |     |     |", view.line(row));
//
//    }
//
//    @Test
//    public void 결과_출력_문자열() {
//        LadderResults playerResults = new LadderResults("a", "꽝");
//        OutputView outputView = new OutputView();
//        assertEquals("꽝", outputView.result(playerResults));
//    }
//
//    @Test
//    public void 결과_전체_출력_문자열() {
//        List<LadderResults> playerResults = new ArrayList<>();
//        playerResults.add(new LadderResults("a", "꽝"));
//        playerResults.add(new LadderResults("b", "꽝"));
//        playerResults.add(new LadderResults("c", "3000"));
//        playerResults.add(new LadderResults("d", "5000"));
//
//        OutputView outputView = new OutputView();
//        assertEquals("a : 꽝\nb : 꽝\nc : 3000\nd : 5000\n", outputView.result(playerResults));
//    }
//}
