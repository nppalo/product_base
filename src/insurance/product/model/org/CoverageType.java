package insurance.product.model.org;

import java.util.List;

import insurance.product.model.entity.InsuredEntity;
import insurance.product.model.entity.ObjectOfInsurance;
import insurance.product.model.primitives.NumericEntry;

public abstract class CoverageType extends ProductOrgLevel {

	protected NumericEntry computeLocalPremium(List<InsuredEntity> entity, ObjectOfInsurance object) {
		// TODO Auto-generated method stub
		return null;
	}


}
