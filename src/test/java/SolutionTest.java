import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void testPositionEquals() {
        Position testPosition = new Position(0, 0);
        Position testPositionTwo = new Position(0, 0);
        Position testPositionThree = new Position(1, 0);

        assertEquals(testPosition, testPositionTwo);
        assertNotEquals(testPosition, testPositionThree);
        assertNotSame(testPosition, testPositionTwo);
        assertNotSame(testPosition, testPositionThree);
    }

    @Test
    public void testPositionToString() {
        Position testPosition = new Position(0, 0);
        assertEquals("(0,0)", testPosition.toString());
    }

    @Test(expected = RuntimeException.class)
    public void testImpassablePassage() {
        int[][] impassable = {
                {0, 0, 1},
                {1, 1, 1},
                {0, 1, 0}
        };
        System.out.println(Solution.solution(impassable));
    }

    @Test
    public void testCaseOne() {
        int[][] caseOne = {{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}};
        assertEquals(7, Solution.solution(caseOne));
    }
    @Test
    public void testCaseTwo() {
        int[][] caseTwo = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};
        assertEquals(11, Solution.solution(caseTwo));
    }

    @Test
    public void testCaseThree() {
        int[][] testCaseThree = {
                {0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(Solution.solution(testCaseThree));
    }

    @Test
    public void testCaseFour() {
        int[][] testCaseFour = {
                {0, 0},
                {1, 0}
        };
        assertEquals(3, Solution.solution(testCaseFour));
    }

//    @Test(expected = RuntimeException.class)
//    public void testTooBigBoard() {
//        int[][] caseTooBigBoard = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}};
//        Solution.solution(caseTooBigBoard);
//    }

//    @Test(expected = RuntimeException.class)
//    public void testTooBigBoardTwo() {
//        int[][] caseTooBigBoardTwo = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
//        Solution.solution(caseTooBigBoardTwo);
//    }

//    @Test(expected = RuntimeException.class)
//    public void testTooSmallBoard() {
//        int[][] caseTooSmallBoard = {{0}, {0}};
//        Solution.solution(caseTooSmallBoard);
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void testTooSmallBoardTwo() {
//        int[][] caseTooSmallBoardTwo = {{0,0}};
//        Solution.solution(caseTooSmallBoardTwo);
//    }

//    @Test(expected = RuntimeException.class)
//    public void denyFaultyRoomValues() {
//        int[][] denyFaultyRoomValues = {{0, 2, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}};
//        Solution.solution(denyFaultyRoomValues);
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void denyFaultyRoomValuesTwo() {
//        int[][] denyFaultyRoomValuesTwo = {{0, -1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}};
//        Solution.solution(denyFaultyRoomValuesTwo);
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void denyFaultyRoomValuesThree() {
//        int[][] denyFaultyRoomValuesThree = {{1, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}};
//        Solution.solution(denyFaultyRoomValuesThree);
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void denyFaultyRoomValuesFour() {
//        int[][] denyFaultyRoomValuesFour = {{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 1}};
//        Solution.solution(denyFaultyRoomValuesFour);
//    }
}
