package domain;

import java.util.ArrayList;
import java.util.List;
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

    public void createPeople(List<String> inputNames) {
        Names names = new Names(inputNames);
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < names.getNames().size(); i++) {
            people.add(new Person(names.getNames().get(i), i));
        }
        this.people = new People(people);
    }


    public void createLines(int height, RandomValueGenerator generator) {
        int width = people.getPeople().size();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.newInstanceWithPersonCount(width, generator));
        }
        this.lines = new Lines(lines);
    }

    public void createRewards(List<String> names, int peopleNum) {
        List<Reward> rewards = new ArrayList<>();
        for (String name : names) {
            rewards.add(new Reward(name));
        }

        this.rewards = new Rewards(rewards, peopleNum);
    }

    public void processResult() {
        for (Line line : lines.getLines()) {
            movePeopleInLine(line);
        }
    }

    private void movePeopleInLine(Line line) {
        for (Person person : people.getPeople()) {
            person.move(line, people.getPeople().size());
        }
    }

    public People getPeople() {
        return people;
    }

    public Lines getLines() {
        return lines;
    }

    public Rewards getRewards() {
        return rewards;
    }
}
