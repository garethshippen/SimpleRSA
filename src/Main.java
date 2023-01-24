import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        Keys keys;
        keys = new Keys();
        System.out.println(keys.toString());

        Encrypt encrypt = new Encrypt(keys.getE(), keys.getN());
        Decrypt decrypt = new Decrypt(keys.getD(), keys.getN());

        String plain = "Hello world";

        ArrayList<Long> cypher = encrypt.encrypt(plain);
        System.out.println(cypher.get(0));
        String message = decrypt.decrypt(cypher);
        System.out.println(message);
    }
}