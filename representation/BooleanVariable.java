package representation;

import java.util.HashSet;
import java.util.Set;

public class BooleanVariable extends Variable{
	
	private final static Set<Object> domaine = new HashSet<Object>();
	static { //Pour proteger/eviter de modifier les valeurs de l'objet domaine
		domaine.add(true);
		domaine.add(false);
	}
	public BooleanVariable(String nom) {
		super(nom, domaine);
	}

}
