package solvers;
import java.util.Map;
import representation.*;

public interface Solver {
	public Map<Variable, Object> solve();

}
