package ladder.domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import ladder.dto.NamesDto;
import ladder.util.StringSplitter;

/**
 * Names의 경우 거의 요구사항에서 요구하는 Player와 Reward 정보가 동일한 규칙을 가지고 있어서 PlayerNames와 RewardNames를 Names를 상속받는
 * 자식클래스로 만들어주었습니다. 인터페이스를 쓸까 고민을 했는데 몇몇 메서드는 수정 없이 그대로 사용해서 클래스 상속으로 구현했습니다. 구현하면서 우려스럽긴 했는데, 혹시 이런
 * 상속 구조를 사용함에 있어서 성능/유지보수 측면의 결함이 있을까요?
 */
public class Names {

    protected static final Pattern NAMES_FORMAT = Pattern.compile("[^,]+(,[^,]+)+");
    protected final List<Name> names;

    public Names(String names) {
        validateNames(names);

        this.names = StringSplitter.split(names, ",")
            .stream()
            .map(Name::new)
            .collect(Collectors.toList());
    }

    private void validateNames(String names) {
        isNull(names);
        isFormat(names);
    }

    private void isNull(String names) {
        if (names == null) {
            throw new IllegalArgumentException("이름이 null 입니다");
        }
    }

    private void isFormat(String names) {
        if (!NAMES_FORMAT.matcher(names).matches()) {
            throw new IllegalArgumentException("이름이 형식과 맞지 않습니다");
        }
    }

    public int getCount() {
        return names.size();
    }

    public Name getElement(int index) {
        return names.get(index);
    }

    public Name findName(String name) {
        if (!contains(name)) {
            return null;
        }
        return names.stream().filter((el) -> el.toDto().equals(name))
            .collect(Collectors.toList()).get(0);

    }

    private boolean contains(String name) {
        return names.stream().filter((el) -> el.toDto().equals(name)).count() > 0;
    }

    public NamesDto toDto() {
        return new NamesDto(names.stream()
            .map(Name::toDto)
            .collect(Collectors.toList()));
    }
}
