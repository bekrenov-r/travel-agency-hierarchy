package com.solvd.laba;

import com.solvd.laba.travelagency.util.CustomLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTests {

    private static final Collection<String> LIST_CONTENT = Arrays.asList("1", "2", "3", "4", "2");

    private CustomLinkedList<String> list;

    @BeforeEach
    void setup(){
        list = new CustomLinkedList<>(LIST_CONTENT);
    }

    @Test
    void testIsEmpty(){
        CustomLinkedList<String> emptyList = new CustomLinkedList<>();
        assertFalse(list.isEmpty());
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void testSize(){
        CustomLinkedList<String> emptyList = new CustomLinkedList<>();
        assertEquals(5, list.size());
        assertEquals(0, emptyList.size());
    }

    @Test
    void testContains(){
        LIST_CONTENT.forEach(s -> assertTrue(list.contains(s)));
        assertFalse(list.contains("not in list"));
    }

    @Test
    void testContainsAll(){
        assertTrue(list.containsAll(Arrays.asList("3", "2", "4")));
        assertTrue(list.containsAll(LIST_CONTENT));
        assertFalse(list.containsAll(Arrays.asList("not in list", "asd")));
    }

    @Test
    void testAdd(){
        list.add("new element");
        assertIterableEquals(Arrays.asList("1", "2", "3", "4", "2", "new element"), list);
    }

    @Test
    void testAddWithIndex(){
        list.add(2, "new element");
        assertIterableEquals(Arrays.asList("1", "2", "new element", "3", "4", "2"), list);
    }

    @Test
    void testAddWithIndex_throwsIndexOutOfBoundsException(){
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "new element"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(list.size() + 1, "new element"));
    }

    @Test
    void testAddAll(){
        boolean result = list.addAll(Arrays.asList("new1", "new2"));
        assertIterableEquals(Arrays.asList("1", "2", "3", "4", "2", "new1", "new2"), list);
        assertTrue(result);
    }

    @Test
    void testAddAll_emptyCollection(){
        boolean result = list.addAll(List.of());
        assertIterableEquals(LIST_CONTENT, list);
        assertFalse(result);
    }

    @Test
    void testAddAllWithIndex(){
        list.addAll(2, Arrays.asList("new1", "new2"));
        assertIterableEquals(Arrays.asList("1", "2", "new1", "new2", "3", "4", "2"), list);
    }

    @Test
    void testAddAllWithIndex_throwsIndexOutOfBoundsException(){
        assertThrows(IndexOutOfBoundsException.class, () -> list.addAll(-1, Arrays.asList("new1", "new2")));
        assertThrows(IndexOutOfBoundsException.class, () -> list.addAll(list.size() + 1, Arrays.asList("new1", "new2")));
    }

    @Test
    void testGet(){
        assertEquals("3", list.get(2));
    }

    @Test
    void testGet_throwsIndexOutOfBoundsException(){
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
    }

    @Test
    void testGet_returnsNullIfListIsEmpty(){
        assertNull(new CustomLinkedList<>().get(0));
    }

    @Test
    void testSet(){
        list.set(2, "new value");
        assertEquals("new value", list.get(2));
    }

    @Test
    void testRemove(){
        boolean result = list.remove("2");

        assertIterableEquals(Arrays.asList("1", "3", "4", "2"), list);
        assertTrue(result);
    }

    @Test
    void testRemove_elementNotInList(){
        boolean result = list.remove("not in list");

        assertIterableEquals(LIST_CONTENT, list);
        assertFalse(result);
    }

    @Test
    void testRemoveWithIndex(){
        String expected = list.get(2);
        String removed = list.remove(2);

        assertIterableEquals(Arrays.asList("1", "2", "4", "2"), list);
        assertEquals(expected, removed);
    }

    @Test
    void testRemoveWithIndex_throwsIndexOutOfBoundsException(){
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size()));
    }

    @Test
    void testRemoveAll(){
        boolean result = list.removeAll(Arrays.asList("1", "3", "2"));

        assertIterableEquals(Arrays.asList("4", "2"), list);
        assertTrue(result);
    }

    @Test
    void testRemoveAll_emptyCollection(){
        boolean result = list.removeAll(new ArrayList<String>());

        assertIterableEquals(LIST_CONTENT, list);
        assertFalse(result);
    }

    @Test
    void testIndexOf(){
        assertEquals(1, list.indexOf("2"));
    }

    @Test
    void testIndexOf_elementNotInList(){
        assertEquals(-1, list.indexOf("not in list"));
    }

    @Test
    void testLastIndexOf(){
        assertEquals(4, list.lastIndexOf("2"));
    }

    @Test
    void testLastIndexOf_elementNotInList(){
        assertEquals(-1, list.lastIndexOf("not in list"));
    }

    @Test
    void testToArray(){
        Object[] expected = LIST_CONTENT.toArray();
        Object[] actual = list.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void testToArrayWithArgument(){
        String[] expected = LIST_CONTENT.toArray(new String[0]);
        String[] actual = list.toArray(new String[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testRetainAll(){
        boolean result = list.retainAll(Arrays.asList("2", "3", "4", "2"));
        assertIterableEquals(Arrays.asList("2", "3", "4", "2"), list);
        assertTrue(result);
    }

    @Test
    void testRetainAll_emptyCollection(){
        boolean result = list.retainAll(new ArrayList<String>());
        assertIterableEquals(List.of(), list);
        assertTrue(result);
    }

    @Test
    void testRetainAll_equalCollection(){
        boolean result = list.retainAll(LIST_CONTENT);
        assertIterableEquals(LIST_CONTENT, list);
        assertFalse(result);
    }

    @Test
    void testClear(){
        list.clear();
        assertEquals(0, list.size());
        assertIterableEquals(new ArrayList<String>(), list);
    }

    @Test
    void testSubList(){
        List<String> subList = list.subList(1, 4);
        assertIterableEquals(Arrays.asList("2", "3", "4"), subList);
    }
}
