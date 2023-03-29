import java.io.*;
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
        Socket cliente = null;
        try{
            cliente = servidor.accept(); //esperando a un cliente
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Creando stream de salida:
        OutputStream salida=null;
        try {
            salida = cliente.getOutputStream();
        }catch (IOException el) {
            el.printStackTrace() ;
        }
        DataOutputStream flujoSalida = new DataOutputStream(salida);
        //Creando stream de entrada:
        InputStream entrada=null;
        try {
            entrada = cliente.getInputStream() ;
        }catch (IOException e) {
            e.printStackTrace();
        }
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        try {
            servidor.close(); //cerrando el socket servidor
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
