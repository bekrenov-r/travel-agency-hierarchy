package com.solvd.laba.travelagency.util;

import java.lang.reflect.Array;
import java.util.*;

public class CustomLinkedList<E> implements List<E> {
    private Node first;
    private Node last;
    private int size;

    public CustomLinkedList() {
    }

    public CustomLinkedList(Collection<E> collection) {
        this.addAll(collection);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(Node node = first; node.next != null; node = node.next){
            if(Objects.equals(node.value, o)) return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for(Object item : collection){
            if(!contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean add(E e) {
        if(isEmpty()){
            first = new Node(e, null, null);
        } else {
            for(Node n = first; n != null; n = n.next){
                if(n.index() == size - 1){
                    n.next = last = new Node(e, n, null);
                    break;
                }
            }
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        if((isEmpty() && index == 0) || index == size) {
            add(element);
            return;
        }
        Node prev = getNode(index - 1);
        Node next = getNode(index);
        Node newNode = new Node(element, prev, next);
        prev.next = newNode;
        next.previous = newNode;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        if(collection.isEmpty()) return false;
        for(E e : collection){
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        if(collection.isEmpty()) return false;
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        for(E element : collection){
            this.add(index, element);
            index++;
        }
        return true;
    }

    @Override
    public E get(int index) {
        if(isEmpty()) return null;
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        for(Node node = first; node != null; node = node.next){
            if(node.index() == index) return node.value;
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        Node node = getNode(index);
        node.value = element;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index == -1) return false;
        Node node = getNode(index);
        detach(node);
        size--;
        return true;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node node = getNode(index);
        detach(node);
        size--;
        return node.value;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if(collection.isEmpty()) return false;
        boolean wasChanged = false;
        for(Object obj : collection){
            boolean res = this.remove(obj);
            wasChanged = wasChanged || res;
        }
        return wasChanged;
    }

    @Override
    public int indexOf(Object o) {
        if(isEmpty()) return -1;
        for(Node node = first; node != null; node = node.next){
            if(Objects.equals(node.value, o)){
                return node.index();
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if(isEmpty()) return -1;
        for(Node node = last; node != null; node = node.previous){
            if(Objects.equals(node.value, o)){
                return node.index();
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListItr();
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];
        int i = 0;
        for(Node node = first; node != null; node = node.next){
            objects[i++] = node.value;
        }
        return objects;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if(a.length != size) {
            a = (T[])Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        for(Node node = first; node != null; node = node.next){
            if(i != a.length){
                a[i++] = (T) node.value;
            } else break;
        }
        return a;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean wasChanged = false;
        for(Node node = first; node != null; node = node.next){
            E value = node.value;
            if(!collection.contains(value)){
                this.remove(value);
                wasChanged = true;
            }
        }
        return wasChanged;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListItr();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        return new ListItr(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if(fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
            throw new IndexOutOfBoundsException();
        List<E> result = new CustomLinkedList<>();
        for(Node node = getNode(fromIndex); node.index() < toIndex; node = node.next){
            result.add(node.value);
        }
        return result;
    }

    private Node getNode(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        for(Node n = first; n != null; n = n.next){
            if(n.index() == index) return n;
        }
        throw new RuntimeException("An error occurred");
    }

    private void detach(Node node) {
        if(node.previous != null) {
            node.previous.next = node.next;
        }
        if(node.next != null) {
            if(node == first){
                first = node.next;
            }
            node.next.previous = node.previous;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(Node node = first; node != null; node = node.next){
            sb.append(node.value.toString()).append(node.isLast() ? "]" : ", ");
        }
        return sb.toString();
    }

    private class ListItr implements ListIterator<E> {
        Node next;
        Node lastReturned;
        int nextIndex;

        ListItr() {
            if(CustomLinkedList.this.size != 0){
                next = getNode(0);
            }
        }

        ListItr(int index) {
            nextIndex = index;
            next = getNode(index);
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            if(hasNext()) {
                lastReturned = next;
                E value = next.value;
                next = next.next;
                nextIndex++;
                return value;
            } else throw new NoSuchElementException("There is no next element in iterator");
        }

        @Override
        public boolean hasPrevious() {
            return next.index() > 0;
        }

        @Override
        public E previous() {
            if(hasPrevious()) {
                lastReturned = next.previous;
                next = next.previous;
                return next.value;
            } else throw new NoSuchElementException("There is no previous element in iterator");
        }

        @Override
        public int nextIndex() {
            if(!hasNext()) return size();
            return next.index();
        }

        @Override
        public int previousIndex() {
            if(!hasPrevious()) return -1;
            return next.previous.index();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }

    private class Node {
        E value;
        Node previous;
        Node next;

        public Node(E value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        int index(){
            return this == first ? 0 : previous.index() + 1;
        }

        boolean isLast() {
            return this.index() == CustomLinkedList.this.size - 1;
        }
    }
}
