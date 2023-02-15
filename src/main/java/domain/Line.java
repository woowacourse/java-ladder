package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<FootStep> footSteps = new ArrayList<>();
    private BooleanGenerator generator;

    public Line(final int width){
        for (int i = 0; i < width; i++) {
            footSteps.add(new FootStep(true));
        }

        generator = null;
    }

    public Line(final int width, BooleanGenerator generator){
        this(width);
        this.generator = generator;
    }

    public Line(BooleanGenerator generator){
        this.generator = generator;
    }

    public Line(FootStep firstFootstep) {
        this.footSteps.add(firstFootstep);
        this.generator = null;
    }

    public boolean isSteppableAt(final int index){
        return this.footSteps
                .get(index)
                .isSteppable();
    }

    public int getWidth() {
        return footSteps.size();
    }

    public void generateFootStep() {
        if (this.footSteps.size() != 0) {
            FootStep previous = this.footSteps.get(this.footSteps.size() - 1);
            if (previous.isSteppable()) {
                this.footSteps.add(new FootStep(false));
                return;
            }
        }
        this.footSteps.add(new FootStep(generator.generate()));
    }
}
