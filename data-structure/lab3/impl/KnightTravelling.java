package impl;

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
     * DFS暴力解
     * @param checkerboard 棋盘
     * @param start 起点
     */
    public void solve(int[][] checkerboard, Step start) {
        // 访问标记，起标记当前坐标是否被访问过，访问的标记为true
        boolean[][] visitedMark = new boolean[checkerboard.length][checkerboard[0].length];

        // 棋盘大小
        int boardSize = checkerboard.length * checkerboard[0].length;

        // 存储遍历过的节点，知起点一定会被遍历，所以压栈
        Stack<Step> visitedSteps = new Stack<>();
        visitedSteps.add(start);

        while (visitedSteps.size() < boardSize) {
            Step nextStep = getNextStep(visitedMark, visitedSteps.peek());
            // 走到死路，回溯处理
            if (nextStep == null) {
                visitedSteps.pop();
                continue;
            }

            visitedMark[nextStep.getY()][nextStep.getX()] = true;
            visitedSteps.push(nextStep);
        }

    }

    /**
     * 辅助solve方法，获取当前位置的相邻可行步作为下一步坐标
     * @param visitedMark 访问标记的二维数组
     * @param current 当前坐标点
     * @return 下一步坐标点
     */
    private Step getNextStep(boolean[][] visitedMark, Step current) {
        int round = visitedMark.length - 1;

        Step upLeft = current.upLeft();
        if (upLeft != null && !visitedMark[upLeft.getY()][upLeft.getX()]) {
            return upLeft;
        }

        Step upRight = current.upRight(round);
        if (upRight != null && !visitedMark[upRight.getY()][upRight.getX()]) {
            return upRight;
        }

        Step rightUp = current.rightUp(round);
        if (rightUp != null && !visitedMark[rightUp.getY()][rightUp.getX()]) {
            return rightUp;
        }

        Step rightDown = current.rightDown(round);
        if (rightDown != null && !visitedMark[rightDown.getY()][rightDown.getX()]) {
            return rightDown;
        }

        Step downRight = current.downRight(round);
        if (downRight != null && !visitedMark[downRight.getY()][downRight.getX()]) {
            return downRight;
        }

        Step downLeft = current.downLeft(round);
        if (downLeft != null && !visitedMark[downLeft.getY()][downLeft.getX()]) {
            return downLeft;
        }

        Step leftDown = current.leftDown(round);
        if (leftDown != null && !visitedMark[leftDown.getY()][leftDown.getX()]) {
            return leftDown;
        }

        Step leftUp = current.leftUp(round);
        if (leftUp != null && !visitedMark[leftUp.getY()][leftUp.getX()]) {
            return leftUp;
        }
        // 死路
        return null;
    }
}
