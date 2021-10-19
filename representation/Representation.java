/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package representation;
import solvers.*;
import java.util.*;
/**
 *
 * @author 21910617
 */
public class Representation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		BooleanVariable a = new BooleanVariable("a");
		BooleanVariable b = new BooleanVariable("b");
		BooleanVariable c = new BooleanVariable("c");
		BinaryExtensionConstraint bec = new BinaryExtensionConstraint(a, b);
		Map<Variable, Object> map = new HashMap<Variable, Object>();
		map.put(a, true);
		map.put(b, true);
		bec.addTuple(true, true);
		System.out.println(bec.isSatisfiedBy(map));
		// Implication implique = new Implication(a, true, b, false);
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

}
