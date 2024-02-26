package domain;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class Names {
    private static final int MIN_NAMES_COUNT = 2;
    private static final int MAX_NAMES_COUNT = 10;
    private final List<Name> names;

    private final Map<Integer, Integer> namesIndexTable = new ConcurrentHashMap<>();

    Names(List<Name> names) {
        validateDuplicateName(names);
        validateNameCount(names);
        this.names = names;
        initNamesIndexTable();
    }


    public List<Name> getNames() {
        return names;
    }

    public List<Name> getSwappedNames() {
        return IntStream.range(0, names.size())
                .mapToObj(index -> names.get(namesIndexTable.get(index)))
                .toList();
    }

    public void swapNamePosition(int i) {
        int right = namesIndexTable.get(i);
        int left = namesIndexTable.get(i - 1);
        namesIndexTable.put(i, left);
        namesIndexTable.put(i - 1, right);
    }

    int getNameCount() {
        return names.size();
    }

    private void initNamesIndexTable() {
        IntStream.range(0, names.size())
                .forEach(index -> namesIndexTable.put(index, index));
    }


    private void validateNameCount(List<Name> names) {
        if (names.size() < MIN_NAMES_COUNT || names.size() > MAX_NAMES_COUNT) {
            throw new LadderGameException(ExceptionType.INVALID_NAMES_RANGE);
        }
    }

    private void validateDuplicateName(List<Name> name) {
        long distinctCount = name.stream().distinct().count();
        if (distinctCount != name.size()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DUPLICATE_NAME);
        }
    }
}
