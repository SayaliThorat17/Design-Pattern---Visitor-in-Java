/**
 * 
 */
package troubleShootSearch.dSeaGate;

/**
 * @author sayali
 *This class is used to implement accept interface.
 *The visitor object is passed to this object using the accept operation.
 */
public class ExactMatch implements ProductAccept{

	@Override
	public void accept(Visitor V) {
		// TODO Auto-generated method stub
		V.visit(this);
		
	}

}
