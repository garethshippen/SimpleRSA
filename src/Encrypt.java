import java.math.BigInteger;
import java.util.ArrayList;

public class Encrypt
{
    private long e;
    private long n;
    private BigInteger maxLong = BigInteger.valueOf(Long.MAX_VALUE);

    Encrypt(long _e, long _n)
    {
        e = _e;
        n = _n;
    }

    //includes (e,n) at the top of the output
    public String encryptWithKeys(String _input)
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

    public ArrayList<Long> encrypt(String _input)
    {
        ArrayList<Long> cypher = new ArrayList<>();
        char[] message = _input.toCharArray();
        for(char c : message)
            cypher.add(encryptor((int)c));

        return cypher;
    }

    private long encryptor(int _m)
    {
        BigInteger message = BigInteger.valueOf(_m);
        BigInteger exponent = BigInteger.valueOf(e);
        BigInteger modulus = BigInteger.valueOf(n);
        BigInteger cypher = message.modPow(exponent, modulus);

        return cypher.longValueExact();
    }
}
