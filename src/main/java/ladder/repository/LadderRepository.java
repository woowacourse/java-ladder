package ladder.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * LadderGame 에서 사용되는 클래스들을 저장하는 클래스입니다
 */
public class LadderRepository {

    private final Map<Class<?>, Object> repository;

    public LadderRepository() {
        repository = new HashMap<>();
    }

    public void put(Class<?> type, Object object) {
        repository.put(type, object);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> type) {
        return (T) repository.get(type);
    }
}
