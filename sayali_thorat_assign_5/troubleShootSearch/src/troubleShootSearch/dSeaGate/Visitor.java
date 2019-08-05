/**
 * 
 */
package troubleShootSearch.dSeaGate;


/**
 * @author sayali
 *
 */
public interface Visitor {

	void visit(ExactMatch EM);
	void visit(NaiveStemmingMatch NM);
	void visit(SemanticMatch SM);
}
