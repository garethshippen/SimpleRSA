public class Keys
{
    private final int p;
    private final int q;
    private final long n;
    private final long z;
    private final int e;
    private final int d;

    public Keys()
    {
        PrimeList pl = new PrimeList();
        p = pl.getPrime();
        q = pl.getPrime();
        n = (long) p * q;
        z = (long) (p - 1) * (q-1);

        int temp;
        do {
            temp = pl.getPrime();
        } while (temp > n);
        e = temp;
        d = getD(e, z);
    }
    public int getD(int _e, long _z)
    {
        int e = _e;
        long z = _z;
        int d = 0;
        int t1 = 0;
        int t2 = 1;
        long quot;
        long mod;
        int q;

        while(e != 0)
        {
            quot = z/e;
            mod = z%e;
            q = (int) (t1 - (t2 * quot));
            z = e;
            e = (int) mod;
            t1 = t2;
            t2 = q;
        }

        return (int) ((t1 > 0) ? t1 : (_z + t1));
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }

    public long getN() {
        return n;
    }

    public long getZ() {
        return z;
    }

    public int getE() {
        return e;
    }

    public int getD() {
        return d;
    }

    @Override
    public String toString() {
        return "Keys{" +
                "p=" + p +
                ", q=" + q +
                ", n=" + n +
                ", z=" + z +
                ", e=" + e +
                ", d=" + d +
                '}';
    }

    //FOR DEBUGGING

    public Keys(int _p, int _q, int _e)
    {
        p = _p;
        q = _q;
        n = (long) p * q;
        z = (long) (p - 1) * (q-1);
        e = _e;
        d = getD(e, z);
    }

    public Keys(int _e)
    {
        PrimeList pl = new PrimeList();
        p = pl.getPrime();
        q = pl.getPrime();
        n = (long) p * q;
        z = (long) (p - 1) * (q-1);
        e = _e;
        d = getD(e, z);
    }

}
