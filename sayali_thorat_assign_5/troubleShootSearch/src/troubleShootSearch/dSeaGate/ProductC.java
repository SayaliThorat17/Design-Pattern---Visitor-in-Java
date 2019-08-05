/**
 * 
 */
package troubleShootSearch.dSeaGate;

/**
 * @author sayali
 *
 */
public class ProductC implements ProductAccept{

	@Override
	public void accept(Visitor V) {
		// TODO Auto-generated method stub
		V.visit(this);
		
	}
}
