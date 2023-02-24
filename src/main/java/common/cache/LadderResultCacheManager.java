package common.cache;

import domain.Ladder;
import domain.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResultCacheManager {

    private static final Map<Person, String> cacheMap = new HashMap<>();

    public String getLadderResultCache(String name, Ladder ladder) {
        Person person = new Person(name);

        if (hasCacheOf(person)) {
            return cacheMap.get(person);
        }

        String result = ladder.getLadderMatchingPersonalResult(name);
        cacheMap.put(person, result);

        return result;
    }

    private boolean hasCacheOf(Person person) {
        return cacheMap.get(person) != null;
    }

    public Map<Person, String> getLadderResultAllCache(Ladder ladder) {
        List<String> participantNames = ladder.getParticipantNames();

        participantNames.stream()
                        .filter((name) -> {
                            return hasCacheOf(new Person(name));
                        })
                        .forEach((name) -> getLadderResultCache(name, ladder));

        return Map.copyOf(cacheMap);
    }

}
