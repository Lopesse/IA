package examples;

import java.util.Set;

import representation.*;

public class HouseExample {
    int largeur, longueur;
    Set<String> piecesEau, pieces;
    public HouseExample(int largeur, int longueur, Set<String> piecesEau, Set<String> pieces){
        this.largeur = largeur;
        this.longueur = longueur;
        this.piecesEau = piecesEau;
        this.pieces = pieces;
    }

    public Set<Variable> getVariables(){
        return null;
    }

    public Set<Constraint> getConstraints(){
        return null;
    }
}
