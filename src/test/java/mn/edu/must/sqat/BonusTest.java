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

    @Test
    @DisplayName("B03: attendance 31-32 invalid null")
    void bonusNullAttendance() {
        assertThrows(
            IllegalArgumentException.class,
            () -> DataFlowTargets.bonus(null, 3)
        );
    }

    @Test
    @DisplayName("B04: threshold 31-32 negative")
    void bonusNegativeThreshold() {
        assertThrows(
            IllegalArgumentException.class,
            () -> DataFlowTargets.bonus(
                new int[]{1, 1}, -1
            )
        );
    }

    @Test
    @DisplayName("B05: empty attendance threshold zero")
    void bonusEmptyArrayThresholdZero() {
        assertEquals(
            5,
            DataFlowTargets.bonus(new int[]{}, 0)
        );
    }

    @Test
    @DisplayName("B06: empty attendance below threshold")
    void bonusEmptyArrayBelowThreshold() {
        assertEquals(
            0,
            DataFlowTargets.bonus(new int[]{}, 1)
        );
    }

    @Test
    @DisplayName("B07: best 43-42 false and 43-53 false")
    void bonusShortStreakAfterReset() {
        int[] attendance = {1, 1, 0, 1};

        assertEquals(
            5,
            DataFlowTargets.bonus(attendance, 3)
        );
    }

    @Test
    @DisplayName("B08: present 40-50 false, score 49-56")
    void bonusSingleAttendanceBelowThreshold() {
        int[] attendance = {1};

        assertEquals(
            0,
            DataFlowTargets.bonus(attendance, 2)
        );
    }

}
