package domain.ladder;

@FunctionalInterface
public interface BridgeMakingStrategy {
    Bridge getOne(Bridge previous);
}
