package ladderGame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FloorTest {

    @Test
    void 한층_만들기() {
        List<Point> points = new ArrayList<>();
        points.add(Point.pointFirst(true));
        points.add(points.get(0).nextPoint(false));
        points.add(points.get(1).nextPoint(true));
        points.add(points.get(2).nextPointLast());

        Floor floor = new Floor( (e) -> points, 4);
        User pobi = new User("pobi", 0);
        User crong = new User("crong", 1);
        User honux = new User("honux", 2);

        Point point = floor.getPointByPosition(pobi.getPosition());
        assertThat(pobi.movePosition(point.move())).isEqualTo(1);

        point = floor.getPointByPosition(crong.getPosition());
        assertThat(crong.movePosition(point.move())).isEqualTo(0);

        point = floor.getPointByPosition(honux.getPosition());
        assertThat(honux.movePosition(point.move())).isEqualTo(3);
    }
}
