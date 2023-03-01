package ladder.domain;

/**
 * 사다리가 연결되는지, 연결되지 않는지를 판단하는 인터페이스
 * <p>
 * 이 인터페이스를 구현하는 클래스는 사다리가 연결되는지, 연결되지 않는지를 판단하는 클래스이다.
 * <p>
 * true 를 반환하면 연결되고, false 를 반환하면 연결되지 않는다.
 */
public interface ConnectionJudgement {

    boolean judge();
}
