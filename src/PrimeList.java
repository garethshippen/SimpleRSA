import java.io.*;
import java.util.ArrayList;

public class PrimeList
{
    private ArrayList<Integer> primes = new ArrayList<>();
    private int arraySize = 0;

    public PrimeList()
    {
        File file = new File("src\\primenumbers.csv");
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null)
            {
                primes.add(Integer.parseInt(line));
            }
            arraySize = primes.size();
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO exception");
            e.printStackTrace();
        }
    }

    public int getPrime()
    {
        int index = (int) (Math.random() * arraySize);
        return primes.get(index);
    }
}
