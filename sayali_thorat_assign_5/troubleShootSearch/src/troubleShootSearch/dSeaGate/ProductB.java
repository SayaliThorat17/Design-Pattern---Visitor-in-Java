/**
 * 
 */
package troubleShootSearch.dSeaGate;

/**
 * @author sayali
 *
 */
public class ProductB implements ProductAccept{

	@Override
	public void accept(Visitor V) {
		// TODO Auto-generated method stub
		V.visit(this);
		
	}
}
