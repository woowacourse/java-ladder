package domain.connection;

public interface ConnectionGenerator {

    Connection generate(Connection previous);

    Connection generateLastConnection(Connection previous);
}
