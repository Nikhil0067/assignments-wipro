package com.example.billing_service.dto;

public class InsuranceRequest {
    private String provider;
    private String claimNumber;

    public InsuranceRequest() {}

    public InsuranceRequest(String provider, String claimNumber) {
        this.provider = provider;
        this.claimNumber = claimNumber;
    }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }
    public String getClaimNumber() { return claimNumber; }
    public void setClaimNumber(String claimNumber) { this.claimNumber = claimNumber; }
}
