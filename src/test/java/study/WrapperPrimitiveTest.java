package study;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WrapperPrimitiveTest {
    @Test
    void 작은수에_대해_int와_Integer_연산() {
        // when
        long startTimeForPrimitive = System.nanoTime();
        int a = 1;
        int b = 2;
        int c = 3;
        for (int i = 0; i < 10_000; i++) {
            int resultForLiteral = a + b + c;
        }
        long endTimeForPrimitive = System.nanoTime();

        // when
        long startTimeForWrapper = System.nanoTime();
        Integer d = 1;
        Integer e = 2;
        Integer f = 3;
        for (int i = 0; i < 10_000; i++) {
            Integer resultForNonLiteral = d + e + f;
        }
        long endTimeForWrapper = System.nanoTime();

        // then
        long durationForPrimitive = endTimeForPrimitive - startTimeForPrimitive;
        long durationForWrapper = endTimeForWrapper - startTimeForWrapper;

        System.out.println("small primitive = " + durationForPrimitive);
        System.out.println("small wrapper = " + durationForWrapper);

        assertTrue(durationForPrimitive < durationForWrapper);
    }

    //@Disabled // 이 메서드 하나만 실행할 땐 어떨 땐 true, 어떨 땐 false 뜰만큼 그 차이 적음 확인함
    @Test
    void 큰수에_대해_int와_Integer_연산() {
        // when
        long startTimeForPrimitive = System.nanoTime();
        int a = 1;
        int b = 2;
        int c = 3;
        for (int i = 0; i < 1_000_000_000; i++) {
            int resultForLiteral = a + b + c;
        }
        long endTimeForPrimitive = System.nanoTime();

        // when
        long startTimeForWrapper = System.nanoTime();
        Integer d = 1;
        Integer e = 2;
        Integer f = 3;
        for (int i = 0; i < 1_000_000_000; i++) {
            Integer resultForNonLiteral = d + e + f;
        }
        long endTimeForWrapper = System.nanoTime();

        // then
        long durationForPrimitive = endTimeForPrimitive - startTimeForPrimitive;
        long durationForWrapper = endTimeForWrapper - startTimeForWrapper;

        System.out.println("big primitive = " + durationForPrimitive);
        System.out.println("big wrapper = " + durationForWrapper);

        assertTrue(durationForPrimitive > durationForWrapper);
    }
}
