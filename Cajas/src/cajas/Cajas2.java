
package cajas;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Caja {
    private List<Cliente> clientesAtendidos;
    private int tiempoTotal;

    public Caja() {
        this.clientesAtendidos = new ArrayList<>();
        this.tiempoTotal = 0;
    }

    public List<Cliente> getClientesAtendidos() {
        return clientesAtendidos;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void agregarCliente(Cliente cliente) {
        clientesAtendidos.add(cliente);
    }
}