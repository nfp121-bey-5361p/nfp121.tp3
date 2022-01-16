package question2;

import question1.PilePleineException;
import question1.PileVideException;
import java.util.Arrays;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        // traiter le cas <=0
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        // a completer
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        // a completer
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        // a completer
        if (estVide())
            throw new PileVideException();
        return this.zone[this.ptr-1];
    }

    public int capacite() {
        // a completer
        return zone.length;
    }

    public int taille() {
        // a completer
        return ptr;
    }

    public boolean estVide() {
        // a completer
        return ptr == 0;
    }

    public boolean estPleine() {
        // a completer
        return ptr == zone.length;
    }
    
    /*
    public boolean equals(Object o) {
        // a completer
        if ((o != null) && (o.getClass().equals(this.getClass()))) {
            Pile autrePile = (Pile)o;
            return autrePile.taille() == this.taille()
                    && autrePile.capacite() == this.capacite()
                    && Arrays.equals(autrePile.zone, this.zone);
        }
        
        return false;
    }
    */
    
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

    public String toString() {
        // a completer
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}