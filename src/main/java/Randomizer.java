public class Randomizer {
    private long a, c, m, last;


    public Randomizer(long a, long c, long m) {
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public Randomizer start(long seed) {
        this.last = seed;
        return this;
    }

    public long next() {
        this.last = 1 * (a * last + c) % m;

        return this.last;
    }
}
