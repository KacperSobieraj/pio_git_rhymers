package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int SIZE = 12;
    public static final int STACK_EMPTY = -1;
    public static final int ELE = 11;
    private final int[] numbers = new int[SIZE];

    public int total = STACK_EMPTY;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == STACK_EMPTY;
    }

    public boolean isFull() {
        return total == ELE;
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
