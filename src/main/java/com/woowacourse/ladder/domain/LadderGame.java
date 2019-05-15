package com.woowacourse.ladder.domain;

public class LadderGame {



    public static void main(String[] args) {
        Ladder ladder = new Ladder(4,4);
        ladder.connectPipes();
        ladder.getPipes().stream().forEach(p -> {
            System.out.print(p.getPipe());
            System.out.print(p.getLine());
            if(p.isMatchWidth(4)){
                System.out.println();
            }
        });

    }
}
