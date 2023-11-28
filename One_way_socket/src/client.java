
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class client {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 5000);
        System.out.println("Client connected at server handshaking port: " + s.getPort());
        System.out.println("Client's communication port: " + s.getLocalPort());
        System.out.println("Client is connected\n");
        System.out.println("Enter the message that you want to send and send \"stop\" to close the connection: ");

        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        while (!str.equals("stop")) {
            str = read.readLine();
            output.writeUTF(str);
        }
        output.close();
        read.close();
        s.close();

    }
}
