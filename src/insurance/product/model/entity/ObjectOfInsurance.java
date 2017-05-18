package insurance.product.model.entity;

public abstract class ObjectOfInsurance {

	private ObjectType type;
	
	protected void setObjectType(ObjectType type){
		this.type = type;
	}
	
	protected ObjectType getObjectType(){
		return this.type;
	}

}
