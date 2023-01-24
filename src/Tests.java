import java.util.ArrayList;
import java.util.Collections;

public class Tests
{
    // ÿ = 11111111 in ascii
    static final String testChar = "ÿ";
    public static int[] find() throws Exception {
        boolean run = true;
        int[] results = new int[2];
        ArrayList<Integer> primes = new PrimeList().getPrimes();
        primes.sort(Collections.reverseOrder());

        int size = primes.size();
        Keys keys;
        for(int i = 0; i < size - 2 && run; i++)
        {
            if(i%10 == 0)
            {
                System.out.println(i);
            }
            keys = new Keys(primes.get(i), primes.get(i + 1));
            Encrypt encrypt = new Encrypt(keys.getE(), keys.getN());
            Decrypt decrypt = new Decrypt(keys.getD(), keys.getN());

            ArrayList<Long> cypher = encrypt.encrypt(testChar);
            String message = decrypt.decrypt(cypher);
            if(testChar.equals(message))
            {
                results[0] = primes.get(i);
                results[1] = i;
                run = false;
            }
        }
        return results;
    }

    public static boolean testKeys(int _p, int _q) throws Exception {
        boolean theSame = false;
        Keys keys;
        keys = new Keys(_p, _q);
        Encrypt encrypt = new Encrypt(keys.getE(), keys.getN());
        Decrypt decrypt = new Decrypt(keys.getD(), keys.getN());

        ArrayList<Long> cypher = encrypt.encrypt(testChar);
        String message = decrypt.decrypt(cypher);
        if(testChar.equals(message))
        {
            theSame = true;
        }
        return theSame;
    }
}
