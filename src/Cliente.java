import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        String Host = "localhost";
        int Puerto = 6000;//puerto remoto
        // ABRIR SOCKET
        Socket Cliente = null;//conecta
        try {
            Cliente = new Socket(Host, Puerto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InetAddress i = Cliente.getInetAddress();
        System.out.println("Puerto local: "+Cliente.getLocalPort());//devuelve el puerto local
        System.out.println("Puerto Remoto: "+Cliente.getPort());//devuelve el puerto remoto
        System.out.println("Host Remoto: "+i.getHostName().toString());//devuelve el nombre del host, que en este caso es 'localhost'
        System.out.println("IP Host Remoto: "+i.getHostAddress().toString());
        try {
            Cliente.close();// Cierra el socket
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
