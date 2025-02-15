package question2;

import question1.PilePleineException;
import question1.PileVideException;
import java.util.Iterator;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        // prevoir le cas <=0
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        // a completer
        this.capacite = taille;
        stk = new Stack<Object>();
        stk.ensureCapacity(taille);
        
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
        if (estPleine()) 
            throw new PilePleineException();
        stk.push(o);
    }

    public Object depiler() throws PileVideException {
        // a completer
        if (estVide())
            throw new PileVideException();
        return stk.pop();
    }

    public Object sommet() throws PileVideException {
        // a completer
        if (estVide())
            throw new PileVideException();
        return stk.peek();
    }

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
        Iterator<Object> it = stk.iterator();
        while (it.hasNext()) {
            s = it.next().toString() + s; 
            if (it.hasNext()) {
                s = ", " + s;
            }
        }
        return "[" + s;
    }

    /*public boolean equals(Object o) {
        // a completer
        if ((o != null) && (o.getClass().equals(this.getClass()))) {
            Pile2 autrePile = (Pile2)o;
            return autrePile.taille() == this.taille()
                    && autrePile.capacite() == this.capacite()
                    && autrePile.stk.equals(this.stk);
        }
        
        return false;
    }*/
    
    // implementation de equals de la question 2.5
    public boolean equals(Object o) {
        // a completer
        if (o == this)
            return true;
        if ((o != null) && (o instanceof PileI)) {
            PileI autrePile = (PileI)o;
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

} // Pile2.java
