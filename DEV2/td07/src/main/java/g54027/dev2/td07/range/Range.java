package g54027.dev2.td07.range;

import java.util.Arrays;
import java.util.Iterator;

public class Range implements Iterable<Integer>, Comparable {

    /*
    public static void main(String[] args) {
        // EXERCICE 2
        int[] tab = {3, 1, 5, 10, 0};

        for (int index : new Range(0, tab.length)) {
            System.out.println(tab[index]);
        }

        // EXERCICE 3
        Range[] r = {new Range(10, 20), new Range(1, 3), new Range(1, 5)};
        Arrays.sort(r);

        for (Range r1 : r) {
            for (int index : r1) {
                System.out.println(index);
            }
        }
    }
    */

    final int lowerBound;
    final int upperBound;

    public Range(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.lowerBound;
        hash = 97 * hash + this.upperBound;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Range other = (Range) obj;
        if (this.lowerBound != other.lowerBound) {
            return false;
        }
        return this.upperBound == other.upperBound;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(lowerBound, upperBound);
    }

    @Override
    public int compareTo(Object o) {
        int result = 0;
        if (o instanceof Range) {
            result = this.getLowerBound() - ((Range) o).getLowerBound();
            if (result == 0) {
                result = this.getUpperBound() - ((Range) o).getUpperBound();
            }
        }
        return result;
    }

    class RangeIterator implements Iterator<Integer> {

        private int current;
        private final int upperBound;

        public RangeIterator(int lowerBound, int upperBound) {
            current = lowerBound;
            this.upperBound = upperBound;
        }

        @Override
        public boolean hasNext() {
            return current < upperBound;
        }

        @Override
        public Integer next() {
            return current++;
        }
    }
}
