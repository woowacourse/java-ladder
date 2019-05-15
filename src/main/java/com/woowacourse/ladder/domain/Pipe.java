package com.woowacourse.ladder.domain;

public class Pipe {
    private Position position;
    private boolean isLinked;
    private boolean isConstructed;
    private final String pipe = "|";
    private static final String line = "=====";

    Pipe(final Position position) {
        this.position = position;
        this.isLinked = false;
        this.isConstructed = false;
    }

    public boolean isLinked() {
        return isLinked;
    }

    public boolean isMatchPipe(final Position position) {
        return this.position.isMatch(position);
    }

    public void connectOn(){
        this.isLinked = true;
    }

    public boolean isMatchWidth(int width) {
        return this.position.isMatchWidth(width);
    }

    public Position getPosition() {
        return position;
    }

    public String getLine() {
        if(this.isConstructed == false && this.isLinked == true ){
            return this.line;
        }
       return "     ";
    }

    public String getPipe() {
        return pipe;
    }

    public void construct() {
        this.isConstructed = true;
    }
}
