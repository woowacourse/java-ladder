package domain;

import java.util.ArrayList;
import java.util.List;

import domain.util.LinePointsGenerator;
import domain.util.Point;
import domain.util.PointGenerator;

public class LadderBuilder {

	public Ladder build(LadderHeight ladderHeight, LadderWidth ladderWidth, PointGenerator pointGenerator){
		LinePointsGenerator linePointsGenerator = new LinePointsGenerator(ladderWidth.getWidth(), pointGenerator);
		List<Line> lines = new ArrayList<>();
		int height = ladderHeight.getHeight();
		for (int i = 0; i < height; i++){
			List<Point> points = linePointsGenerator.generateLine();
			Line line = new Line(points);
			lines.add(line);
		}
		return new Ladder(lines);
	}
}
