package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusTest {

    @Test
    @DisplayName("AD1: all-defs; score 49->54 and 54->56; "
            + "present 35/40, streak 36/41, best 37/43, a 38, parameters 31")
    void bonusLongBelowThreshold() {
        assertEquals(3, DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 1}, 6));
    }

    @Test
    @DisplayName("AD2: all-defs; streak 46->41 and score 51->56")
    void bonusResetAtThreshold() {
        assertEquals(5, DataFlowTargets.bonus(new int[]{1, 0, 1}, 2));
    }

    @Test
    @DisplayName("DP1: attendance 31->32(T); null input")
    void bonusRejectsNull() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(null, 0));
    }

    @Test
    @DisplayName("DP2: threshold 31->32(T); negative threshold")
    void bonusRejectsNegativeThreshold() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(new int[]{}, -1));
    }

    @Test
    @DisplayName("DP3: present 35->50(F), best 37->53(F), score 49->56; empty input")
    void bonusEmptyBelowThreshold() {
        assertEquals(0, DataFlowTargets.bonus(new int[]{}, 1));
    }

    @Test
    @DisplayName("DP4: present 35->50(T), best 37->53(F); all absent, threshold zero")
    void bonusAllAbsentZeroThreshold() {
        assertEquals(5, DataFlowTargets.bonus(new int[]{0, 0, 0}, 0));
    }

    @Test
    @DisplayName("DP5: score 51->54 and 54->56; streak longer than five")
    void bonusLongAtThreshold() {
        assertEquals(8, DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 1, 1}, 6));
    }
}
