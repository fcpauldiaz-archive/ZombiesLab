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
    
    public void accederPuente(int direccion, int numThread) {
        if (puente.isEmpty()) {
            direccionActual = direccion;
        }
        //no pueden haber más de 4 personas en el puente
        while (puente.size() >= 4) {
             try {
                System.out.println("Threads in puente" + this.puente);
                wait(); 
                break;
            } catch (InterruptedException exception) {
                System.out.println("Error puente" + exception);
            }
        }
        if (direccionActual == direccion) {
            this.puente.add(direccion);
            if (direccion == 0) {
                System.out.println("Cruzando " + numThread +" en dirección derecha");
                
            }
            else {
                System.out.println("Cruzando " + numThread + " en dirección izquierda");
            }
        }
        //tiene que esperar si no está en la misma dirección
        else {
            try {
                //System.out.println(this.puente);
                wait();
                ZombiesLab.log += "Threads in puente = " + this.puente + "\n";
            } catch (InterruptedException exception) {
                System.out.println("Error puente" + exception);
            }
        }
        
    }
    
    public void salirPuente() {
       
        
        if (!this.puente.isEmpty()){
            System.out.println("Sale  puente");
            this.puente.remove(this.puente.get(0));
            notifyAll();
        }
        
        
    }

}
