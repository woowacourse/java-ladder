package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Players implements Iterable<Player> {
    private static final String ITEM_SPLITTER = ",";

    private final List<Player> players;

    public Players(final String rawNames) {
        validateNoConsecutiveCommas(rawNames);
        validateSurroundedWithComma(rawNames);
        final List<String> names = Arrays.asList(rawNames.split(ITEM_SPLITTER));
        validateNoDuplication(names);
        players = Collections.unmodifiableList(names.stream().map(Player::new).collect(Collectors.toList()));
    }

    private static void validateNoConsecutiveCommas(final String names) {
        if (names.contains(ITEM_SPLITTER + ITEM_SPLITTER)) {
            throw new IllegalArgumentException(ITEM_SPLITTER + "가 두개 이상 연달아 있으면 안 됩니다.");
        }
    }

    private void validateSurroundedWithComma(String rawNames) {
        if(rawNames.startsWith(ITEM_SPLITTER) || rawNames.endsWith(ITEM_SPLITTER)){
            throw new IllegalArgumentException(ITEM_SPLITTER + "로 시작하거나 끝나면 안 됩니다.");
        }
    }

    private static void validateNoDuplication(final List<String> names) {
        final List<String> reducedNames = names.stream().distinct().collect(Collectors.toList());
        if (names.size() != reducedNames.size()) throw new IllegalArgumentException("중복된 이름이 존재하면 안됩니다.");
    }

    public int getPlayerSize() {
        return players.size();
    }

    Player getPlayer(int index) {
        return players.get(index);
    }

    @Override
    public Iterator<Player> iterator() {
        return new Iterator<Player>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < players.size();
            }

            @Override
            public Player next() {
                return players.get(count++);
            }
        };
    }
}
