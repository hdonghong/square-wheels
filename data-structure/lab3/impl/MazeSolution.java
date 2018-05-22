package impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * MazeSolution class<br/>
 *（4）	走迷宫。
 * 一个迷宫如图所示，他有一个入口和一个出口，其中白色单元表示通路，黑色单元表示不通路。
 * 试寻找一条从入口到出口的路径，每一部只能从一个白色单元走到相邻的白色单元，直至出口。
 * 分别用栈和队列求解问题。
 * 这里用0表示不痛路，1表示通路，2表示走过路径
 *
 * blog https://blog.csdn.net/honhong1024/article/details/80375144
 * @author hdonghong
 * @date 2018/05/13
 */
public class MazeSolution {

    /**
     * 队列与BFS算法求解迷宫最短路径
     * @param maze 迷宫
     * @param start 起点
     * @param end 终点
     * @return false表示无解
     */
    public boolean solveByQ(int[][] maze, Point start, Point end) {

        // api调用者搞事
        if (maze == null || start == null || end == null ||
            maze[start.getY()][start.getX()] != ACCESS || maze[end.getY()][end.getX()] != ACCESS) {
            throw new IllegalArgumentException(ERROR_CODE);
        }
        // 起点即终点
        if (start.equals(end)) { return true; }

        // 前驱标记，起标记上个坐标和标记被访问的作用，记录访问当前坐标时的前一个坐标，null时表示当前坐标未被访问
        Point[][] preMark = new Point[maze.length][maze[0].length];

        // 存储即将被遍历的节点
        Queue<Point> visitingPoints = new LinkedList<>();
        visitingPoints.add(start);

        while (!visitingPoints.isEmpty()) {
            // 取出队首元素，作为当前起点坐标
            Point current = visitingPoints.poll();

            // 探寻当前坐标的 ↑→↓← 是否通路且是否未被访问过，符合条件则加入队列等待被访问
            // ↑
            Point up = current.up();
            if (up != null &&
                maze[up.getY()][up.getX()] == ACCESS &&
                preMark[up.getY()][up.getX()] == null) {
                // 向上走通路，且上节点未被访问，做个标记
                preMark[up.getY()][up.getX()] = current;
                visitingPoints.add(up);
                // 到终点则跳出循环
                if (up.equals(end)) { break; }
            }
            // →
            Point right = current.right();
            if (right.getX() < maze[0].length &&
                maze[right.getY()][right.getX()] == ACCESS &&
                preMark[right.getY()][right.getX()] == null) {

                preMark[right.getY()][right.getX()] = current;
                visitingPoints.add(right);
                if (right.equals(end)) { break; }
            }
            // ↓
            Point down = current.down();
            if (down.getY() < maze.length &&
                maze[down.getY()][down.getX()] == ACCESS &&
                preMark[down.getY()][down.getX()] == null) {

                preMark[down.getY()][down.getX()] = current;
                visitingPoints.add(down);
                if (down.equals(end)) { break; }
            }
            // ←
            Point left = current.left();
            if (left != null &&
                maze[left.getY()][left.getX()] == ACCESS &&
                preMark[left.getY()][left.getX()] == null) {

                preMark[left.getY()][left.getX()] = current;
                visitingPoints.add(left);
                if (left.equals(end)) { break; }
            }
        }

        // 找不到出口
        if (visitingPoints.isEmpty()) { return false; }

        // 验证标记路径从出口找回入口
        Point p = end;
        while (!p.equals(start)) {
            maze[p.getY()][p.getX()] = VISITED;
            p = preMark[p.getY()][p.getX()];
        }
        maze[p.getY()][p.getX()] = VISITED;


        return true;
    }

    /**
     * 栈与DFS算法求解迷宫路径，非最短路径
     * @param maze 迷宫
     * @param start 起点
     * @param end 终点
     * @return false表示无解
     */
    public boolean solveByStack(int[][]maze, Point start, Point end) {

        // api调用者搞事
        if (maze == null || start == null || end == null ||
                maze[start.getY()][start.getX()] != ACCESS || maze[end.getY()][end.getX()] != ACCESS) {
            throw new IllegalArgumentException(ERROR_CODE);
        }
        // 起点即终点
        if (start.equals(end)) { return true; }

        // 访问标记，起标记当前坐标是否被访问过或者不通路，访问过或者不通路的标记为true
        boolean[][] visitedMark = new boolean[maze.length][maze[0].length];
        for (int i = 0; i < visitedMark.length; i++) {
            for (int j = 0; j < visitedMark[i].length; j++) {
                visitedMark[i][j] = (maze[i][j] == NO_ACCESS);
            }
        }

        // 存储被遍历的节点
        Stack<Point> visitedPoints = new Stack<>();
        visitedPoints.push(start);

        // 非空栈，且未到出口
        while (!visitedPoints.isEmpty() && !end.equals(visitedPoints.peek())) {
            // 获取下一步
            Point nextPoint = getNextPoint(visitedMark, visitedPoints.peek());
            // 如果走到死路，则回溯
            if (nextPoint == null) {
                visitedPoints.pop();
                continue;
            }

            // 否则标记下一步坐标
            visitedMark[nextPoint.getY()][nextPoint.getX()] = true;
            visitedPoints.add(nextPoint);
        }

        // 找不到出口
        if (visitedPoints.isEmpty()) { return false; }

        // 从出口寻回入口
        while (!visitedPoints.isEmpty()) {
            Point p = visitedPoints.pop();
            maze[p.getY()][p.getX()] = VISITED;
        }

        return true;
    }

    /**
     * 辅助solveByStack方法，获取当前坐标的相邻可行节点作为下一步坐标
     * @param visitedMark 访问标记的二维数组
     * @param current 当前坐标点
     * @return 下一步坐标点
     */
    private Point getNextPoint(boolean[][] visitedMark, Point current) {
        // 上节点通路
        Point up = current.up();
        if (up != null && !visitedMark[up.getY()][up.getX()]) { return up; }

        // 右节点通路
        Point right = current.right();
        if (right.getX() < visitedMark[0].length && !visitedMark[right.getY()][right.getX()]) { return right; }

        // 下节点通路
        Point down = current.down();
        if (down.getX() < visitedMark.length && !visitedMark[down.getY()][down.getX()]) { return down; }

        // 左节点通路
        Point left = current.left();
        if (left != null && !visitedMark[left.getY()][left.getX()]) { return left; }

        // 死路
        return null;
    }

    /**
     * 打印迷宫
     */
    public void printMaze(int[][] maze) {
        System.out.println("当前迷宫：");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if(maze[i][j] == NO_ACCESS) { System.out.print("██"); }
                else if(maze[i][j] == ACCESS)  { System.out.print("  "); }
                else  { System.out.print("* "); }
            }
            System.out.println();
        }
        System.out.println();
    }

    /** 错误码 */
    private static final String ERROR_CODE = "(╯▔皿▔)╯";
    /** 不通路 */
    private static final int NO_ACCESS = 0;
    /** 通路 */
    private static final int ACCESS = 1;
    /** 走过的路 */
    private static final int VISITED = 2;
}
