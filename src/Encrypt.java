public class Encrypt
{
    private int e;
    private long n;

    public Encrypt(int _e, long _n)
    {
        e = _e;
        n = _n;
    }


    public String encrypt(String _input)
    {
        char[] charArray = _input.toCharArray();
        StringBuilder output = new StringBuilder("(e: " + e + ", n: " + n + ")\n");
        for(char c : charArray)
        {
            output.append(encryptor(c) + " ");
        }
        return output.toString();
    }

    //TODO implement with BigInt
    private long encryptor(int _m)
    {
        System.out.println(_m);
        long m = (long)Math.pow(_m, e);;
        System.out.println(m);
        m = (m%n);
        System.out.println(m);
        return m;
    }
}
