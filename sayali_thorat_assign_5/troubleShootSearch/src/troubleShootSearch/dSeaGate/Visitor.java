/**
 * 
 */
package troubleShootSearch.dSeaGate;

/**
 * @author sayali
 *
 */
public interface Visitor {
	
	public void visit(ExactMatch EM);
	public void visit(NaiveMatch NM);
	public void visit(SemanticMatch SM);

}
