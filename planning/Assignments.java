package planning;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import representation.Variable;
class Assignments {
        /** Must be at least 2. */
        static final int NB_VARIABLES = 10;
        static final Variable[] VARIABLES = new DummyDomainVariable[Assignments.NB_VARIABLES];
        static final Map<Variable, Object> EMPTY_ASSIGNMENT = Collections.emptyMap();
        static final Map<Variable, Object> SINGLE_ASSIGNMENT = new HashMap<>();
        static final Map<Variable, Object> SINGLE_DIFFERENT_ASSIGNMENT = new HashMap<>();
        static final Map<Variable, Object> PARTIAL_ASSIGNMENT = new HashMap<>();
        static final Map<Variable, Object> PARTIAL_DIFFERENT_ASSIGNMENT = new HashMap<>();
        static final Map<Variable, Object> COMPLETE_ASSIGNMENT = new HashMap<>();
        static final Map<Variable, Object> COMPLETE_DIFFERENT_ASSIGNMENT = new HashMap<>();
        static final List<Map<Variable, Object>> ALL_ASSIGNMENTS = new ArrayList<>();
        static {
            for (int i = 0; i < DummyDomainVariable.NB_VALUES; i++) {
                    DummyDomainVariable.DOMAIN.add(i);
            }
            for (int i = 0; i < Assignments.NB_VARIABLES; i++) {
                    Assignments.VARIABLES[i] = new DummyDomainVariable("x" + i);
            }
            for (int i = 0; i < Assignments.NB_VARIABLES; i++) {
                Assignments.COMPLETE_ASSIGNMENT.put(Assignments.VARIABLES[i], i % DummyDomainVariable.NB_VALUES);
                Assignments.COMPLETE_DIFFERENT_ASSIGNMENT.put(Assignments.VARIABLES[i], (i + 1) % DummyDomainVariable.NB_VALUES);
                if (i % 2 == 0) {
                        Assignments.PARTIAL_ASSIGNMENT.put(Assignments.VARIABLES[i], i % DummyDomainVariable.NB_VALUES);
                        Assignments.PARTIAL_DIFFERENT_ASSIGNMENT.put(Assignments.VARIABLES[i], (i + 1) % DummyDomainVariable.NB_VALUES);
                }
                if (i == 0) {
                        Assignments.SINGLE_ASSIGNMENT.put(Assignments.VARIABLES[i], i % DummyDomainVariable.NB_VALUES);
                        Assignments.SINGLE_DIFFERENT_ASSIGNMENT.put(Assignments.VARIABLES[i], (i + 1) % DummyDomainVariable.NB_VALUES);
                }
                }
            Assignments.ALL_ASSIGNMENTS.add(Assignments.EMPTY_ASSIGNMENT);
            Assignments.ALL_ASSIGNMENTS.add(Assignments.SINGLE_ASSIGNMENT);
            Assignments.ALL_ASSIGNMENTS.add(Assignments.SINGLE_DIFFERENT_ASSIGNMENT);
            Assignments.ALL_ASSIGNMENTS.add(Assignments.PARTIAL_ASSIGNMENT);
            Assignments.ALL_ASSIGNMENTS.add(Assignments.PARTIAL_DIFFERENT_ASSIGNMENT);
            Assignments.ALL_ASSIGNMENTS.add(Assignments.COMPLETE_ASSIGNMENT);
            Assignments.ALL_ASSIGNMENTS.add(Assignments.COMPLETE_DIFFERENT_ASSIGNMENT);
        }
}