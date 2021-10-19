package solvers;

import java.util.*; 

import representation.*;

public class BacktrackSolver extends AbstractSolver{

	public BacktrackSolver(Set<Variable> ensembleVar, Set<Constraint> ensembleConst) {
		super(ensembleVar, ensembleConst);
	}

	@Override
	public Map<Variable, Object> solve() {
		System.out.println("------new solve call------");
		Deque<Variable> variableNonInstanciees = new LinkedList<>(this.ensembleVar);
		Map<Variable, Object> res = this.backtrack(new HashMap<Variable, Object>(), variableNonInstanciees);
		System.out.println("res dans solve: " + res);
		return res;
	}
	
	public Map<Variable, Object> backtrack(
		Map<Variable, Object> instantiationPartielle,
		Deque<Variable> variableNonInstanciees
		) {
		System.out.println("--new backtrack call--");
		System.out.println("contraintes: " + this.ensembleConst);
		System.out.println("variables: " + this.ensembleVar);
		System.out.println("instantiation partielle: " + instantiationPartielle);
		System.out.println("vars non instanciees: " + variableNonInstanciees);

		if(variableNonInstanciees.isEmpty()) {
			System.out.println("--fin de rec. return inst partie--");
			return instantiationPartielle;
		}

		Variable var = variableNonInstanciees.pop();
		System.out.println("variable choisie: " + var + "\nson domaine: " + var.getDomain()); 
		
		for(Object valeur: var.getDomain()) {
			instantiationPartielle.put(var, valeur);
			if(this.isConsistent(instantiationPartielle)) {
				Map<Variable, Object> resultat = this.backtrack(instantiationPartielle, variableNonInstanciees); 
				System.out.println("res: "+ resultat);
				if(resultat != null) {
					return resultat;
				}
			} else {
				System.out.println("not consistent");
			}
			instantiationPartielle.remove(var);
		}
		variableNonInstanciees.push(var);
		System.out.println("--fin de rec. return null--");
		return null;
	}
}
