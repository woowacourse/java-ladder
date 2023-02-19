package helper;

import domain.BridgeStatus;
import domain.Bridge;
import domain.Line;
import domain.People;
import domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractTestFixture {

    public List<BridgeStatus> convert(Boolean... flags) {
        return Arrays.stream(flags)
                     .map((flag) -> {
                         if (flag) {
                             return BridgeStatus.EXIST;
                         }
                         return BridgeStatus.EMPTY;
                     })
                     .collect(Collectors.toList());
    }

    public People createDefaultPerson() {
        return new People(List.of(new Person("aa"), new Person("bb")));
    }

    public List<Bridge> createBridges(final int height) {
        List<Bridge> bridges = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            bridges.add(new Bridge(convert(true, false, true)));
        }
        return bridges;
    }

    public List<String> createResultCandidates(int size) {
        List<String> candidates = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            candidates.add(getResultCandidate(i));
        }

        return candidates;
    }

    private String getResultCandidate(int count) {
        if (count % 2 == 0) {
            return "꽝";
        }

        return String.valueOf(count * 1000);
    }
}
