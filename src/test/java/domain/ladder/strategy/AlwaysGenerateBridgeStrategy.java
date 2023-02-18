package domain.ladder.strategy;

public class AlwaysGenerateBridgeStrategy implements GenerateBridgeStrategy {

    @Override
    public boolean isGeneratedBridge() {
        return true;
    }

}
