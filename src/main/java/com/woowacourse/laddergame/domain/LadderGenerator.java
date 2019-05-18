package com.woowacourse.laddergame.domain;

import com.woowacourse.laddergame.util.NaturalNumber;

public class LadderGenerator {
    public static Ladder generateLadder(NaturalNumber height, NaturalNumber countOfPerson, BooleanGenerator generator) {
        Ladder ladder = new Ladder(height, countOfPerson);

        for (int heightNO = 1; heightNO <= height.getNumber(); heightNO++) {
            loopLine(countOfPerson, generator, ladder, heightNO);
        }

        return ladder;
    }

    private static void loopLine(NaturalNumber countOfPerson, BooleanGenerator generator, Ladder ladder, int heightNo) {
        for (int personNo = 1; personNo < countOfPerson.getNumber(); personNo++) {
            personNo = generateBridge(generator, ladder, heightNo, personNo);
        }
    }

    private static int generateBridge(BooleanGenerator generator, Ladder ladder, int heightNo, int personNo) {
        if (generator.generate()) {
            ladder.putBridge(new NaturalNumber(heightNo), new NaturalNumber(personNo));
            personNo++;
        }
        return personNo;
    }
}
