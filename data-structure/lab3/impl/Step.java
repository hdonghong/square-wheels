package impl;

/**
 * Step class<br/>
 * 骑士游历中马的坐标
 * @author hdonghong
 * @date 2018/05/14
 */
public class Step {

    private int x;
    private int y;

    public Step(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /** 上左 */
    public Step upLeft() {
        int x = this.x - 1;
        int y = this.y - 2;
        return (x >= 0 && y >= 0) ? new Step(x, y) : null;
    }

    /** 上右, round指棋盘边界 */
    public Step upRight(int round) {
        int x = this.x + 1;
        int y = this.y - 2;
        return (x <= round && y >= 0) ? new Step(x, y) : null;
    }

    /** 右上，round指棋盘边界*/
    public Step rightUp(int round) {
        int x = this.x + 2;
        int y = this.y - 1;
        return (x <= round && y >= 0) ? new Step(x, y) : null;
    }

    /** 右下，round指棋盘边界*/
    public Step rightDown(int round) {
        int x = this.x + 2;
        int y = this.y + 1;
        return (x <= round && y <= round) ? new Step(x, y) : null;
    }

    /** 下右，round指棋盘边界*/
    public Step downRight(int round) {
        int x = this.x + 1;
        int y = this.y + 2;
        return (x <= round && y <= round) ? new Step(x, y) : null;
    }

    /** 下右，round指棋盘边界*/
    public Step downLeft(int round) {
        int x = this.x - 1;
        int y = this.y + 2;
        return (x >= 0 && y <= round) ? new Step(x, y) : null;
    }

    /** 左下，round指棋盘边界*/
    public Step leftDown(int round) {
        int x = this.x - 2;
        int y = this.y + 1;
        return (x >= 0 && y <= round) ? new Step(x, y) : null;
    }

    /** 左上，round指棋盘边界*/
    public Step leftUp(int round) {
        int x = this.x - 2;
        int y = this.y - 1;
        return (x >= 0 && y >= 0) ? new Step(x, y) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Step step = (Step) o;
        return (x == step.x) && (y == step.y);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result << 5 - result + x;
        result = result << 5 - result + y;
        return result;
    }
}
