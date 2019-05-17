package ladderGame.controller;

import ladderGame.dto.DrawnLadder;
import ladderGame.model.ladder.*;
import ladderGame.view.InputView;
import ladderGame.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private static String[] results;
    private static String[] names;

    public static void main(String[] args) {
        names = InputView.readNames();
        int rows = InputView.readRows();
        results = InputView.readResults();

        LadderFactory ladderFactory = new LadderFactory(new LadderRowFactory());
        Ladder ladder = ladderFactory.newInstance(rows, names.length - 1 );

        System.out.println("실행결과");
        LadderDrawer ladderDrawer = new LadderDrawer();
        ladderDrawer.draw(ladder, 10);

        DrawnLadder drawnLadder = ladder.drawn();

        OutputView.printNames(names);
        OutputView.printLadder(drawnLadder);

        while(true) {
            ask(drawnLadder);

        }


    }

    private static void ask(DrawnLadder drawnLadder) {
        System.out.println("결과를 보고 싶은 사람은?");
        String name = InputView.readName();

        List<Integer> fromColumns = new ArrayList<>();
        if (name.equals("all")) {
            fromColumns = IntStream.range(0, names.length).boxed().collect(Collectors.toList());
        } else {
            fromColumns.add(Arrays.asList(names).indexOf(name));
        }

        System.out.println("실행 결과");

        for (Integer fromColumn : fromColumns) {
            System.out.println(names[fromColumn] + " : " + results[LadderNavigator.navigate(drawnLadder, fromColumn)]);
        }
    }
}


