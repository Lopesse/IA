package solvers;
import java.util.*; 
import representation.*;

public interface ValueHeuristic{
    public List<Object> ordering(Variable variable, Set<Object>domaine);
}