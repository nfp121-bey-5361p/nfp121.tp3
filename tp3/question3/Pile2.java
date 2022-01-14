package question3;

import question1.PilePleineException;
import question1.PileVideException;
import java.util.Iterator;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        // à compléter
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        // a completer
        this.capacite = taille;
        stk = new Stack<T>();
    }

    public Pile2(){
        // à compléter
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        // à compléter
        if (estPleine()) 
            throw new PilePleineException();
        stk.push(o);
    }

    public T depiler() throws PileVideException{
        // à compléter
        if (estVide())
            throw new PileVideException();
        return stk.pop();
    }

    public T sommet() throws PileVideException{
        // à compléter
        if (estVide())
            throw new PileVideException();
        return stk.peek();
    }

    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile
    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // a completer
        return stk.size() == 0;
    }
    
    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        // a completer
        return stk.size() == capacite;
    }
    
    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "]";
        Iterator<T> it = stk.iterator();
        while (it.hasNext()) {
            s = it.next().toString() + s; 
            if (it.hasNext()) {
                s = ", " + s;
            }
        }
        return "[" + s;
    }
    
    
    public boolean equals(Object o) {
        // a completer
        if ((o != null) && (o.getClass().equals(this.getClass()))) {
            Pile2 autrePile = (Pile2)o;
            return autrePile.taille() == this.taille()
                    && autrePile.capacite() == this.capacite()
                    && autrePile.hashCode() == this.hashCode();
        }
        
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        // a completer
        return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        // a completer
        return capacite;
    }
} // Pile2