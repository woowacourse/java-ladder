<<<<<<<< HEAD:src/main/java/domain/generator/RandomBooleanGenerator.java
package domain.generator;
========
package utils.booleanGenerator;
>>>>>>>> 8594160 (chore: 패키지 분리):src/main/java/utils/booleanGenerator/RandomBooleanGenerator.java

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    private final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
