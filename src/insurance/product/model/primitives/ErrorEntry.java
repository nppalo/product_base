package insurance.product.model.primitives
;

public class ErrorEntry {

	private String errorCode;
	private String errorDescription;

	public ErrorEntry(String errorCode, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}
}
