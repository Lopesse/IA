package planning;
import representation.*;
import planningtests.*;
import java.util.*;
import testutil.Util;

class BasicGoalTests{

    public static void main(String[] args){
        boolean ok = true;
        Util.log("BasicGoalTests","testIsSatisfiedBy");
        BasicGoal goal = null;
        // goal with empty precondition
        goal = new BasicGoal(Collections.emptyMap());
        for (Map<Variable, Object> state : Assignments.ALL_ASSIGNMENTS) {
            ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, state, true);
        }
        // goal with single precondition
        goal = new BasicGoal(Assignments.SINGLE_ASSIGNMENT);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.EMPTY_ASSIGNMENT, false);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.SINGLE_ASSIGNMENT, true);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.SINGLE_DIFFERENT_ASSIGNMENT, false);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.PARTIAL_ASSIGNMENT, true);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.PARTIAL_DIFFERENT_ASSIGNMENT, false);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.COMPLETE_ASSIGNMENT, true);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.COMPLETE_DIFFERENT_ASSIGNMENT, false);
        // goal with partial precondition
        goal = new BasicGoal(Assignments.PARTIAL_ASSIGNMENT);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.EMPTY_ASSIGNMENT, false);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.SINGLE_ASSIGNMENT, false);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.SINGLE_DIFFERENT_ASSIGNMENT, false);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.PARTIAL_ASSIGNMENT, true);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.PARTIAL_DIFFERENT_ASSIGNMENT, false);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.COMPLETE_ASSIGNMENT, true);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.COMPLETE_DIFFERENT_ASSIGNMENT, false);
        // goal with complete precondition
        goal = new BasicGoal(Assignments.COMPLETE_ASSIGNMENT);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.EMPTY_ASSIGNMENT, false);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.SINGLE_ASSIGNMENT, false);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.SINGLE_DIFFERENT_ASSIGNMENT, false);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.PARTIAL_ASSIGNMENT, false);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.PARTIAL_DIFFERENT_ASSIGNMENT, false);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.COMPLETE_ASSIGNMENT, true);
        ok = ok && BasicGoalTests.testIsSatisfiedBy(goal, Assignments.COMPLETE_DIFFERENT_ASSIGNMENT, false);
        // return Util.result(ok);
        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }

    private static boolean testIsSatisfiedBy(BasicGoal goal, Map<Variable, Object> state, boolean expected) {
        boolean computed = goal.isSatisfiedBy(state);
        if (computed != expected) {
            System.out.println("isSatisfiedBy returned " + computed + " for goal " + goal + " and state " + state);
            return false;
        } else {
            return true;
        }
    }

}