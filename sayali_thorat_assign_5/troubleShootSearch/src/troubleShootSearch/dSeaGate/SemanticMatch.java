/**
 * 
 */
package troubleShootSearch.dSeaGate;

/**
 * @author sayali
 *
 */
public class SemanticMatch implements Product {
	
	public void accept(Visitor V) {
		
		V.visit(this);
	}

}
