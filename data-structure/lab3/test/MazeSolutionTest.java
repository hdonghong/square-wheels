import impl.MazeSolution;
import impl.Point;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MazeSolutionTest {

    @Test
    public void solveByQ() throws Exception {
        int[][] maze =
                {{0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0}};
        MazeSolution solution = new MazeSolution();
        solution.printMaze(maze);
        Assert.assertTrue(solution.solveByQ(maze, new Point(0, 1), new Point(6, 5)));
        System.out.print("队列+BFS求解，");
        solution.printMaze(maze);
    }

    @Test
    public void solveByStack() throws Exception {
        int[][] maze =
                {{0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0}};
        MazeSolution solution = new MazeSolution();
        solution.printMaze(maze);
        Assert.assertTrue(solution.solveByStack(maze, new Point(0, 1), new Point(6, 5)));
        System.out.print("栈+DFS求解，");
        solution.printMaze(maze);
    }

}