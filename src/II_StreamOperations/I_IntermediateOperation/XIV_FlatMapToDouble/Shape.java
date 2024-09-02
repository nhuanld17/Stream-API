package II_StreamOperations.I_IntermediateOperation.XIV_FlatMapToDouble;

import java.util.List;

public class Shape {
	private String type;
	private List<Double> areas;
	
	public Shape(String type, List<Double> areas) {
		this.areas = areas;
		this.type = type;
	}
	
	public List<Double> getAreas() {
		return areas;
	}
	
	public void setAreas(List<Double> areas) {
		this.areas = areas;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
