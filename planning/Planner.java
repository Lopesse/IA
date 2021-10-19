package planning;
import representation.*;
import java.util.*;

public interface Planner{

    public List<Action> plan();
    public Map<Variable, Object> getInitialState();
    public Set<Action> getActions();
    public Goal getGoal();

}