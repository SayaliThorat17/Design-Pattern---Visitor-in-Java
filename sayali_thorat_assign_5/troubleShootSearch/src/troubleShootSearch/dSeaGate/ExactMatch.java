/**
 * 
 */
package troubleShootSearch.dSeaGate;

/**
 * @author sayali
 *
 */
public class ExactMatch implements Product{
	
	public void accept(Visitor V) {
			
		V.visit(this);
	}

}
