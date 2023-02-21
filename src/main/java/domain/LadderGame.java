package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.BooleanGenerator;

public class LadderGame {
    private final Persons persons;
    private final Ladder ladder;

    public LadderGame(Persons persons, Height height, BooleanGenerator booleanGenerator) {
        this.persons = persons;
        this.ladder = Ladder.generate(booleanGenerator, height, persons.getTotalPersonCount());
    }

    public List<Integer> play() {
        List<Integer> resultIndexes = new ArrayList<>();
        for (int personIndex = 0; personIndex < persons.getTotalPersonCount(); personIndex++) {
            resultIndexes.add(move(personIndex));
        }
        return resultIndexes;
    }

    private int move(int personIndex) {
        List<List<Boolean>> ladder = getLadderStatus();
        for (int linePosition = 0; linePosition < this.ladder.calculateTotalHeight(); linePosition++) {
            personIndex = moveInCurrentLine(ladder.get(linePosition), personIndex - 1, personIndex, personIndex);
        }
        return personIndex;
    }

    private int moveInCurrentLine(List<Boolean> currentLine, int leftBridge, int rightBridge, int personIndex) {
        if (personIndex == 0) {
            return checkRightAndMove(currentLine.get(rightBridge), personIndex);
        }
        if (personIndex == currentLine.size()) {
            return checkLeftAndMove(currentLine.get(leftBridge), personIndex);
        }
        personIndex = checkLeftAndMove(currentLine.get(leftBridge), personIndex);
        return checkRightAndMove(currentLine.get(rightBridge), personIndex);
    }

    private int checkRightAndMove(boolean isRightMovable, int personIndex) {
        if (isRightMovable) {
            personIndex++;
        }
        return personIndex;
    }

    private int checkLeftAndMove(boolean isLeftMovable, int personIndex) {
        if (isLeftMovable) {
            personIndex--;
        }
        return personIndex;
    }

    public List<List<Boolean>> getLadderStatus() {
        return ladder.getLines()
                .stream()
                .map(Line::getBridges)
                .collect(Collectors.toList());
    }

    public List<String> getAllPlayers() {
        return persons.getPersons()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }
}
