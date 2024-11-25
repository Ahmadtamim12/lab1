package se.hig.aod.lab1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree<>();
        bst.addElement(15);
        bst.addElement(10);
        bst.addElement(20);
        bst.addElement(8);
        bst.addElement(12);
        bst.addElement(18);
        bst.addElement(25);
    }

    @Test
    public void testAddElement() {
        assertTrue(bst.containsElement(10));
        assertTrue(bst.containsElement(15));
        assertTrue(bst.containsElement(20));
        assertFalse(bst.containsElement(17));
    }

    @Test
    public void testContainsElement() {
        assertTrue(bst.containsElement(8));
        assertTrue(bst.containsElement(25));
        assertFalse(bst.containsElement(100));
    }

    @Test
    public void testRemoveElement() {
        assertTrue(bst.containsElement(10));
        bst.removeElement(10);
        assertFalse(bst.containsElement(10));
        assertNotNull(bst);
        assertEquals(6, bst.size());
    }

    @Test
    public void testSizeAndIsEmpty() {
        assertEquals(7, bst.size());
        assertFalse(bst.isEmpty());

        bst.removeElement(15);
        bst.removeElement(10);
        bst.removeElement(20);
        bst.removeElement(8);
        bst.removeElement(12);
        bst.removeElement(18);
        bst.removeElement(25);

        assertEquals(0, bst.size());
        assertTrue(bst.isEmpty());
    }
}

