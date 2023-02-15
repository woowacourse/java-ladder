//package ladder.domain;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.IntStream;
//
//public class Line1 {
//    private final List<Direction> line;
//
//    public Line1(int size, BarGenerator barGenerator) {
//        this.line = create(size, barGenerator);
//    }
//
//    public void move(List<String> names) {
//        for (int index = 0; index < names.size(); index++) {
//            String name = names.get(index);
//            Direction direction = line.get(index);
//            direction.move(name);
//        }
//    }
//
//    private List<Direction> create(int namesSize, BarGenerator barGenerator) {
//        List<Direction> directions = new ArrayList<>();
//
//        addFirstDirection(barGenerator, directions);
//        addMiddleDirection(namesSize, barGenerator, directions);
//        addFinalDirection(directions);
//
//        return directions;
//    }
//
//    private void addFirstDirection(BarGenerator barGenerator, List<Direction> directions) {
//        directions.add(createFirstDirection(barGenerator));
//    }
//
//    private Direction createFirstDirection(BarGenerator barGenerator) {
//        return Direction.createFirst(barGenerator);
//    }
//
//    private void addMiddleDirection(int namesSize, BarGenerator barGenerator, List<Direction> directions) {
//        IntStream.range(1, namesSize - 1)
//                .mapToObj(count -> createNextDirection(barGenerator, directions))
//                .forEach(directions::add);
//    }
//
//    private Direction createNextDirection(BarGenerator barGenerator, List<Direction> directions) {
//        return lineFinalDirection(directions).createNext(barGenerator);
//    }
//    private void addFinalDirection(List<Direction> directions) {
//        directions.add(createFinalDirection(directions));
//    }
//
//    private Direction createFinalDirection(List<Direction> directions) {
//        return lineFinalDirection(directions).createFinal();
//    }
//
//    private Direction lineFinalDirection(List<Direction> directions) {
//        return directions.get(lineFinalIndex(directions));
//    }
//
//    private int lineFinalIndex(List<Direction> directions) {
//        return directions.size() - 1;
//    }
//
//    public List<Direction> getLine(){
//        return this.line;
//    }
//    //    private Line(List<Direction> line) {
////        this.line = line;
////    }
////
////    public static Line of(int size, BarGenerator barGenerator) {
////        List<Direction> directions = new ArrayList<>();
////        directions.add(createFirstDirection(barGenerator));
////
////        for (int i = 1; i < size - 1; i++) {
////            directions.add(lineFinalDirection(directions).createNext(barGenerator));
////        }
////
////        directions.add(lineFinalDirection(directions).createFinal());
////        return new Line(directions);
////    }
//}
