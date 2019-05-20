import ladder.domain.*;
import ladder.view.OutputView;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("참여할 사람들의 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        System.out.println("최대 사다리 높이는 몇 개인가요?");

        System.out.println("사다리 결과");

        int numRowPosition = 5;
        int numColumnPosition = 7;
        // Todo: 좀더 간단하게 생성하도록 도와주는 부분이 필요
        Ladder ladder = new Ladder(Stream.generate(() -> new HorizontalLine(Stream.generate(() -> Direction.NONE).limit(numColumnPosition).collect(Collectors.toList()))).limit(numRowPosition).collect(Collectors.toList()));

        // Todo: 몇개 정도 선긋기를 시도하는게 좋을까?
        LadderDrawer.tryDraw(ladder, 2 * (numColumnPosition + numRowPosition));

        DrawnLadder drawnLadder = ladder.drawn();
        OutputView.printDrawnLadder(drawnLadder);

        //
//        while(true) {
            System.out.println("결과를 보고 싶은 사람은?");

            System.out.println("실행 결과");
//        }
    }
}
