package planning;
import representation.*;
import java.util.*;

public interface Goal{
    public boolean isSatisfiedBy(Map<Variable,Object> etat);
}