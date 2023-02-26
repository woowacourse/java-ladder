package ladder.repository;

import java.util.HashMap;
import java.util.Map;
import ladder.domain.LadderRepository;

/**
 * LadderGame 에서 사용되는 클래스들을 저장하는 구현체입니다
 */
public class LadderRepositoryImpl implements LadderRepository {

    private final Map<Class<?>, Object> repository;

    public LadderRepositoryImpl() {
        repository = new HashMap<>();
    }

    @Override
    public void put(Class<?> type, Object object) {
        repository.put(type, object);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> type) {
        return (T) repository.get(type);
    }
}
