package MainMenu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A distributed solver for factorization that connects to a remote server.
 * It sends integers to the server and receives their factors in response.
 * 
 * @author Vincent Vaccaro
 * @version 4/3/2025
 */
public class DistributedSolver implements Solver 
{
    private final String host;
    private final int port;

    /**
     * Default constructor connecting to localhost:8000
     * 
     * @param host the hostname of the server
     * @param port the port number of the server
     */
    public DistributedSolver() 
    {
        this("localhost", 8000);
    }

    /**
     * Constructor that allows specifying the host and port of the server.
     * 
     * @param host the hostname of the server
     * @param port the port number of the server
     */
    public DistributedSolver(String host, int port) 
    {
        this.host = host;
        this.port = port;
    }

    /**
     * Factor every number from 2 up to MAX (e.g. 100_000),
     * and return a FactorizationResult that holds the full map.
     * 
     * @param max the maximum number to factor
     * @return a FactorizationResult containing the factors of each number
     */
    @Override
    public FactorizationResult solve(int max) 
    {
        FactorizationResult result = new FactorizationResult();
        for(int n = 2; n <= max; n++) 
        {
            result.put(n, requestFactors(n));
        }
        return result;
    }

    /**
     * Request factors for a given integer from the remote server.
     * 
     * @param n the integer to factor
     * @return a list of factors for the integer
     */
    private List<Integer> requestFactors(int n) 
    {
        try(Socket socket = new Socket(host, port);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())) 
        {
            out.writeInt(n);
            out.flush();

            int count = in.readInt();
            List<Integer> factors = new ArrayList<>();
            for(int i = 0; i < count; i++) 
            {
                factors.add(in.readInt());
            }
            return factors;
        } 
        catch(IOException ex) 
        {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    /**
     * Print any solver-specific intro text (default: nothing)
     * 
     * @return void
     */
    @Override
    public void welcomeMsg() 
    {
        System.out.println("Welcome to the Distributed Factorizer!");
    }
}