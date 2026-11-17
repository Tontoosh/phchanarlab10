package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
