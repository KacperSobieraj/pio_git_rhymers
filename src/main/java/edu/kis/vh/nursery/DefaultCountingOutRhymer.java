package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int SIZE = 12;
    private static final int STACK_EMPTY = -1;
    private static final int STACK_ELEMENTS = SIZE - 1;
    private final int[] numbers = new int[SIZE];

    private int total = STACK_EMPTY;
    
    public static int getSize() {
        return SIZE;
    }

    public static int getStackEmpty() {
        return STACK_EMPTY;
    }

    public int getTotal() {
        return total;
    }

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    protected boolean callCheck() {
        return total == STACK_EMPTY;
    }

    protected boolean isFull() {
        return total == STACK_ELEMENTS;
    }

    protected int peekaboo() {
        if (callCheck())
            return STACK_EMPTY;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return STACK_EMPTY;
        return numbers[total--];
    }

}
