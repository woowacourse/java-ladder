package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGameController {

    private LadderGameController(){
    }
    public static void run() {

        //TODO 메소드 분리 생각하기
        //TODO try-catch 생각
        //1단계 : 입력받기
        List<String> names = InputView.readNames();
        int height = InputView.readHeight(); //NFE 고려하기

        //2단계 : domain.People, 사다리 생성
        People people = new People(names);
        Ladder ladder = new Ladder(height, names.size());

        //3단계
        OutputView.printNames(people);
        OutputView.printLadder(ladder);


    }
}
