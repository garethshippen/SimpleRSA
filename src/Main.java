public class Main {
    public static void main(String[] args)
    {
        Keys keys = new Keys();
        Encrypt encrypt = new Encrypt(keys.getE(), keys.getN());

        String message = encrypt.encrypt("Hello, world!");
        System.out.println(message);
    }
}