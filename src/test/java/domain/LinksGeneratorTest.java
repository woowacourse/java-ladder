package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class LinksGeneratorTest {

    @ParameterizedTest
    @DisplayName("사람 수를 입력받으면 사람 수보다 하나 적은 라인이 생성된다")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void randomLinksLengthTest(int personCount) {
        final LinksGenerator linksGenerator = new LinksGenerator(new RandomBooleanGenerator());
        final List<Link> links = linksGenerator.generate(personCount);
        final int linkNumbers = links.size();
        final int expectedLinkNumbers = personCount - 1;
        Assertions.assertThat(linkNumbers).isEqualTo(expectedLinkNumbers);
    }
}
