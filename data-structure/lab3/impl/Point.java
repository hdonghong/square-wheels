package impl;

/**
 * Point class<br/>
 * 用于迷宫求解的点，表示具体某个坐标
 * @author hdonghong
 * @date 2018/05/13
 */
public class Point {

    /** 横坐标 */
    private int x;

    /** 纵坐标 */
    private int y;

    public Point(int x, int y) {
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

    /** 向右转，起步走 停 */
    public Point right() {
        return new Point(x + 1, y);
    }

    /** 向左转，起步走 停 */
    public Point left() {
        return x == 0 ? null : new Point(x - 1, y);
    }

    /** 起步走 停 */
    public Point up() {
        return y == 0 ? null : new Point(x, y - 1);
    }

    /** 向后转，起步走 停 */
    public Point down() {
        return new Point(x, y + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Point point = (Point) o;

        return (x == point.x) && (y == point.y);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}
