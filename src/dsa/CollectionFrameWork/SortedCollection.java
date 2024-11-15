package dsa.CollectionFrameWork;

import java.util.*;
/**
 * <p>Comparable vs Comparator </p>
 *
 * 1) Comparable provides a single sorting sequence. In other words, we can sort the collection on the basis of a single element such as id, name, and price.	The Comparator provides multiple sorting sequences. In other words, we can sort the collection on the basis of multiple elements such as id, name, and price etc.
 * 2) Comparable affects the original class, i.e., the actual class is modified.	Comparator doesn't affect the original class, i.e., the actual class is not modified.
 * 3) Comparable provides compareTo() method to sort elements.	Comparator provides compare() method to sort elements.
 * 4) Comparable is present in java.lang package.	A Comparator is present in the java.util package.
 * 5) We can sort the list elements of Comparable type by Collections.sort(List) method.	We can sort the list elements of Comparator type by Collections.sort(List, Comparator) method.
 *
 */

class Book implements Comparable<Book> {
    /**
     * custom Class
     */
    String title;
    Integer price;
    public Book(String title, int price) {
        this.price = price;
        this.title = title;
    }

    @Override
    public int compareTo(Book o) {
        return 0;
    }
}
/**
 * compare by Title
 */
class compareByTitle implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.title.compareTo(b2.title);
    }
}
/**
 * compare by Price
 */
class compareByPrice implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.price.compareTo(b2.price);
    }
}

public class SortedCollection {
    /**
     *comparator for sort the treeMap by Value...
     */
    public static <K, V extends Comparable<V> > Map<K, V>
    valueSort(final Map<K, V> map) {
        Comparator<K> valueComparator = Comparator.comparing(map::get);
        Map<K, V> sorted = new TreeMap<>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }

    public static void main(String[] args) {
        TreeSet<Book> treeSet = new TreeSet<>(new compareByTitle());
        treeSet.add(new Book("A", 500));
        treeSet.add(new Book("B", 600));
        treeSet.add(new Book("D", 400));
        treeSet.add(new Book("C", 800));
        for (Book book : treeSet) { System.out.println(book.title + "  " + book.price); }

        PriorityQueue<Book> queue = new PriorityQueue<>(new compareByPrice());
        queue.add(new Book("A", 500));
        queue.add(new Book("B", 600));
        queue.add(new Book("D", 400));
        queue.add(new Book("C", 800));
        for (Book book : queue) System.out.println(book.title + "  " + book.price);

        TreeMap<Book, String> treeMap = new TreeMap<>(new compareByTitle());
        treeMap.put(new Book("A", 500), "Map");
        treeMap.put(new Book("B", 600), "List");
        treeMap.put(new Book("D", 400), "Collection");
        treeMap.put(new Book("C", 800), "Set");
        for (Map.Entry<Book, String> entry : treeMap.entrySet())
            System.out.println(entry.getKey().title + " " + entry.getKey().price + " " + entry.getValue());
        for (Map.Entry<Book, String> entry : valueSort(treeMap).entrySet())
            System.out.println(entry.getKey().title + " " + entry.getKey().price + " " + entry.getValue());
    }
}
