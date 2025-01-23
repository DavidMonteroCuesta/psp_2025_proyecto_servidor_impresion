package dmc.sv.app1.impresion;

import java.net.Socket;

public class Funcion implements Runnable{

    private Socket cliente;
    private Impresora impresora;    

    public Funcion(Socket cliente, Impresora impresora) {
        this.cliente = cliente;
        this.impresora = impresora;
    }

    @Override
    public void run() {
        
    }

    public Socket getCliente() {
        return cliente;
    }
    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public Impresora getImpresora() {
        return impresora;
    }
    public void setImpresora(Impresora impresora) {
        this.impresora = impresora;
    }
}
