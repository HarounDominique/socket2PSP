import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws IOException {
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
        Scanner scan = new Scanner(System.in);
        String mensaje = scan.nextLine();//almacenamos en una variable mensaje aquello que queremos enviar a cliente
        try {
            flujoSalida.writeUTF(mensaje);//enviamos el mensaje a través del DOS
            flujoSalida.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Creando stream de entrada:
        InputStream entrada=null;
        try {
            entrada = cliente.getInputStream() ;
        }catch (IOException e) {
            e.printStackTrace();
        }
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        //leemos el DIS flujoEntrada mientras tenga un contenido que mostrar
        while (flujoEntrada.available() > 0) {
            System.out.println(flujoEntrada.readUTF());
        }
        flujoEntrada.close(); //cerramos el DIS
        try {
            servidor.close(); //cerrando el socket servidor
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
