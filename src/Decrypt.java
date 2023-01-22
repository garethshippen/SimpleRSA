import java.math.BigInteger;
import java.util.ArrayList;

public class Decrypt
{
    private long d;
    private long n;

    Decrypt(long _d, long _n)
    {
        d = _d;
        n = _n;
    }

    public String decrypt(ArrayList<Long> _cypher)
    {
        StringBuilder plaintext = new StringBuilder("(d: " + d + ", n: " + n + ")\n");
        for(Long l : _cypher)
        {
            plaintext.append(decryptor(l));
        }
        return plaintext.toString();
    }

    private char decryptor(long _input)
    {
        BigInteger exponent = BigInteger.valueOf(d);
        BigInteger cypher = BigInteger.valueOf(_input);
        BigInteger modulus = BigInteger.valueOf(n);
        BigInteger message = cypher.modPow(exponent, modulus);

        return (char)message.intValue();
    }
}
