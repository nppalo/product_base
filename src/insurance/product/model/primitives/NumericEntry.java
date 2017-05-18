package insurance.product.model.primitives;

import java.math.BigDecimal;

public class NumericEntry {
	String label;
	BigDecimal number;

	public NumericEntry(String label, BigDecimal number) {
		this.label = label;
		this.number = number;
	}

	public String getLabel() {
		return label;
	}

	public BigDecimal getNumber() {
		return number;
	}
	
	public String toString(){
		return ("Value Name: " +label + ": "+number);	
	}

}
