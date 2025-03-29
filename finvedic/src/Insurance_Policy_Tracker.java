import java.util.ArrayList;
import java.util.List;

class Policy {
	private String policyId;
	private String insuranceProvider;
	private double insuredAmount;
	private double monthlyPremium;
	private String policyExpiryDate;

	public Policy(String policyId, String insuranceProvider, double insuredAmount, double monthlyPremium,
			String policyExpiryDate) {
		this.policyId = policyId;
		this.insuranceProvider = insuranceProvider;
		this.insuredAmount = insuredAmount;
		this.monthlyPremium = monthlyPremium;
		this.policyExpiryDate = policyExpiryDate;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void modifyPolicy(Double insuredAmount, Double monthlyPremium, String policyExpiryDate) {
		if (insuredAmount != null) {
			this.insuredAmount = insuredAmount;
		}
		if (monthlyPremium != null) {
			this.monthlyPremium = monthlyPremium;
		}
		if (policyExpiryDate != null) {
			this.policyExpiryDate = policyExpiryDate;
		}
		System.out.println("Policy " + policyId + " updated successfully.");
	}

	@Override
	public String toString() {
		return "Policy ID: " + policyId + ", Provider: " + insuranceProvider + ", Insured Amount: $" + insuredAmount
				+ ", Monthly Premium: $" + monthlyPremium + ", Expiry Date: " + policyExpiryDate;
	}
}

class PolicyManager {
	private List<Policy> policyList;

	public PolicyManager() {
		policyList = new ArrayList<>();
	}

	public void registerPolicy(Policy policy) {
		policyList.add(policy);
		System.out.println("Policy added: " + policy.getPolicyId());
	}

	public void updatePolicyDetails(String policyId, Double insuredAmount, Double monthlyPremium,
			String policyExpiryDate) {
		for (Policy policy : policyList) {
			if (policy.getPolicyId().equals(policyId)) {
				policy.modifyPolicy(insuredAmount, monthlyPremium, policyExpiryDate);
				return;
			}
		}
		System.out.println("Policy ID " + policyId + " not found.");
	}

	public void displayAllPolicies() {
		if (policyList.isEmpty()) {
			System.out.println("No policies available.");
			return;
		}
		for (Policy policy : policyList) {
			System.out.println(policy);
		}
	}
}

public class Insurance_Policy_Tracker {
	public static void main(String[] args) {
		PolicyManager policyManager = new PolicyManager();
		policyManager.registerPolicy(new Policy("P98765", "Teja Insurance", 200000, 1500, "2026-08-15"));
		policyManager.registerPolicy(new Policy("P54321", "LMN Insurance", 75000, 800, "2024-11-20"));
		System.out.println("\nCurrent Policies:");
		policyManager.displayAllPolicies();
		policyManager.updatePolicyDetails("P98765", 250000.0, 1600.0, null);
		System.out.println("\nUpdated Policies:");
		policyManager.displayAllPolicies();
	}
}
