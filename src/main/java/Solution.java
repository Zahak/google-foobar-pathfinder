import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public String helloWorld() {
        String message = "Hello world";
        System.out.println(message);
        return message;
    }

    public static int solution(int[][] map) {
        Board board = new Board(map);
        PathFinder pathFinder = new PathFinder(board, 0, 0, board.getWidth() - 1, board.getHeight() - 1);
//        return pathFinder.shortestPath().size();
        return pathFinder.shortestPath();
    }
}

class Position {
    final private int x;
    final private int y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Position)) {
            return false;
        }

        Position comparedObject = (Position) o;

        return x == comparedObject.getX()
                && y == comparedObject.getY();
    }

//    @Override
//    public int hashCode() {
//        return 31 * x + y;
//    }
}

class Board {
    private final int[][] board;

    public Board(int[][] board) {
        this.board = board;
//
//        if (getHeight() > 20 || getWidth() > 20) {
//            throw new RuntimeException("Board too big");
//        }
//
//        if (getHeight() < 2 || getWidth() < 2) {
//            throw new RuntimeException("Board too small");
//        }
    }

    final int positionValue(Position position) {
        int value = this.board[position.getY()][position.getX()];

//        if (value != 0 && value != 1) {
//            throw new RuntimeException("Invalid position value");
//        }

        return value;
    }

    final int getWidth() {
        return board[0].length;
    }

    final int getHeight() {
        return board.length;
    }
}

class PathFinder {
    final private Board board;
    final private Position start;
    final private Position end;

    final private List<Position> directions;

    // Stopping paths that are too long should decrease runtime.
    private int numSteps;

    // Map with the number of steps previously required for current room - if more steps this time we might as well stop
    // Since all paths from a certain room is discovered on first try, it doesn't matter if first try worked out or not
    private Map<String, Integer> map;

    public PathFinder(Board board, int startX, int startY, int endX, int endY) {
        this.board = board;
        this.start = new Position(startX, startY);
        this.end = new Position(endX, endY);
        this.numSteps = Integer.MAX_VALUE;

        // List all possible directions
        this.directions = Arrays.asList(
                new Position(1, 0),
                new Position(-1, 0),
                new Position(0, -1),
                new Position(0, 1)
        );

        this.map = new HashMap<>();
    }

    public int shortestPath() {
        List<List<Position>> allPaths = this.getAllPaths();
        if (numSteps == Integer.MAX_VALUE) {
            throw new RuntimeException("Integer MAX_VALUE indicates impassable map");
        }
        return numSteps;
    }

//    public List<Position> shortestPath() {
//        List<List<Position>> allPaths = this.getAllPaths();
//        List<Position> shortestPath = null;
//
//        for (List<Position> path: allPaths) {
//            if (shortestPath == null) {
//                shortestPath = path;
//            }
//            else if (shortestPath.size() > path.size()) {
//                shortestPath = path;
//            }
//        }
//
//        return shortestPath;
//    }

    private List<List<Position>> getAllPaths() {
        List<List<Position>> paths = new ArrayList<>();
        return this.getAllPaths(paths, new ArrayList<Position>(), start, false);
    }

    private List<List<Position>> getAllPaths(List<List<Position>> paths, List<Position> path, Position position, boolean passedWall) {
        // Current path - setting current position
        path.add(position);
        map.put(position.toString() + passedWall, path.size());

//        // Check first room to not have walls
//        if (path.size() == 1 && board.positionValue(position) > 0) {
//            throw new RuntimeException("First room had walls");
//        }

        // Stop if proven longer - should minimize runtime.
        if (path.size() >= numSteps) {
            return paths;
        }

        // If we have reached our goal, add path and return all paths.
        if (position.getX() == end.getX() && position.getY() == end.getY()) {
//            // Last room can not have walls
//            if (board.positionValue(position) > 0) {
//                throw new RuntimeException("Last room had walls");
//            }

            // Number of steps to limit unnecessary runs.
            this.numSteps = path.size();

            // Add path since it was successful.
            paths.add(path);
            return paths;
        }

        for (Position direction: directions) {
            int newX = position.getX() + direction.getX();
            int newY = position.getY() + direction.getY();

            // Check if new position follows the rules
            if (newX >= board.getWidth() || newX < 0 || newY >= board.getHeight() || newY < 0) {
                continue;
            }

            Position newPosition = new Position(newX, newY);

            if (path.contains(newPosition) ||
                    (map.containsKey(newPosition.toString() + passedWall) && map.get(newPosition.toString() + passedWall) <= path.size() + 1)) {
                continue;
            }

            boolean wall = board.positionValue(position) > 0;
            if (wall && passedWall) {
                continue;
            }
            else if (wall) {
                getAllPaths(paths, new ArrayList<>(path), newPosition, true);
            }
            else {
                getAllPaths(paths, new ArrayList<>(path), newPosition, passedWall);
            }
        }

        return paths;
    }
}