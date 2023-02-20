<<<<<<<< HEAD:src/main/java/domain/booleangenerator/RandomBooleanGenerator.java
<<<<<<<< HEAD:src/main/java/domain/generator/RandomBooleanGenerator.java
package domain.generator;
========
package utils.booleanGenerator;
>>>>>>>> 8594160 (chore: 패키지 분리):src/main/java/utils/booleanGenerator/RandomBooleanGenerator.java
========
package domain.generator;
>>>>>>>> d528699 (refactor(generator): 패키지 이름 변경):src/main/java/domain/generator/RandomBooleanGenerator.java

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    private final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
