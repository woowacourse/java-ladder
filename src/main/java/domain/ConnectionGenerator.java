package domain;

public interface ConnectionGenerator {

    ConnectionStatus generateByPreviousStatus(ConnectionStatus previous);
}
