package edu.kis.vh.nursery;

/**
 * Klasa {@code DefaultCountingOutRhymer} implementuje prostą strukturę danych typu stos (LIFO – Last In, First Out)
 * o stałym rozmiarze. Umożliwia dodawanie elementów (countIn) oraz ich zdejmowanie (countOut).
 * Wewnętrznie wykorzystuje tablicę liczb całkowitych o rozmiarze {@value #SIZE}.
 * Wartości specjalne:
 *{@value #STACK_EMPTY} – oznacza pusty stos</li>
 *{@value #STACK_ELEMENTS} – maksymalny indeks elementu na stosie</li>
 */
public class DefaultCountingOutRhymer {
    /** Maksymalny rozmiar stosu */
    private static final int SIZE = 12;
    /** Wartość oznaczająca pusty stos */
    private static final int STACK_EMPTY = -1;
    /** Maksymalny indeks elementu na stosie */
    private static final int STACK_ELEMENTS = SIZE - 1;
    /** Tablica przechowująca elementy stosu */
    private final int[] numbers = new int[SIZE];
    /** Aktualna liczba elementów (indeks szczytu stosu) */
    private int total = STACK_EMPTY;

    /**
     * Zwraca maksymalny rozmiar stosu.
     * @return rozmiar stosu
     */
    public static int getSize() {
        return SIZE;
    }

    /**
     * Zwraca wartość oznaczającą pusty stos.
     *
     * @return wartość pustego stosu
     */
    public static int getStackEmpty() {
        return STACK_EMPTY;
    }
    /**
     * Zwraca aktualny indeks szczytu stosu (liczbę elementów - 1).
     *
     * @return indeks szczytu stosu lub {@link #STACK_EMPTY}, jeśli pusty
     */
    public int getTotal() {
        return total;
    }
    /**
     * Dodaje element na szczyt stosu, jeśli stos nie jest pełny.
     *
     * @param in wartość do dodania
     */
    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
            // TODO: brak obsługi przypadku przepełnienia – metoda ignoruje błąd zamiast np. rzucić wyjątek
    }
    /**
     * Sprawdza, czy stos jest pusty.
     *
     * @return {@code true}, jeśli stos jest pusty; {@code false} w przeciwnym przypadku
     */
    protected boolean callCheck() {
        return total == STACK_EMPTY;
        // TODO: nazwa metody nieczytelna – lepsza byłaby np. isEmpty()
    }
    /**
     * Sprawdza, czy stos jest pełny.
     *
     * @return {@code true}, jeśli stos jest pełny; {@code false} w przeciwnym przypadku
     */
    protected boolean isFull() {
        return total == STACK_ELEMENTS;
    }
    /**
     * Zwraca element znajdujący się na szczycie stosu bez jego usuwania.
     *
     * @return wartość na szczycie stosu lub {@link #STACK_EMPTY}, jeśli stos jest pusty
     */
    protected int peekaboo() {
        if (callCheck())
            return STACK_EMPTY;
        return numbers[total];
        // TODO: zwracanie wartości specjalnej zamiast wyjątku może ukrywać błędy i nazwa jest nie nieczytelna
    }
    /**
     * Usuwa i zwraca element ze szczytu stosu.
     *
     * @return wartość usuniętego elementu lub {@link #STACK_EMPTY}, jeśli stos jest pusty
     */
    public int countOut() {
        if (callCheck())
            return STACK_EMPTY;
        return numbers[total--];
        // TODO: brak wyjątku przy pustym stosie – może prowadzić do trudnych do wykrycia błędów
    }

}
