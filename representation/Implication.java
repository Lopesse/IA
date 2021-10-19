package representation;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Implication implements Constraint{
	BooleanVariable i1, i2;
	boolean b1,b2;
	public Implication(BooleanVariable i1,boolean b1, BooleanVariable i2, boolean b2) {
		this.i1=i1;
		this.b1=b1;
		this.i2=i2;
		this.b2=b2;
	}

	@Override
	public Set<Variable> getScope() {
		Set<Variable> scope = new HashSet<Variable>();
		scope.add(this.i1);
		scope.add(this.i2);
	
		return scope;
	}

	@Override
	public boolean isSatisfiedBy(Map<Variable, Object> map) {
		boolean valeur1, valeur2;
		if((!map.containsKey(this.i1)) || (!map.containsKey(this.i2))){
			throw new IllegalArgumentException();
		}
		valeur1 = (boolean) map.get(this.i1);
		valeur2 = (boolean) map.get(this.i2);
		
		if (b1){
			if (b2){
				return (!valeur1 || valeur2);
			}else{
				return (!valeur1 || !valeur2);
			}
		}else{
			if (b2){
				return (valeur1 || valeur2);
			}else{
				return (valeur1 || !valeur2);
			}
		}
	}

	
	public String toString() {
		return "->";
	}
}