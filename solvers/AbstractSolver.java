package solvers;
import java.util.*;
import representation.*;


public abstract class AbstractSolver implements Solver{
	Set<Variable> ensembleVar;
	Set<Constraint> ensembleConst;
	public AbstractSolver(Set<Variable> ensembleVar, Set<Constraint> ensembleConst) {
		this.ensembleVar = ensembleVar;
		this.ensembleConst = ensembleConst;
	}
	
	public boolean isConsistent(Map<Variable, Object> affectationPartielle) {
		if(!this.ensembleConst.isEmpty()) {
			for(Constraint contrainte : this.ensembleConst) {
				Set<Variable> portee = contrainte.getScope();
				for(Variable var : portee) {
					if(!affectationPartielle.keySet().contains(var)) {
						System.out.println("affectation partielle ne contient pas " + var);
						return true;
					}
				}
				if(!contrainte.isSatisfiedBy(affectationPartielle)) {
					System.out.println("contrainte " + contrainte +  " n'est pas satisfaite par " + affectationPartielle);
					return false;
				}
			}
		}
		return true;
	}
}
