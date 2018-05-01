import impl.CircSinglyLinkedList;
import impl.JosephusProblem;
import impl.LList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class JosephusProblemTest {
    @Test
    public void solveByCircSinglyLinkedList() throws Exception {
        Assert.assertEquals("[1,2,3,]",
                JosephusProblem.solveByCircSinglyLinkedList(3, 1).toString());
        Assert.assertEquals("[3,6,2,7,5,1,4,]",
                JosephusProblem.solveByCircSinglyLinkedList(7, 3).toString());
        Assert.assertEquals("[5,4,6,2,3,1,]",
                JosephusProblem.solveByCircSinglyLinkedList(6, 5).toString());
    }


    @Test
    public void solveByDoublyLinkedList() throws Exception {
        Assert.assertEquals("[1,2,3,]",
                JosephusProblem.solveByDoublyLinkedList(3, 1).toString());
        Assert.assertEquals("[3,6,2,7,5,1,4,]",
                JosephusProblem.solveByDoublyLinkedList(7, 3).toString());
        Assert.assertEquals("[5,4,6,2,3,1,]",
                JosephusProblem.solveByDoublyLinkedList(6, 5).toString());
    }

    @Test
    public void solveByCHDoublelyLinkedList() throws Exception {
        Assert.assertEquals("[1,2,3,]",
                JosephusProblem.solveByCHDoublelyLinkedList(3, 1).toString());
        Assert.assertEquals("[3,6,2,7,5,1,4,]",
                JosephusProblem.solveByCHDoublelyLinkedList(7, 3).toString());
        Assert.assertEquals("[5,4,6,2,3,1,]",
                JosephusProblem.solveByCHDoublelyLinkedList(6, 5).toString());
    }

}