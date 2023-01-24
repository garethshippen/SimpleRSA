import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        // ÿ = 11111111 in ascii
        Keys keys;
        keys = new Keys();
        System.out.println(keys.toString());

        for(int i = 0; i < 1000; i++)
        {
            keys = new Keys();
//            double ratio = keys.getE() / keys.getN();
            System.out.printf("%d\t%d\n", keys.getN(), keys.getE());
        }
//        Encrypt encrypt = new Encrypt(keys.getE(), keys.getN());
//        Decrypt decrypt = new Decrypt(keys.getD(), keys.getN());
//
//        String plain = "ÿÿÿÿÿÿ";
//
//        ArrayList<Long> cypher = encrypt.encrypt(plain);
//        //System.out.println(cypher.get(0));
//        String message = decrypt.decrypt(cypher);
//        System.out.println(message);
    }
}

//TODO e always seems to be much smaller than n. getPrime(n) bug?
//TODO find largest prime the program can handle