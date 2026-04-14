import java.io.*;
import java.util.*;

public class RARP
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String file = "data.csv";   // CSV file

        System.out.println("Enter the MAC Address:");
        String macInput = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            boolean found = false;

            System.out.println("\nMAC Address | IP Address");

            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(",");

                if (macInput.equals(data[1]))
                {
                    System.out.println(data[1] + " | " + data[0]);
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.println("MAC Address not found.");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}