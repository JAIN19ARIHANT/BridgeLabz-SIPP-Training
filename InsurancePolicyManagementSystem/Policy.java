package InsurancePolicyManagementSystem;

import java.time.LocalDate;
import java.util.Objects;

class Policy {
    private final String policyNo;
    private final String name;
    private final LocalDate expDate;
    private final Coverage coverage;
    private final double premium;

    public Policy(String policyNo, String name, LocalDate expDate,Coverage coverage, double premium) {
        this.policyNo = policyNo;
        this.name = name;
        this.expDate = expDate;
        this.coverage = coverage;
        this.premium = premium;
    }

    public String getPolicyNo() { return this.policyNo; }

    public String getName() { return this.name; }

    public LocalDate getExpDate() { return this.expDate; }

    public Coverage getCoverage() { return this.coverage; }

    public double getPremium() { return this.premium; }

    @Override
    public String toString() {
        return "\nPolicy #" + this.policyNo
                + "\nPolicy Holder : " + this.name
                + "\nRenewal Date : " + this.expDate
                + "\nPolicy Type : " + this.coverage
                + "\nPremium ₹ : " + this.premium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  return true;
        if (!(o instanceof Policy)) return false;
        Policy that = (Policy) o;
        return Objects.equals(this.policyNo, that.policyNo);
    }
}
