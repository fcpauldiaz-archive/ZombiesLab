/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Oct 15, 2016
**/

package zombieslab;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SDX
 */
public class Cruzador implements Runnable {

    private Puente pnt;
    private int numThread;
    public Cruzador(Puente pnt, int numThread) {
        this.pnt = pnt;
        this.pnt.direccionActual = 0;
        this.numThread = numThread;
    }

    
    @Override
    public void run() {
      
        Random random = new Random();
        //wait betweem 0 and 3
        int time = random.nextInt(4);
        try {
            Thread.sleep(time * 1000);
        } 
        catch (InterruptedException exception) {

            System.out.println("Ha ocurrido un eror " + exception );
        }
        int direccion = random.nextInt(2);
        synchronized(pnt) {
            pnt.accederPuente(direccion,  numThread);
        }
        synchronized(pnt) {
            pnt.salirPuente();
        }          
            
        
    }

    
    
}
