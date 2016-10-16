/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Oct 15, 2016
**/

package zombieslab;

/**
 *
 * @author SDX
 */
public class Runner {
    private Puente ptn;   

    public Runner() {
        this.ptn = new Puente();
        run();
    }
    
    private void run() {
        for (int i = 0; i< 10; i++ ){
            Thread currentThread = new Thread(new Cruzador(ptn, i));
            currentThread.start();
        }
    }

}
