import java.math.BigInteger;

public class Encrypt
{
    private int e;
    private long n;
    private BigInteger maxLong = BigInteger.valueOf(Long.MAX_VALUE);

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
            try {
                output.append(encryptor(c) + "\n");
            } catch (Exception ex) {
                System.out.println("Overflow");
                ex.printStackTrace();
            }
        }
        return output.toString();
    }


    private long encryptor(int _m) throws Exception {
        BigInteger message = BigInteger.valueOf(_m);
        BigInteger exponent = BigInteger.valueOf(e);
        BigInteger modulus = BigInteger.valueOf(n);
        BigInteger cypher= message.modPow(exponent, modulus);

        if((cypher.compareTo(maxLong) > 0))
        {
            throw new Exception("Overflow");
        }

        return cypher.longValueExact();
    }
}
