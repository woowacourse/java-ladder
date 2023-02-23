package domain;

import java.util.ArrayList;
import java.util.List;
import util.RandomBooleanGenerator;
import util.RandomValueGenerator;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class LadderGame {

    public People createPeople(List<String> names) {
        List<Person> people = new ArrayList<>();
        for (String name : names) {
            people.add(new Person(name));
        }
        return new People(people);
    }

    public Lines createLines(int width, int height) {
        RandomValueGenerator generator = new RandomBooleanGenerator();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.newInstanceWithPersonCount(width, generator));
        }
        return new Lines(lines);
    }

    public Rewards createRewards(List<String> names, int peopleNum) {
        List<Reward> rewards = new ArrayList<>();
        for (String name : names) {
            rewards.add(new Reward(name));
        }

        return new Rewards(rewards, peopleNum);
    }
}
