/**
 * 
 */
package troubleShootSearch.dSeaGate;

/**
 * @author sayali
 *
 */
public class ProductA implements ProductAccept{

	@Override
	public void accept(Visitor V) {
		// TODO Auto-generated method stub
		V.visit(this);
		
	}

}
