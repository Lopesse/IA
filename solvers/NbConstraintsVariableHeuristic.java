package solvers;
import java.util.*; 

import representation.*;
public class NbConstraintsVariableHeuristic implements VariableHeuristic{
    private Set<Constraint> ensembleConst;
    private boolean bool;
    public NbConstraintsVariableHeuristic(Set<Constraint> ensembleConst, boolean bool){
        this.ensembleConst=ensembleConst;
        this.bool=bool;
    }

    @Override
    public Variable best(Set<Variable> ensembleVariables, Map<Variable, Set<Object>> ensembleDomaine){
        if(this.bool==true){
            Variable varRetour;
            int countVarPrec = 0;
            for(Variable var : ensembleVariables){
                int countVarEnCours = 0;
                for(Constraint contrainte : this.ensembleConst){
                    if(contrainte.getScope().has(var)){
                        countVarEnCours++;
                    }
                }
                if(countVarPrec<countVarEnCours){
                    varRetour=var;
                }

            }
            return varRetour;
        }
        else{
            Variable varRetour;
            int countVarPrec = 100000;
            for(Variable var : ensembleVariables){
                int countVarEnCours = 0;
                for(Constraint contrainte : this.ensembleConst){
                    if(contrainte.getScope().has(var)){
                        countVarEnCours++;
                    }
                }
                if(countVarPrec>countVarEnCours){
                    varRetour=var;
                }

            }
            return varRetour;
        }
    }

}