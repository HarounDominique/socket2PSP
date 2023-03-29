import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 6000; //el puerto al que enlazamos el socket servidor (el puerto local en este caso)
        ServerSocket servidor = null;
        try{
            servidor = new ServerSocket(puerto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("En escucha en el puerto "+servidor.getLocalPort());
        try{
            Socket cliente = servidor.accept(); //esperando a un cliente
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            servidor.close(); //cerrando el socket servidor
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
