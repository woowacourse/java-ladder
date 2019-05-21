package ladder;

import ladder.model.Bridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    Bridge bridge;
    @BeforeEach
    void setup(){
        bridge=Bridge.nextBridge(Bridge.firstBridge());
    }

    @Test
    void 올바른_Bridge_검증() {
        for (int i = 0; i < 100; i++){
            assertThat(bridge.isValidBridge()).isTrue();
        }
    }

    @Test
    void 올바르게_움직이는지_검증(){
        if(bridge.isLeft()){
            assertThat(bridge.move()).isEqualTo(-1);
        }
        if(bridge.isCurrent()){
            assertThat(bridge.move()).isEqualTo(1);
        }
        if(!bridge.isLeft() && !bridge.isCurrent()){
            assertThat(bridge.move()).isEqualTo(0);
        }
    }


}
