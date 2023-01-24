import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception
    {
//        FindHighestPrime.find();
        FileWriter fw = new FileWriter("src\\Results.csv");
        BufferedWriter bw = new BufferedWriter(fw);

        final int size = 100;
        int[] results = new int[2];

        for(int i = 0; i < size; i++)
        {
            results = FindHighestPrime.find();
            bw.write(results[0] + ", " + results[1] + "\n");
            System.out.println(i);
        }
        bw.flush();
        bw.close();
    }
}

//TODO find largest prime the program can handle