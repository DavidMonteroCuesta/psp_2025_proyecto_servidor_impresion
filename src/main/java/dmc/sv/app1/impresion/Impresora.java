package dmc.sv.app1.impresion;

public class Impresora{
    private int folios = 100;

    public synchronized void imprimir(int restar){
        this.folios  = this.folios - restar;
    }

    public synchronized int getFolios() {
        return folios;
    }
}
