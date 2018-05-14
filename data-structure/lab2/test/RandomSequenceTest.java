import impl.RandomSequence;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomSequenceTest {
    @Test
    public void getRandomSequence() throws Exception {
        RandomSequence sequence = new RandomSequence();
        System.out.println(sequence.getRandomSequence(10));
        System.out.println(sequence.addElements(10));
        System.out.println(sequence.remove(10));
    }

}