package MainMenu;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A simple server that listens for incoming connections and calculates the factors of a number.
 * It uses a thread pool to handle multiple requests concurrently.
 * 
 * @author Vincent Vaccaro
 * @version 4/3/2025
 */
public class Server
{
    private static final int NUM_THREADS = 5;
    private static final int PORT = 8000;

    /**
     * Main method to start the server and listen for incoming connections.
     * 
     * @param args command line arguments
     * @throws IOException if an error occurs while starting the server
     */
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(PORT);
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        while(true)
        {
            Socket socket = serverSocket.accept();
            executor.submit(new FactorTask(socket));
        }
    }

    /**
     * A task that handles the factorization of a number received from a client.
     */
    private static class FactorTask implements Runnable
    {
        private final Socket socket;

        /**
         * Constructor that initializes the socket for the task.
         * 
         * @param socket the socket to handle
         */
        public FactorTask(Socket socket)
        {
            this.socket = socket;
        }

        /**
         * The run method that performs the factorization and sends the result back to the client.
         */
        @Override
        public void run()
        {
            try
            {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                int number = ois.readInt();

                List<Integer> factors = new ArrayList<>();
                for(int i = 1; i <= number; i++)
                {
                    if(number % i == 0)
                    {
                        factors.add(i);
                    }
                }

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(factors);

                socket.close();
            }
            catch(Exception e)
            {
                System.err.println("Error calculating factors: " + e.getMessage());
            }
        }
    }
}