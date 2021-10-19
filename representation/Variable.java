package representation;

import java.util.Set;

public class Variable {
	String nom;
	Set<Object> domaine;
	
	public Variable(String nom, Set<Object> domaine) {
		this.nom = nom;
		this.domaine = domaine;
	}
	
	@Override
	public boolean equals(Object obj) {
		Variable other = (Variable) obj;
		if (domaine == null) {
			if (other.domaine != null)
				return false;
		} else if (!domaine.equals(other.domaine))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
	
	public String getName() {
		return this.nom;
	}
	
	public Set<Object> getDomain(){
		return this.domaine;
	}
	
	public String toString() {
		return this.nom; 
	}
}
