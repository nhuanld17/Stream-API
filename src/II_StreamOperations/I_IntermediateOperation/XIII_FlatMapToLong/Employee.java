package II_StreamOperations.I_IntermediateOperation.XIII_FlatMapToLong;

import java.awt.*;
import java.util.List;

public class Employee {
	private String name;
	private List<Long> hoursWorkedPerShift;
	
	public Employee(String name, List<Long> hoursWorkedPerShift) {
		this.hoursWorkedPerShift = hoursWorkedPerShift;
		this.name = name;
	}
	
	public List<Long> getHoursWorkedPerShift() {
		return hoursWorkedPerShift;
	}
	
	public void setHoursWorkedPerShift(List<Long> hoursWorkedPerShift) {
		this.hoursWorkedPerShift = hoursWorkedPerShift;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
