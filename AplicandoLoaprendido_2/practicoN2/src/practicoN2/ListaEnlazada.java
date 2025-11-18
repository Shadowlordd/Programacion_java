package practicoN2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListaEnlazada<E> implements Iterable<E> {
    public static class Nodo<E> {
        E dato;
        Nodo<E> siguiente;
        Nodo(E dato) { this.dato = dato; }
    }

    private Nodo<E> head;
    private int size = 0;

    public ListaEnlazada() {}

    public int size() { return size; }

    public boolean isEmpty() { return head == null; }

    public void add(E elemento) {
        Objects.requireNonNull(elemento, "Elemento no puede ser null");
        if (head == null) head = new Nodo<>(elemento);
        else {
            Nodo<E> cur = head;
            while (cur.siguiente != null) cur = cur.siguiente;
            cur.siguiente = new Nodo<>(elemento);
        }
        size++;
    }

    public void addAt(int index, E elemento) {
        Objects.requireNonNull(elemento, "Elemento no puede ser null");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            Nodo<E> n = new Nodo<>(elemento);
            n.siguiente = head;
            head = n;
        } else {
            Nodo<E> prev = nodo(index - 1);
            Nodo<E> n = new Nodo<>(elemento);
            n.siguiente = prev.siguiente;
            prev.siguiente = n;
        }
        size++;
    }

    public E get(int index) {
        return nodo(index).dato;
    }

    private Nodo<E> nodo(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Nodo<E> cur = head;
        for (int i = 0; i < index; i++) cur = cur.siguiente;
        return cur;
    }

    public boolean remove(E elemento) {
        if (head == null) return false;
        if (head.dato.equals(elemento)) {
            head = head.siguiente;
            size--;
            return true;
        }
        Nodo<E> cur = head;
        while (cur.siguiente != null && !cur.siguiente.dato.equals(elemento)) cur = cur.siguiente;
        if (cur.siguiente == null) return false;
        cur.siguiente = cur.siguiente.siguiente;
        size--;
        return true;
    }

    public Nodo<E> getHeadNode() { return head; }

    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        Nodo<E> cur = this.head;
        int i = 0;
        while (cur != null) {
            array[i++] = cur.dato;
            cur = cur.siguiente;
        }
        return array;
    }

    public static <T> ListaEnlazada<T> fromArray(T[] array) {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        if (array == null) return lista;
        for (T elem : array) {
            if (elem != null) lista.add(elem);
        }
        return lista;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Nodo<E> cur = head;
            @Override public boolean hasNext() { return cur != null; }
            @Override public E next() {
                if (cur == null) throw new NoSuchElementException();
                E d = cur.dato;
                cur = cur.siguiente;
                return d;
            }
        };
    }
}