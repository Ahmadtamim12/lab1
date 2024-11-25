package se.hig.aod.lab1;

public interface SearchableDataStructure<T extends Comparable<T>> {
    void addElement(T element);
    boolean containsElement(T element);
    void removeElement(T element);
    int size();
    boolean isEmpty();
}
