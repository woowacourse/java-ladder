package ladder.domain;

import java.util.Random;

/**
 * @author heebg
 * @version 1.0 2019-05-24
 */
public class PointGenerateFactory {
    private static final String ILLEGAL_ARGUMENT_EXCEPTION = "유효하지 않은 값입니다.";
    private static PointGenerateFactory instance = new PointGenerateFactory();

    public static PointGenerateFactory getInstance() {
        return instance;
    }


    public PointGenerate create(PointGenerateStatus status) {
        if (status.equals(PointGenerateStatus.RANDOM)) {
            return new PointGenerateRandomImp();
        }

        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION);
    }

}
