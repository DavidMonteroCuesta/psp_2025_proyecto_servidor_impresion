package dmc.sv.app1;

import java.net.ServerSocket;
import java.net.Socket;

import dmc.sv.app1.impresion.Impresora;

public class Servidor implements ServerData{
    public static void main(String[] args) throws Exception {
        Impresora impresora = new Impresora();

        try (ServerSocket server = new ServerSocket(ServerData.PORT)) {
            System.out.println("Servidor escuchando en " + ServerData.PORT );
            while (true){
                Socket cliente = server.accept();
                
            }
        } catch (Exception e) { }
    }
}
