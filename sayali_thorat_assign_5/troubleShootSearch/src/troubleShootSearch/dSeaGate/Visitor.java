/**
 * 
 */
package troubleShootSearch.dSeaGate;


/**
 * @author sayali
 *This interface is used for declaration  
 */
public interface Visitor {

	void visit(ExactMatch EM);
	void visit(NaiveStemmingMatch NM);
	void visit(SemanticMatch SM);
}
