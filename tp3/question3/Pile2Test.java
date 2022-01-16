package question3;

/**
 * The test class Pile2Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Pile2Test extends junit.framework.TestCase {

    
    private PileI<Integer> p1;
    private PileI<Integer> p2;

    /**
     * Default constructor for test class Pile2Test
     */
    public Pile2Test()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    public void setUp()
    {
        p1 = new question3.Pile2<Integer>();
        p2 = new question3.Pile2<Integer>();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    public void tearDown()
    {
    }
    
    public void test_Pile_estPleine() throws Exception {
        PileI<Integer> p = new question3.Pile2<Integer>(3);
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }
    
    public void test_Pile_sommet() throws Exception {
        PileI<Integer> p = new question3.Pile2<Integer>(3);
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        assertEquals(new Integer(3), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }
    
    public void test_Pile_estVide() throws Exception {
        PileI<Integer> p = new question3.Pile2<Integer>(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }
    
    public void test_Pile_toString() throws Exception {
        PileI<Integer> pile1 = new question3.Pile2<Integer>(3);
        assertEquals("toString incorrect ? ", "[]", pile1.toString());
        pile1.empiler(4);
        assertEquals("toString incorrect ? ", "[4]", pile1.toString());
        pile1.empiler(5);
        assertEquals("toString incorrect ? ", "[5, 4]", pile1.toString());
        pile1.empiler(3);
        assertEquals("toString incorrect ? ", "[3, 5, 4]", pile1.toString());

    }
    
    public void test_Pile_TailleNegative() {
        PileI<Integer> p = new question3.Pile2<Integer>(-3);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());

    }
    
    
    public void test_Pile_equals() throws Exception {

        p1.empiler(3);
        p1.empiler(2);
        p1.empiler(1);

        p2.empiler(3);
        p2.empiler(2);
        p2.empiler(1);

        assertTrue(p1.equals(p2));
        assertTrue(p2.equals(p1));
        assertTrue(p1.equals(p1));

        p2.empiler(1);
        assertFalse(p1.equals(p2));

    }
}
