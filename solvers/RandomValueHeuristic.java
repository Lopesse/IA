package solvers;
import java.util.*;
import representation.*;

public class RandomValueHeuristic implements ValueHeuristic{
    private Random genAleatoire;
    public RandomValueHeuristic(Random genAleatoire){
        this.genAleatoire=genAleatoire;
    }

    @Override
    public List<Object> ordering(Variable variable, Set<Object>domaine){
        List<Object> domainValues = new ArrayList<>(domaine);
        return shuffle(domainValues,this.genAleatoire);
    }
}