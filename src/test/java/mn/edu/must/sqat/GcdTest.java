package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class GcdTest {
    @Test
    @DisplayName("G01: x 13-20; y 13-15 false")
    void gcdNoIteration() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    @DisplayName("G02: x 13-16,17-16,17-20; y 13-15,13-16,13-17,18-15,18-16,18-17; tmp 16-18")
    void gcdTwoIterations() {
        assertEquals(4, DataFlowTargets.gcd(12, 8));
    }
}
