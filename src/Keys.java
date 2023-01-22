public class Keys
{
    private int p = 0;
    private int q = 0;
    private long n = 0;
    private long z = 0;
    private int e = 0;
    private int d = 0;

    public Keys()
    {
        PrimeList pl = new PrimeList();
        p = pl.getPrime();
        q = pl.getPrime();
        n = (long) p * q;
        z = (long) (p - 1) * (q-1);

        do {
            e = pl.getPrime();
        } while (e > n);
        d = getD(e, z);
    }

    //FOR DEBUGGING
    /*
    public Keys(int _p, int _q, int _e)
    {
        p = _p;
        q = _q;
        n = (long) p * q;
        z = (long) (p - 1) * (q-1);
        e = _e;
        d = getD(e, z);
    }
    */

    public int getD(int _e, long _z)
    {
        int e = _e;
        long z = _z;
        int d = 0;
        int t1 = 0;
        int t2 = 1;
        long quot = 0;
        long mod = 0;
        int q = 0;

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
