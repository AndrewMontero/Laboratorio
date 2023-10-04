
package cajas;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Cajas {

    
    public static void main(String[] args) {
        Random random = new Random();
        List<Caja> cajas = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            cajas.add(new Caja());
        }
        
        List<Cliente> fila = new ArrayList<>();
        
        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Generar nuevo cliente");
            System.out.println("2. Asignar clientes a cajas");
            System.out.println("3. Simular tiempo de atención");
            System.out.println("4. Mostrar estadísticas");
            System.out.println("5. Salir");
            
            int opcion = Integer.parseInt(System.console().readLine());
            
            if (opcion == 1) {
                String numeroAtencion = generarNumeroAtencion(random);
                char prioridad = numeroAtencion.charAt(numeroAtencion.length() - 1);
                Cliente cliente = new Cliente(numeroAtencion, prioridad);
                fila.add(cliente);
                System.out.println("Nuevo cliente: " + numeroAtencion);
            } else if (opcion == 2) {
                asignarClientesACajas(cajas, fila);
            } else if (opcion == 3) {
                simularTiempoAtencion(cajas);
            } else if (opcion == 4) {
                mostrarEstadisticas(cajas);
            } else if (opcion == 5) {
                break;
            }
        }
    }
     private static String generarNumeroAtencion(Random random) {
        int numero = random.nextInt(100) + 1;
        char prioridad;
        if (numero <= 10) {
            prioridad = 'A';  // Adulto mayor
        } else if (numero <= 30) {
            prioridad = 'B';  // Mujer embarazada o con niño
        } else if (numero <= 60) {
            prioridad = 'C';  // Dos o más asuntos
        } else {
            prioridad = 'D';  // Otros casos
        }
        return numero + String.valueOf(prioridad);
    }

    // Función para asignar clientes a las cajas disponibles
    private static void asignarClientesACajas(List<Caja> cajas, List<Cliente> fila) {
        for (Caja caja : cajas) {
            if (!fila.isEmpty()) {
                Cliente cliente = fila.remove(0);
                caja.agregarCliente(cliente);
            }
        }
    }

    // Función para simular el tiempo de atención aleatorio
    private static void simularTiempoAtencion(List<Caja> cajas) {
        for (Caja caja : cajas) {
            for (Cliente cliente : caja.getClientesAtendidos()) {
                int tiempoAtencion = (int) (Math.random() * 24) + 2; // Entre 2 y 25 minutos
                cliente.setTiempoAtencion(tiempoAtencion);
                caja.getTiempoTotal();
            }
        }
    }

    // Función para mostrar las estadísticas
    private static void mostrarEstadisticas(List<Caja> cajas) {
        System.out.println("Estadísticas:");
        for (int i = 0; i < cajas.size(); i++) {
            Caja caja = cajas.get(i);
            System.out.println("Caja " + (i + 1) + ":");
            System.out.println("Cantidad de clientes atendidos: " + caja.getClientesAtendidos().size());
            double promedioTiempo = calcularPromedioTiempo(caja);
            System.out.println("Promedio de tiempo de espera: " + promedioTiempo + " minutos");
            System.out.println();
        }
    }

    // Función para calcular el promedio de tiempo de espera en una caja
    private static double calcularPromedioTiempo(Caja caja) {
        List<Cliente> clientesAtendidos = caja.getClientesAtendidos();
        if (clientesAtendidos.isEmpty()) {
            return 0;
        }
        int tiempoTotal = 0;
        for (Cliente cliente : clientesAtendidos) {
            tiempoTotal += cliente.getTiempoAtencion();
        }
        return (double) tiempoTotal / clientesAtendidos.size();
    }
}
