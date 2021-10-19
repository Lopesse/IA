package planning;
import representation.*;
import java.util.*;

public interface Action{

    public boolean isApplicable(Map<Variable,Object> param);
    public Map<Variable,Object> successor(Map<Variable,Object> etat) throws IllegalArgumentException;
    public default int getCost(){return 1;}
}
