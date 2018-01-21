package demo.vo;

public class Merchant {

	private String merchantId;
	private String countryCode;
	private String legalName;
	private String discountRate;
	
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(String discountRate) {
		this.discountRate = discountRate;
	}
	@Override
	public String toString() {
		return "Merchant [merchantId=" + merchantId + ", countryCode=" + countryCode + ", legalName=" + legalName
				+ ", discountRate=" + discountRate + "]";
	}
	
	
}
