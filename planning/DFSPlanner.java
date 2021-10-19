package planning;
import representation.*;
import java.util.*;

public class DFSPlanner implements Planner{
    protected Map<Variable, Object> etatInit;
    protected Set<Action> ensembleAction;
    protected Goal buts;

    public DFSPlanner(Map<Variable, Object> etatInit, Set<Action> ensembleAction, Goal buts){
        this.etatInit = etatInit;
        this.ensembleAction = ensembleAction;
        this.buts = buts;
    }

    public List<Action> plan(){
        HashSet<Map<Variable, Object>> closed = new HashSet<Map<Variable, Object>>();
        closed.add(this.etatInit);
        List<Action> plan = new ArrayList<Action>();
        return dfs(this.etatInit, plan, this.buts, closed);
    }
    public Map<Variable, Object> getInitialState(){
        return this.etatInit;
    }
    public Set<Action> getActions(){
        return this.ensembleAction;
    }
    public Goal getGoal(){
        return this.buts;
    }

    public List<Action> dfs(Map<Variable, Object> etatInit, List<Action> plan, Goal buts, Set<Map<Variable, Object>> closed){
        if(buts.isSatisfiedBy(etatInit)){
            return plan;
        }
        else{
            for(Action act: this.ensembleAction){
                if(act.isApplicable(etatInit)){
                    Map<Variable, Object> prochain = act.successor(etatInit);
                    if(!closed.contains(prochain)){
                        plan.add(act);
                        closed.add(prochain);
                        List<Action> subplan = dfs(prochain, plan, buts, closed);
                        if(subplan != null){
                            return subplan;
                        }else{
                            plan.remove(plan.size()-1);
                        }
                    }
                }
            }
            return null;
        }
    }

}