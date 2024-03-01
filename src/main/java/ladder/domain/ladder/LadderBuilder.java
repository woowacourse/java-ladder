package ladder.domain.ladder;

import ladder.domain.attribute.Height;
import ladder.domain.attribute.Width;
import ladder.domain.ladder.direction.LadderDirection;
import ladder.domain.ladder.direction.LadderDirectionSelector;

public class LadderBuilder {

    private Height<LadderRow> height;
    private Width<LadderDirection> width;
    private LadderDirectionSelector directionSelector;

    private LadderBuilder() {
    }

    public static LadderBuilder builder() {
        return new LadderBuilder();
    }

    public LadderBuilder height(final Height<LadderRow> height) {
        this.height = height;
        return this;
    }

    public LadderBuilder width(final Width<LadderDirection> width) {
        this.width = width;
        return this;
    }

    public LadderBuilder ladderDirectionSelector(final LadderDirectionSelector directionSelector) {
        this.directionSelector = directionSelector;
        return this;
    }

    public Ladder build() {
        return Ladder.from(height.repeat(() -> LadderRowBuilder.builder()
                .width(width)
                .directionSelector(directionSelector)
                .build()));
    }
}
