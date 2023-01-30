public class Keys
{
    private final int p;
    private int q;
    private final long n;
    private final long z;
    private long e;
    private final long d;

    Keys()
    {
        PrimeList pl = new PrimeList();
        p = pl.getPrime();
        do
        {
            {
                q = pl.getPrime();
            }
        }while (p == q); //p and q cannot be equal
        n = (long) p * q;
        z = (long) (p - 1) * (q - 1);
        e = pl.getPrime(n);
        d = getD(e, z);
    }

    Keys(int _p, int _q) throws Exception {
        PrimeList pl = new PrimeList();
        p = _p;
        q = _q;

        if(p == q)
        {
            throw new Exception("p and q cannot be equal");
        }

        n = (long) p * q;
        z = (long) (p - 1) * (q - 1);
        e = pl.getPrime(n);
        d = getD(e, z);
    }

    Keys(int _p, int _q, int _e) throws Exception {
        this(_p, _q);
        e = _e;
    }

    //extended euclidian algorithm
    public long getD(long _e, long _z)
    {
        long e = _e;
        long z = _z;
        long t1 = 0;
        long t2 = 1;
        long quot;
        long mod;
        long q;

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
//        System.out.println(_z);
//        System.out.println(t1);
        return ((t1 > 0) ? t1 : (_z + t1));
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

    public long getE() {
        return e;
    }

    public long getD() {
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
}
