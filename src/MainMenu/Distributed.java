package MainMenu;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Distributed
{
    public static class FactorizerTask implements Callable<List<Integer>>
    {
        private final int number;

        public FactorizerTask(int number)
        {
            this.number = number;
        }

        @Override
        public List<Integer> call() throws IOException, ClassNotFoundException
        {
            Socket socket = new Socket("localhost", 8000);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeInt(number);

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            List<Integer> factors = (List<Integer>) ois.readObject();

            socket.close();
            return factors;
        }
    }
}
