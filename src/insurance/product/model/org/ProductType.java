package insurance.product.model.org;

import java.util.List;

import insurance.product.model.entity.InsuredEntity;
import insurance.product.model.entity.ObjectOfInsurance;
import insurance.product.model.primitives.NumericEntry;
import insurance.product.model.primitives.ValidationResult;


public abstract class ProductType extends ProductOrgLevel {

	public List<NumericEntry> computePremium(List<InsuredEntity> entities, ObjectOfInsurance object){
		return computePremiums(null, entities, object);
	}
	
	public List<ValidationResult> evaluateEligibility(List<InsuredEntity> entities, ObjectOfInsurance object){
		return evaluateEligibility(null, entities, object);
	}


}
