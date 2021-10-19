package solvers;
import java.util.*; 

import representation.*;
public class HeuristicMACSolver extends AbstractSolver{
    Set<Variable> ensembleVariables;
    Set<Constraint> ensembleContraintes;
    VariableHeuristic varHeuristic;
    ValueHeuristic valHeuristic;
    public HeuristicMACSolver(Set<Variable> ensembleVariables, Set<Constraint> ensembleContraintes, VariableHeuristic varHeuristic, ValueHeuristic valHeuristic){
        this.ensembleContraintes=ensembleContraintes;
        this.ensembleVariables=ensembleVariables;
        this.varHeuristic=varHeuristic;
        this.valHeuristic=valHeuristic;

    }
    @Override
    public Map<Variable, Object> solve(){
        return null;
    }

}