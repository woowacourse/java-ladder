package ladder.domain;

/**
 * 도메인 객체들을 저장하는 저장소 인터페이스 입니다
 * <p>
 * domain 패키지와 repository 패키지간의 의존성의 방향을 역전시키기 위해 존재합니다
 */
public interface LadderRepository {

    void put(Class<?> type, Object object);

    <T> T get(Class<T> type);
}
