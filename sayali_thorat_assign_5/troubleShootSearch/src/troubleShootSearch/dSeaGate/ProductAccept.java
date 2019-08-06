/**
 * 
 */
package troubleShootSearch.dSeaGate;

/**
 * @author sayali
 *This is an interface which declares the accept operation.
 * This is the entry point which enables an object to be “visited” 
 * by the visitor object.
 */
public interface ProductAccept {

	void accept(Visitor V);
}
