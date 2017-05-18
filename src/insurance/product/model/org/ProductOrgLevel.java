package insurance.product.model.org;

import java.util.ArrayList;
import java.util.List;

import insurance.product.model.entity.InsuredEntity;
import insurance.product.model.primitives.NumericEntry;
import insurance.product.model.entity.ObjectOfInsurance;
import insurance.product.model.primitives.ValidationResult;

public abstract class ProductOrgLevel {


	private List<ProductOrgLevel> children;
	

	public List<ProductOrgLevel> getChildren() {
		return children;
	}

	public void addChild(ProductOrgLevel child) {
		if (children == null){
			children = new ArrayList<ProductOrgLevel>();
		}
		children.add(child);
	}

	
	protected abstract NumericEntry computeLocalPremium(List<InsuredEntity> entity, ObjectOfInsurance object);

	protected abstract ValidationResult evaluateLocalEligibility(List<InsuredEntity> entity,
			ObjectOfInsurance object);

	/**
	 * Computes the gross premium of all the component product, section or
	 * coverage
	 * 
	 * @param entity
	 * @param object
	 * @return
	 */
	protected List<NumericEntry> computePremiums(List<NumericEntry> premiums, List<InsuredEntity> entity,
			ObjectOfInsurance object) {

		// this may be the root node
		if (premiums == null) {
			premiums = new ArrayList<NumericEntry>();
		}
		
		computeBranchPremiums(premiums, entity, object);

		NumericEntry localPremium = computeLocalPremium(entity, object); 
		if (localPremium != null) premiums.add(localPremium);

		return premiums;
	}

	protected void computeBranchPremiums(List<NumericEntry> premiums, List<InsuredEntity> entity,
			ObjectOfInsurance object) {

		//if there are branch nodes, compute those first
		if (children != null){
			for (ProductOrgLevel child : children) {
				child.computePremiums(premiums, entity, object);
			}
		}
	}

	protected List<ValidationResult> evaluateEligibility(List<ValidationResult> eligibilityResults,
			List<InsuredEntity> entity, ObjectOfInsurance object) {

		// this may be the root node so make sure this created
		if (eligibilityResults == null) {
			eligibilityResults = new ArrayList<ValidationResult>();
		}

		// evaluate branches first
		evaluateBranchEligibility(eligibilityResults, entity, object);

		// then evaluate top
		ValidationResult localEligibility = evaluateLocalEligibility(entity, object);
		if (localEligibility != null) {
			eligibilityResults.add(localEligibility);
		}

		return eligibilityResults;
	}

	protected void evaluateBranchEligibility(List<ValidationResult> eligibilityResults, List<InsuredEntity> entity,
			ObjectOfInsurance object) {
		if (children != null){
			for (ProductOrgLevel child : children) {
				child.evaluateEligibility(eligibilityResults, entity, object);
			}
		}
	}

}
