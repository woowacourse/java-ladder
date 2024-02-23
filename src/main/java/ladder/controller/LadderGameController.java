package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {
    private LadderGameController() {
    }
    //TODO 예외처리가 Controller의 역할인지 생각하기
    public static void run() {
        People people = getPeople();
        Ladder ladder = getLadder(people);

        OutputView.printNames(people);
        OutputView.printLadder(ladder);
    }

    private static People getPeople() {
        People people = null;
        while (people == null) {
            people = makePeople();
        }
        return people;
    }

    private static Ladder getLadder(People people) {
        Ladder ladder = null;
        while (ladder == null) {
            ladder = makeLadder(people);
        }
        return ladder;
    }

    private static People makePeople() {
        try {
            return new People(InputView.readNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Ladder makeLadder(People people) {
        try {
            int peopleNumber = people.getNames().size();
            return new Ladder(InputView.readHeight(), peopleNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
