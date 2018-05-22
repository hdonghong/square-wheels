package impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * KnightTravelling class<br/>
 * （5）骑士游历
 * 骑士游历问题是指，在国际象棋的棋盘（8行*8列）上，一个马要遍历棋盘，即走到棋盘上的每一格，
 * 并且每格只到达一次。设码在棋盘的某一位置（x,y）上，按照“走马日”的规则，下一步有8个方向走，
 * 如图所示。若给定起始位置（x0,y0）,使用站和队列探索出一条马遍历棋盘的路径。
 * @author hdonghong
 * @date 2018/05/14
 */
public class KnightTravelling {

    /**
     * 解决骑士游历问题，同时将传入的棋盘矩阵标记游历顺序，从0开始 <br/>
     * DFS暴力解，但是解不出8*8及其以上棋盘，时间复杂度太高
     * @param checkerboard 棋盘
     * @param start 起点
     */
    public void solve(int[][] checkerboard, Step start) {
        // 棋盘大小
        int boardSize = checkerboard.length * checkerboard[0].length;

        // 方向访问标记，标记当前坐标是否过某个方向 1 - 8
        int[][] dirnMark = new int[checkerboard.length][checkerboard[0].length];

        // 存储遍历过的节点，知起点一定会被遍历，所以压栈
        Stack<Step> visitedSteps = new Stack<>();
        visitedSteps.add(start);

        while (visitedSteps.size() < boardSize - 1) {
            // 无解
            if (visitedSteps.isEmpty()) { throw new IllegalArgumentException(ERROR_CODE); }

            // 前进吧，骑士~
            Step nextStep = getNextStep(checkerboard.length - 1, visitedSteps.peek(), dirnMark);
            // 走到死路，回溯处理，恢复方向访问记录
            if (nextStep == null) {
                Step current = visitedSteps.pop();
                dirnMark[current.getY()][current.getX()] = NO_DIRN;
                continue;
            }
            visitedSteps.push(nextStep);

        }

        // 标记游历顺序，0开始
        while (!visitedSteps.isEmpty()) {
            Step current = visitedSteps.pop();
            checkerboard[current.getY()][current.getX()] = visitedSteps.size();
        }
    }

    /**
     * 解决骑士游历问题，同时将传入的棋盘矩阵标记游历顺序，从0开始 <br/>
     * DFS+贪心解，选择最优方向前进（定义所前进坐标的可选方向最少，则该前进坐标为最优方向）
     * @param checkerboard 棋盘
     * @param start 起点
     */
    public void solveByGreed(int[][] checkerboard, Step start) {
        int boardSize = checkerboard.length * checkerboard[0].length;

        // 访问标记，标记当前坐标是否过某个方向，增加一维0-8，0表示访问与否，1-8标记具体方向
        boolean[][][] dirnMark = new boolean[checkerboard.length][checkerboard.length][9];
        dirnMark[start.getY()][start.getX()][NO_DIRN] = true;

        // 存储遍历过的节点，起点一定会被遍历，所以压栈
        Stack<Step> visitedSteps = new Stack<>();
        visitedSteps.push(start);

        while (visitedSteps.size() < boardSize) {
            // 无解
            if (visitedSteps.isEmpty()) {
                throw new IllegalArgumentException(ERROR_CODE);
            }

            // 找出当前点的可选方向坐标中 可选方向最少的
            Step current = visitedSteps.peek();
            Step nextStep = null;
            int minCount = Integer.MAX_VALUE;
            int nextDirn = NO_DIRN;
            for (int i = UP_LEFT; i <= LEFT_UP; i++) {
                if (!dirnMark[current.getY()][current.getX()][i]) {
                    Step next = getNextStep(checkerboard.length - 1, current, i);
                    boolean existed = (next != null && !dirnMark[next.getY()][next.getX()][NO_DIRN]);
                    if (existed) {
                        int count = countNext(checkerboard.length - 1, next, dirnMark);
                        if (count > 0 && count < minCount) {
                            minCount = count;
                            nextDirn = i;
                            nextStep = next;
                        }
                    }
                }
            }

            // 当前坐标是死路，回溯
            if (nextDirn == NO_DIRN) {
                for (int i = NO_DIRN; i <= LEFT_UP; i++) {
                    dirnMark[current.getY()][current.getX()][i] = false;
                }
                visitedSteps.pop();
                continue;
            }

            dirnMark[current.getY()][current.getX()][NO_DIRN] = true;
            dirnMark[current.getY()][current.getX()][nextDirn] = true;
            visitedSteps.push(nextStep);

        }

        // 标记游历顺序，0开始
        while (!visitedSteps.isEmpty()) {
            Step current = visitedSteps.pop();
            checkerboard[current.getY()][current.getX()] = visitedSteps.size();
        }
    }

    /**
     * 辅助solve方法，获取当前位置的最优相邻可行步作为下一步坐标
     * @param round 边界
     * @param current 当前坐标点
     * @param dirnMark 方向访问标记，1-8
     * @return 下一步坐标点
     */
    private Step getNextStep(int round, Step current, int[][] dirnMark) {

        // 要求上左方向非空，左上坐标没有方向访问记录说明未被访问过，当前点未往左上方向走过
        Step upLeft = current.upLeft();
        if (upLeft != null && dirnMark[upLeft.getY()][upLeft.getX()] == NO_DIRN && dirnMark[current.getY()][current.getX()] < UP_LEFT) {
            // 标记访问了这个方向
            dirnMark[current.getY()][current.getX()] = UP_LEFT;
            return upLeft;
        }

        Step upRight = current.upRight(round);
        if (upRight != null && dirnMark[upRight.getY()][upRight.getX()] == NO_DIRN  && dirnMark[current.getY()][current.getX()] < UP_RIGHT) {
            dirnMark[current.getY()][current.getX()] = UP_RIGHT;
            return upRight;
        }

        Step rightUp = current.rightUp(round);
        if (rightUp != null && dirnMark[rightUp.getY()][rightUp.getX()] == NO_DIRN  && dirnMark[current.getY()][current.getX()] < RIGHT_UP) {
            dirnMark[current.getY()][current.getX()] = RIGHT_UP;
            return rightUp;
        }

        Step rightDown = current.rightDown(round);
        if (rightDown != null && dirnMark[rightDown.getY()][rightDown.getX()] == NO_DIRN  && dirnMark[current.getY()][current.getX()] < RIGHT_DOWN) {
            dirnMark[current.getY()][current.getX()] = RIGHT_DOWN;
            return rightDown;
        }

        Step downRight = current.downRight(round);
        if (downRight != null && dirnMark[downRight.getY()][downRight.getX()] == NO_DIRN  && dirnMark[current.getY()][current.getX()] < DOWN_RIGHT) {
            dirnMark[current.getY()][current.getX()] = DOWN_RIGHT;
            return downRight;
        }

        Step downLeft = current.downLeft(round);
        if (downLeft != null && dirnMark[downLeft.getY()][downLeft.getX()] == NO_DIRN  && dirnMark[current.getY()][current.getX()] < DOWN_LEFT) {
            dirnMark[current.getY()][current.getX()] = DOWN_LEFT;
            return downLeft;
        }

        Step leftDown = current.leftDown(round);
        if (leftDown != null && dirnMark[leftDown.getY()][leftDown.getX()] == NO_DIRN  && dirnMark[current.getY()][current.getX()] < LEFT_DOWN) {
            dirnMark[current.getY()][current.getX()] = LEFT_DOWN;
            return leftDown;
        }

        Step leftUp = current.leftUp(round);
        if (leftUp != null && dirnMark[leftUp.getY()][leftUp.getX()] == NO_DIRN  && dirnMark[current.getY()][current.getX()] < LEFT_UP) {
            dirnMark[current.getY()][current.getX()] = LEFT_UP;
            return leftUp;
        }

        // 死路
        return null;
    }

    /**
     * 辅助solveByGreed方法，返回当前坐标指定方向的坐标
     * @param round 边界
     * @param current 当前坐标
     * @param dirn 指定方向
     * @return 当前坐标指定方向的坐标
     */
    private Step getNextStep(int round, Step current, int dirn) {

        switch (dirn) {
            case UP_LEFT: return current.upLeft();
            case UP_RIGHT: return current.upRight(round);
            case RIGHT_UP: return current.rightUp(round);
            case RIGHT_DOWN: return current.rightDown(round);
            case DOWN_RIGHT: return current.downRight(round);
            case DOWN_LEFT: return current.downLeft(round);
            case LEFT_DOWN: return current.leftDown(round);
            case LEFT_UP: return current.leftUp(round);
            default: return null;
        }
    }

    /**
     * 统计当前坐标的可选方向数量
     * @param round 边界
     * @param current 当前坐标
     * @param dirnMark 方向标记
     * @return 可选方向数量
     */
    private int countNext(int round, Step current, boolean[][][] dirnMark) {
        int result = 0;
        for (int i = UP_LEFT; i <= LEFT_UP; i++) {
            Step next = getNextStep(round, current, i);
            if (next != null && !dirnMark[next.getY()][next.getX()][NO_DIRN]) {
                result++;
            }
        }
        return result;
    }

    /** 定义9个方向，0是无方向，也表示一种方向~ */
    private static final int NO_DIRN =      0;
    private static final int UP_LEFT =      1;
    private static final int UP_RIGHT =     2;
    private static final int RIGHT_UP =     3;
    private static final int RIGHT_DOWN =   4;
    private static final int DOWN_RIGHT =   5;
    private static final int DOWN_LEFT =    6;
    private static final int LEFT_DOWN =    7;
    private static final int LEFT_UP =      8;

    /** 错误码 */
    private static final String ERROR_CODE = "(╯▔皿▔)╯";
}
