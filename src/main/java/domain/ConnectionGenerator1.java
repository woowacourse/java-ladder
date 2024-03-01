package domain;

public interface ConnectionGenerator1 {

    Connection generate(Connection previous);

    Connection generateLastConnection(Connection previous);
}
