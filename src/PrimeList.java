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

    //When searching for an e, if n is small the size of the pool of potential e's is small.
    //Trial and error e selecting is too slow.
    public int getPrime(long _maxValue)
    {
        int maxIndex = searchList(_maxValue);
        int index = (int) (Math.random() * maxIndex);
        return primes.get(index);
    }
    public int searchList(long _target)
    {
        int arraySize = primes.size();
        int high = arraySize - 1;
        int low = 0;
        int pivot = (high - low) / 2;

        while(arraySize != 1)
        {
            if(primes.get(pivot) == _target)
            {
                return pivot;
            }
            else if(primes.get(pivot) < _target)
            {
                low = pivot;
                arraySize = high - low;
                pivot = arraySize / 2 + low;
            }
            else
            {
                high = pivot;
                arraySize = high - low;
                pivot = high - (arraySize / 2);
            }
        }
        return pivot;
    }
}
