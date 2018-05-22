import impl.KnightTravelling;
import impl.Step;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class KnightTravellingTest {

    @Test
    public void solve() throws Exception {
        KnightTravelling knight = new KnightTravelling();
        int[][] board = new int[8][8];
        knight.solve(board, new Step(3, 4));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.format("%3d\t", board[i][j]);
            }
            System.out.println();
        }
    }

    @Test
    public void solveByGreed() throws Exception {
        KnightTravelling knight = new KnightTravelling();
        int[][] board = new int[8][8];
        knight.solveByGreed(board, new Step(3, 4));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.format("%3d\t", board[i][j]);
            }
            System.out.println();
        }
    }

}