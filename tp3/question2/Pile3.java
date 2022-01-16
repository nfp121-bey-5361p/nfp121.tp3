package question2;

import question1.PilePleineException;
import question1.PileVideException;
import java.util.Iterator;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        // à compléter
        v = new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        // à compléter
        if (estPleine())
            throw new PilePleineException();
        v.add(o);
    }

    public Object depiler() throws PileVideException {
        // à compléter
        if (estVide())
            throw new PileVideException();
        return v.remove(taille()-1);
    }

    public Object sommet() throws PileVideException {
        // à compléter
        if (estVide())
            throw new PileVideException();
        return v.lastElement();
    }

    public int taille() {
        // à compléter
        return v.size();
    }

    public int capacite() {
        // à compléter
        return v.capacity();
    }

    public boolean estVide() {
        // à compléter
        return v.size() == 0;
    }

    public boolean estPleine() {
        // à compléter
        return v.size() == v.capacity();
    }

    public String toString() {
        // à compléter
        String s = "]";
        Iterator<Object> it = v.iterator();
        while (it.hasNext()) {
            s = it.next().toString() + s; 
            if (it.hasNext()) {
                s = ", " + s;
            }
        }
        return "[" + s;
    }

    /*public boolean equals(Object o) {
        // à compléter
        if ((o != null) && (o.getClass().equals(this.getClass()))) {
            Pile3 autrePile = (Pile3)o;
            return autrePile.taille() == this.taille()
                    && autrePile.capacite() == this.capacite()
                    && autrePile.v.equals(this.v);
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

}
