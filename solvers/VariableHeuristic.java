package solvers;
import java.util.*; 

import representation.*;
public interface VariableHeuristic{
    public Variable best(Set<Variable> ensembleVariables, Map<Variable, Set<Object>> ensembleDomaine);
}