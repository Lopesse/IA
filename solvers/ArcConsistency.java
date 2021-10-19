package solvers;

import java.util.*;

import representation.*;

public class ArcConsistency {
	private Set<Constraint> ensembleContraintes;
	public ArcConsistency(Set<Constraint> ensembleContraintes) throws Exception{
		for(Constraint c: ensembleContraintes) {
			if(c.getScope().size() > 2){
				throw new Exception("Une des contraintes porte sur plus de deux variables");
			} 
		}
		this.ensembleContraintes = ensembleContraintes;
	}

	
	public boolean enforceNodeConsistency(Map<Variable, Set<Object>> map) {
		System.out.println("---------------------------");
		System.out.println("map: " + map);
		boolean domaineVide = false;
		for(Variable var: map.keySet()){
			Set<Object> domaine = map.get(var);
			System.out.println("var: " + var);
			Set<Object> valeursAdetruire = new HashSet<Object>();
			for(Constraint c: this.ensembleContraintes){
				if(c.getScope().size() == 1) {
					if(c.getScope().iterator().next() == var){
						System.out.println("contrainte : " + c);
						for(Object val: domaine) {
							Map<Variable, Object> variableValeur = new HashMap<Variable, Object>();
							variableValeur.put(var, val);
							if(!c.isSatisfiedBy(variableValeur)) {
								valeursAdetruire.add(val);
								System.out.println("val a det: " + valeursAdetruire);
							}
						}
					}
				}
			}
			System.out.println("domaine avant: " + domaine);
			System.out.println("val a det: " + valeursAdetruire);
			domaine.removeAll(valeursAdetruire);
			System.out.println("domaine apres: " + domaine);
		}
		
		for(Variable var: map.keySet()) {
			Set<Object> domaine = map.get(var);
			if(domaine.isEmpty()) {
				return false;
			}
		}

		return true;
	}



	public boolean revise(Variable v1, Set<Object> domaine1, Variable v2, Set<Object> domaine2){
		boolean del = false;
		System.out.println("domaines des vars: \nd1: " + domaine1 + "\nd2: " + domaine2);
		Set<Object> valeursAdetruire = new HashSet<Object>();
		for(Object val1: domaine1){
			boolean viable = false;
			for(Object val2: domaine2){
				boolean toutSatisfait = true;
				for(Constraint con: this.ensembleContraintes){
					System.out.println("contrainte : " + con);
					if(con.getScope().size()==2){
						Iterator it = con.getScope().iterator();
						Variable var1 = (Variable) it.next();
						Variable var2 = (Variable) it.next();
						if(!var1.equals(var2)){
							if((var1.equals(v1)||var1.equals(v2)) && (var2.equals(v1)||var2.equals(v2))){
								Map<Variable, Object> map = new HashMap<Variable, Object>();
								map.put(var1, val1);
								map.put(var2, val2);
								System.out.println("map: " + map);
								if(!con.isSatisfiedBy(map)){
									System.out.println("contrainte n'est pas satisfaite par :\nval1: " + val1 + "\nval2: " + val2);
									toutSatisfait = false;
									break;
								} else {
									System.out.println("contrainte satisfaite");
								}
							}
						}
					}
				}
				if(toutSatisfait) {
					viable = true;
					break;
				} 
			}
			if(!viable) {
				valeursAdetruire.add(val1);
				del = true;
			}
		}
	System.out.println("val a det: " + valeursAdetruire);
	domaine1.removeAll(valeursAdetruire);
	return del;
	}


	public boolean ac1(Map<Variable, Set<Object>> varsEtDomaines){
		if(!enforceNodeConsistency(varsEtDomaines)){
			System.out.println("enforce:" + varsEtDomaines );
			return false;
		}
		boolean change;

		do {
			change = false;
			System.out.println(change);
			for(Variable var1: varsEtDomaines.keySet()){
				for(Variable var2: varsEtDomaines.keySet()){
					System.out.println("couple (" + var1 + ", " + var2 + ")");
					if(!var1.equals(var2)){
						if(revise(var1,varsEtDomaines.get(var1),var2,varsEtDomaines.get(var2))){
							change = true;			
						}	
					}
				}
			}
		} while (change);

		for(Variable v: varsEtDomaines.keySet()){
			if(varsEtDomaines.get(v).isEmpty()){
				return false;
			}
		}
		return true;
	}
}

