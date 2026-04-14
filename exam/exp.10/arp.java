import java.io.*;
import java.util.*;

public class ARP
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String file = "data.csv";   // CSV file

        System.out.println("Enter the IP Address:");
        String ipInput = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            boolean found = false;

            System.out.println("\nIP Address | MAC Address");

            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(",");

                if (ipInput.equals(data[0]))
                {
                    System.out.println(data[0] + " | " + data[1]);
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.println("IP Address not found.");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}