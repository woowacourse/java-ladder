package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineMaker {
    // 생성자에 넣지 말고. generate를 static 메서드로 만들기
    // 그럼 매개변수로 player숫자(리스트 길이)와 randomGenerator만 넣으면 됨.
    //변수에 저장xxxxx
    //테스트 코드도 고치기

    private final int playerCount;
    private final RandomGenerator<Boolean> randomGenerator;

    public LineMaker(int playerCount, RandomGenerator<Boolean> randomGenerator) {
        this.playerCount = playerCount;
        this.randomGenerator = randomGenerator;
    }

    public List<Boolean> generate() {
        List<Boolean> line = new ArrayList<>();

        line.add(randomGenerator.generate());
        for (int idx = 1; idx < playerCount; idx++) {
            if (line.get(idx - 1)) {
                line.add(false);
                continue;
            }
            line.add(randomGenerator.generate());

        }

        return line;
    }

    //add를 먼저하지 않고.
    //for문 전에 boolean before = false을 메서드 변수로 두고,
    //for문 안에 getBar넣어서 playCount만큼 돌리기 int i = 0에서 시작할 수 있음

    public boolean getBar(boolean before) {
        if(before) {
            return false;
        }
        return randomGenerator.generate();
    }



}
