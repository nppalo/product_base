package insurance.product.model.primitives;

import java.util.List;

import insurance.product.model.primitives.ErrorEntry;

public class ValidationResult {

	private boolean isValid = false;
	private String validationItemName = "";
	private List <ErrorEntry> errorList = null;

	public ValidationResult(boolean isValid, String validationItemName, List<ErrorEntry> errorList){
		this.isValid = isValid;
		this.errorList = errorList;
		this.validationItemName = validationItemName;
	}
	
	public boolean isValid() {
		return isValid;
	}

	public List<ErrorEntry> getErrorList() {
		return errorList;
	}
	
	public String getValidationItemName(){
		return validationItemName;
	}

	public String toString(){
		return ("Validation: "+validationItemName +": " +isValid);	
	}
	
}
