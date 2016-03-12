import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer implements Runnable {
    private final ServerSocket serverSocket;

    public GameServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        try {
            Socket player1Socket = serverSocket.accept();
            Socket player2Socket = serverSocket.accept();

            DataInputStream dis1 = new DataInputStream(player1Socket.getInputStream());
            DataOutputStream dos1 = new DataOutputStream(player1Socket.getOutputStream());

            DataInputStream dis2 = new DataInputStream(player2Socket.getInputStream());
            DataOutputStream dos2 = new DataOutputStream(player2Socket.getOutputStream());

            while (true) {
                if (dis1.available() > 0) {
                    // player 1 did something
                }
                if (dis2.available() > 0) {
                    // player 2 did something
                }
                Thread.sleep(10);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
