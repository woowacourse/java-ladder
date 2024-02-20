import domain.LadderHeight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHeightTest {
    @Test
    void height() {
        assertThatThrownBy(() -> new LadderHeight(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
