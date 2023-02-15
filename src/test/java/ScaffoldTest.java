import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Scaffold 는")
public class ScaffoldTest {

    @Test
    void 존재_혹은_존재하지않음_상태를_가진다() {
        assertDoesNotThrow(() -> Scaffold.EXIST);
        assertDoesNotThrow(() -> Scaffold.NONE);
    }
}
