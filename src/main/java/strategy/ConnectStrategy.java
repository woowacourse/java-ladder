package strategy;

import domain.Connection;

@FunctionalInterface
public interface ConnectStrategy {

    Connection generate();
}
