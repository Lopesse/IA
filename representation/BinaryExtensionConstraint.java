package representation;

import java.util.*;

public class BinaryExtensionConstraint implements Constraint{
	Variable a,b;
	Set<BinaryTuple> combinaisonsAutorisees;
	public BinaryExtensionConstraint(Variable a, Variable b) {
		this.a = a;
		this.b = b;
		this.combinaisonsAutorisees = new HashSet<BinaryTuple>();
	}

	public void addTuple(Object v1,Object v2){
		this.combinaisonsAutorisees.add(new BinaryTuple(v1,v2));
	}

	@Override
	public Set<Variable> getScope() {
		Set<Variable> scope = new HashSet<Variable>();
		scope.add(this.a);
		scope.add(this.b);
		
		return scope;
	}
	
	@Override
	public boolean isSatisfiedBy(Map<Variable, Object> map) {
		Object valeur1, valeur2;
		if((!map.containsKey(this.a)) || (!map.containsKey(this.b))){
			throw new IllegalArgumentException();
		}
		
		valeur1 = map.get(this.a);
		valeur2 = map.get(this.b);

		boolean isIn = false;
		for(BinaryTuple bt: this.combinaisonsAutorisees) {
			if((bt.getValeur1() == valeur1) && (bt.getValeur2() == valeur2)) {
				isIn = true;		
			}
		}

		return isIn;
		
	}
}
