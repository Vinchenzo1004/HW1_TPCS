package MainMenu;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server
{
    private static final int NUM_THREADS = 5;
    private static final int PORT = 8000;

    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(8000);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        while(true)
        {
            Socket socket = serverSocket.accept();
            executor.submit(new FactorTask(socket));
        }
    }

    private static class FactorTask implements Runnable
    {
        private final Socket socket;

        public FactorTask(Socket socket)
        {
            this.socket = socket;
        }

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