import java.io.*;
import java.net.*;

public class Client
{
    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket("localhost", 3500);

            BufferedReader serverInput = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter clientOutput = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            String message;

            do
            {
                System.out.print("Client: ");
                message = keyboard.readLine();

                clientOutput.println(message);

                String response = serverInput.readLine();
                System.out.println("Server message: " + response);

            } while (!message.equalsIgnoreCase("bye"));

            socket.close();
        }
        catch (IOException e)
        {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}