/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Oct 15, 2016
**/

package zombieslab;

import java.util.Scanner;

/**
 *
 * @author SDX
 */
public class Runner {
    private Puente ptn;   
    Scanner sc = new Scanner(System.in);
    public Runner() {
        this.ptn = new Puente();
        run();
    }
    
    private void run() {
    System.out.print("Ingrese la cantidad de personas ");
    int personas = sc.nextInt();
        for (int i = 0; i< personas; i++ ){
            Thread currentThread = new Thread(new Cruzador(ptn, i));
            currentThread.start();
            try {
                currentThread.join();
            }
            catch(Exception e){}
            
        }
    }

}
