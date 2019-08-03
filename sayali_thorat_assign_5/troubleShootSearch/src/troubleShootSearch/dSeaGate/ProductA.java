/**
 * 
 */
package troubleShootSearch.dSeaGate;

import java.util.List;

/**
 * @author sayali
 *
 */
public class ProductA implements ProductAccept{

	private List<String> ProductList;

	/**
	 * 
	 */
	public ProductA(List<String> ProductList) {
		this.ProductList = ProductList;
	}

	@Override
	public void accept(Visitor V) {
		// TODO Auto-generated method stub
		
		V.visit(this);
		
	}
	
	public String getBar() {
	
		return "Bar";
	}

}
