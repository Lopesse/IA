public class MACSolver extends AbstractSolver {
    private Set<Variable> ensembleVar;
    private Set<Constraint> ensembleContraintes;
    public MACSolver(Set<Variable> ensembleVar, Set<Constraint> ensembleContraintes) {
        this.ensembleVar = ensembleVar;
        this.ensembleContraintes = ensembleContraintes;
    }

    public Map<Variable, Object> solve(){
        Map<Variable, Set<Object>> varsEtDomaines = new HashMap<>();
        return mac(new HashMap<Variable, Object>(), )
    }

    public Map<Variable, Object> mac(Map<Variable, Object> instantiationPartielle, Map<Variable, Set<Object>> varsEtDomaines){

    }
}