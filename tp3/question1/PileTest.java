package question1;

public class PileTest extends junit.framework.TestCase {
    private Pile p1;
    private Pile p2;

    public void setUp() {
        p1 = new question1.Pile();
        p2 = new question1.Pile();
    }

    public void test_Pile_estPleine() throws Exception {
        Pile p = new question1.Pile(3);
        p.empiler(3);
        p.empiler(2);
        p.empiler(1);

        assertEquals(true, p.estPleine());
        
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }

    public void test_Pile_estVide() throws Exception {
        Pile p = new question1.Pile(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }

    public void test_Pile_toString() throws Exception {
        Pile pile1 = new question1.Pile(3);
        assertEquals("toString incorrect ? ", "[]", pile1.toString());
        pile1.empiler(4);
        assertEquals("toString incorrect ? ", "[4]", pile1.toString());
        pile1.empiler(5);
        assertEquals("toString incorrect ? ", "[5, 4]", pile1.toString());
        pile1.empiler(3);
        assertEquals("toString incorrect ? ", "[3, 5, 4]", pile1.toString());
    }

}
