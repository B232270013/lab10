package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class BonusTest {

    @Test
    @DisplayName("B01: all-defs score 49-54, streak 46-41")
    void allDefsBelowThresholdWithLongStreak() {
        int[] attendance = {1, 0, 1, 1, 1, 1, 1};

        assertEquals(3,
                DataFlowTargets.bonus(attendance, 7));
    }

    @Test
    @DisplayName("B02: all-defs score 51-54 and 54-56")
    void allDefsThresholdMetWithLongStreak() {
        int[] attendance = {1, 1, 1, 1, 1};

        assertEquals(8,
                DataFlowTargets.bonus(attendance, 5));
    }
}
