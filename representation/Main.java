package representation;
import solvers.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BooleanVariable a = new BooleanVariable("a");
		BooleanVariable b = new BooleanVariable("b");
		BooleanVariable c = new BooleanVariable("c");
		BinaryExtensionConstraint bec = new BinaryExtensionConstraint(a, b);
		Map<Variable, Object> map = new HashMap<Variable, Object>();
		map.put(a, true);
		map.put(b, true);
		bec.addTuple(true, true);
		System.out.println(bec.isSatisfiedBy(map));
		//Implication implique = new Implication(a, true, b, false);
		// DifferenceConstraint diff = new DifferenceConstraint(a,a);
		// DifferenceConstraint diff2 = new DifferenceConstraint(a,c);
		// // DifferenceConstraint diff3 = new DifferenceConstraint(b,c);
		// Set<Variable> variables = new HashSet<Variable>();
		// variables.add(a);
		// variables.add(b);
		// variables.add(c);
		// Set<Constraint> contraintes = new HashSet<Constraint>();
		// contraintes.add(diff);
		// contraintes.add(diff2);
		// ArcConsistency ac = new ArcConsistency(contraintes);
		// Map<Variable, Set<Object>> map = new HashMap<Variable, Set<Object>>();
		// map.put(a, a.getDomain());
		// map.put(b, b.getDomain());
		// // System.out.println(ac.enforceNodeConsistency(map));
		// BacktrackSolver bt = new BacktrackSolver(variables, contraintes);
		// System.out.println(bt.solve().toString());
		
	}
/* X = {a,b,c}
	D = {0,1}
	C = {diff(a,a), diff(a,c)}

	a -> {} -> a=0, diff(a,a) ? non / a=1 diff(a,a) ? non
	b
*/
}
