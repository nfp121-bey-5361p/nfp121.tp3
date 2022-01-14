package question2;

import question1.PilePleineException;
import question1.PileVideException;
import java.util.Iterator;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }
        
        
        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            m.suivant = suivant;
            return m;
        }
        
        public Iterator<Object> iterator() {
            return new Iterator<Object>() {
                Maillon m = Maillon.this;
                
                public boolean hasNext() {
                    return m != null;
                }
                
                public Object next() {
                    Object obj = m.element;
                    m = m.suivant;
                    return obj;
                }
            };
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        // à compléter
        if (this.stk == null) { // accounts for first element
            stk = new Maillon(o, null);
        } else {
            Maillon maillon = new Maillon(o, stk);
            stk = maillon;
        }
        this.nombre++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        // à compléter
        Object obj = stk.element();
        stk = stk.suivant();
        this.nombre--;
        return obj;
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.element(); // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return this.nombre == 0; // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return this.nombre == this.capacite; // à compléter
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {

        String s = "[";
        if (stk != null) {
            Iterator<Object> it = stk.iterator();
            while (it.hasNext()) {
                s += it.next().toString(); 
                if (it.hasNext()) {
                    s += ", ";
                }
            }
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        if (o != null && o instanceof Pile4) {
            Pile4 autrePile = (Pile4)o; 
            return autrePile.taille() == this.taille()
                    && autrePile.capacite() == this.capacite()
                    && autrePile.toString().equals(this.toString());
        }
        return false;
    }

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}