import java.io.*;
import java.net.*;

public class HttpClient
{
    public static void main(String[] args)
    {
        String path = "http://www.google.com";
        BufferedReader reader = null;

        try
        {
            URI uri = new URI(path);
            URL url = uri.toURL();

            reader = new BufferedReader(
                        new InputStreamReader(url.openStream())
                     );

            String line;

            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch (Exception e)
        {
            System.out.println("An exception occurred");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (reader != null)
                    reader.close();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
    }
}