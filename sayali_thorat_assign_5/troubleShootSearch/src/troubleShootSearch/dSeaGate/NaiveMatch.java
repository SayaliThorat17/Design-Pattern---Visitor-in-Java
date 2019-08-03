/**
 * 
 */
package troubleShootSearch.dSeaGate;

/**
 * @author sayali
 *
 */
public class NaiveMatch implements Product{
	
	public void accept(Visitor V) {
		
		V.visit(this);
	}

}
