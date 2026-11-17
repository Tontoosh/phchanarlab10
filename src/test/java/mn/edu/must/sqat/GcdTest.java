package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GcdTest {

    @Test
    @DisplayName("G1: x 13->20 (c-use); y 13->15(F) (p-use)")
    void gcdZeroSecondArgumentCoversEntryToReturn() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    @DisplayName("G2: x 13->16, 17->16, 17->20; "
            + "y 13->15(T), 13->16, 13->17, 18->15(T/F), 18->16, 18->17; "
            + "tmp 16->18")
    void gcdTwoIterationsCoversLoopCarriedPairs() {
        assertEquals(4, DataFlowTargets.gcd(12, 8));
    }
}
