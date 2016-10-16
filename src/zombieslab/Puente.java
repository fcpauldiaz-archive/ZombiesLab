package zombieslab;

import java.util.ArrayList;

/**
* Universidad Del Valle de Guatemala
* Pablo Díaz 13203
* Oct 13, 2016
**/

/**
 *
 * @author SDX
 */
public class Puente {
    
    private ArrayList puente;
    public int direccionActual = 0;
    
    public Puente() {
        this.puente = new ArrayList(4);
    }
    
    public void accederPuente(int direccion) {
        if (puente.isEmpty()) {
            direccionActual = direccion;
        }
        while (puente.size() >= 4) {
             try {
                wait();
                ZombiesLab.log += "Threads in puente = " + this.puente +"\n";
                break;
            } catch (InterruptedException exception) {
                System.out.println("Error puente" + exception);
            }
        }
        if (direccionActual == direccion) {
            this.puente.add(direccion);
        }
        else {
            try {
                System.out.println(this.puente);
                wait();
                System.out.println("Sale wain");
                ZombiesLab.log += "Threads in puente = " + this.puente + "\n";
            } catch (InterruptedException exception) {
                System.out.println("Error puente" + exception);
            }
        }
        
    }
    
    public void salirPuente() {
        if (this.puente.size() > 4) {
            System.out.println("Sale puto puente");
            this.puente.remove(this.puente.get(0));
            notifyAll();
        }
        
    }

}
