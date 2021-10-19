package planning;
import representation.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BooleanVariable a = new BooleanVariable("a");
		BooleanVariable b = new BooleanVariable("b");
		BooleanVariable c = new BooleanVariable("c");
		Map<Variable, Object> precond = new HashMap<Variable, Object>();
		precond.put(a, true);
		precond.put(b, true);

		Map<Variable, Object> etat = new HashMap<Variable, Object>();
		etat.put(a,true);
		etat.put(b,true);	

		//BasicAction ba = new BasicAction(precond, precond, 0);
		//System.out.println(ba.isApplicable(etat));

		BasicGoal bg = new BasicGoal(precond);
		// System.out.println(bg.isSatisfiedBy(etat));


    }
	
}

