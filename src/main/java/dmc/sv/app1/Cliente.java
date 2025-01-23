package dmc.sv.app1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Cliente implements ServerData{
    public static void main(String[] args) throws Exception {
        final String HOST = "localhost";
        try (Socket cliente = new Socket( HOST, ServerData.PORT )) {
            enviar(cliente);
            recibir(cliente);
        } catch (Exception e) { }
    }

    private static void enviar(Socket cliente) throws IOException{

    }

    private static void recibir(Socket cliente) throws IOException{

    }
}