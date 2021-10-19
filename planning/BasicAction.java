package planning;
import java.util.*;
import representation.*;

public class BasicAction implements Action{
    protected Map<Variable,Object> precond, effet;
    protected int cout;

    public BasicAction(Map<Variable,Object> precond, Map<Variable,Object> effet, int cout){
        this.precond = precond;
        this.effet = effet;
        this.cout = cout;
    }

    public boolean isApplicable(Map<Variable,Object> etat){
        /*
        for(Variable v: this.precond.keySet()){
            if(!etat.containsKey(v)){
                return false;
            }
            else {
                if(!(this.precond.get(v)==etat.get(v))){
                    return false;
                }
            }
        }
        return true;*/
        return etat.entrySet().containsAll(this.precond.entrySet());
    }

    public Map<Variable,Object> successor(Map<Variable,Object> etat){
        if(etat.isEmpty()) {
            return this.effet;
        }
        
        if(this.isApplicable(etat)) {
            etat.putAll(this.effet);
        } else {
            throw new IllegalArgumentException("non applicable");
        }
        
        return etat;
    }
    
    public int getCost(){
        return this.cout;
    }

    public String toString(){
        return "precond: " + this.precond + "\n" + "effet: " + this.effet + "\n" + "cout: " + this.cout;
    }

}