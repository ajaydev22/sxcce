import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String[] args)
    {
        ServerSocket server = null;
        Socket socket = null;

        try
        {
            server = new ServerSocket(3500);
            System.out.println("Server waiting for connection...");

            socket = server.accept();
            System.out.println("Client connected.");

            BufferedReader clientInput = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter serverOutput = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            String message;

            while (true)
            {
                message = clientInput.readLine();

                if (message == null || message.equalsIgnoreCase("bye"))
                {
                    System.out.println("Client ended");
                    break;
                }

                System.out.println("Client message: " + message);
                System.out.print("Server: ");

                String reply = keyboard.readLine();

                serverOutput.println(reply);

                if (reply.equalsIgnoreCase("bye"))
                {
                    System.out.println("Server ended the chat");
                    break;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Server error: " + e.getMessage());
        }
        finally
        {
            try
            {
                if (socket != null)
                    socket.close();

                if (server != null)
                    server.close();
            }
            catch (IOException e)
            {
                System.out.println("Error closing server: " + e.getMessage());
            }
        }
    }
}