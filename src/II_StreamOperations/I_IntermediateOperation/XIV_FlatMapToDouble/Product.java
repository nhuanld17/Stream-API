package II_StreamOperations.I_IntermediateOperation.XIV_FlatMapToDouble;

import java.util.List;

public class Product {
	private String name;
	private List<Double> prices;
	
	public Product(String name, List<Double> prices) {
		this.name = name;
		this.prices = prices;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Double> getPrices() {
		return prices;
	}
	
	public void setPrices(List<Double> prices) {
		this.prices = prices;
	}
}
