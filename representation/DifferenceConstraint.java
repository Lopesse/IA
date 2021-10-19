package representation;

import java.util.*;

public class DifferenceConstraint implements Constraint{
	Variable v1, v2;
	public DifferenceConstraint(Variable v1, Variable v2) {
		this.v1=v1;
		this.v2=v2;
	}
	@Override
	public Set<Variable> getScope() {
		Set<Variable> scope = new HashSet<Variable>();
		scope.add(this.v1);
		scope.add(this.v2);
		
		return scope;
	}

	@Override
	public boolean isSatisfiedBy(Map<Variable, Object> map) {
		Object valeur1, valeur2;
		if((!map.containsKey(this.v1)) || (!map.containsKey(this.v2))){
			throw new IllegalArgumentException();
		}
		valeur1 = map.get(this.v1);
		valeur2 = map.get(this.v2);
		
		return !valeur1.equals(valeur2);
	}


	public String toString() {
		return "!=";
	}
	
}
