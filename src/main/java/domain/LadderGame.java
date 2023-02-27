package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import util.RandomBooleanGenerator;
import util.RandomValueGenerator;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class LadderGame {

    private People people;
    private Lines lines;
    private Rewards rewards;

    public void createPeople(List<String> names) {
        validateDuplicateName(names);
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            people.add(new Person(names.get(i), i));
        }
        this.people = new People(people);
    }

    private void validateDuplicateName(List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException("참가지 이름은 중복일 수 없습니다.");
        }
    }

    public void createLines(int width, int height) {
        RandomValueGenerator generator = new RandomBooleanGenerator();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.newInstanceWithPersonCount(width, generator));
        }
        this.lines = new Lines(lines);
    }

    public Rewards createRewards(List<String> names, int peopleNum) {
        List<Reward> rewards = new ArrayList<>();
        for (String name : names) {
            rewards.add(new Reward(name));
        }

        return new Rewards(rewards, peopleNum);
    }

    public void processResult(People people, Lines lines) {
        for (Line line : lines.getLines()) {
            calculateLine(people, line);
        }
    }

    private static void calculateLine(People people, Line line) {
        for (Person person : people.getPeople()) {
            movePerson(person, line, people.getPeople().size());
        }
    }

    private static void movePerson(Person person, Line line, int peopleSize) {
        MoveCommand command = decisionPersonPosition(person, line, peopleSize);
        if (command == MoveCommand.LEFT) {
            person.goLeft();
            return;
        }
        if (command == MoveCommand.RIGHT) {
            person.goRight();
            return;
        }
    }

    private static MoveCommand decisionPersonPosition(Person person, Line line, int peopleSize) {
        int i = person.getPosition();
        if (person.getPosition() != peopleSize - 1 && line.getPoints().get(person.getPosition()).status()) {
            return MoveCommand.RIGHT;
        }
        if (i != 0 && line.getPoints().get(i - 1).status()) {
            return MoveCommand.LEFT;
        }
        return MoveCommand.NONE;
    }

    public People getPeople(){
        return people;
    }

    public Lines getLines(){
        return lines;
    }
}
