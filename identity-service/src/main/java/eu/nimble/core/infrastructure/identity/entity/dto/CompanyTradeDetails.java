package eu.nimble.core.infrastructure.identity.entity.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johannes Innerbichler on 02.10.18.
 */
public class CompanyTradeDetails {

    private List<PaymentMeans> paymentMeans = new ArrayList<>();
    private List<DeliveryTerms> deliveryTerms = new ArrayList<>();
    private Integer ppapCompatibilityLevel;
    private String stripeAccountId;

    public CompanyTradeDetails() {
    }

    public CompanyTradeDetails(List<PaymentMeans> paymentMeans, List<DeliveryTerms> deliveryTerms, Integer ppapCompatibilityLevel, String stripeAccountId) {
        this.paymentMeans = paymentMeans;
        this.deliveryTerms = deliveryTerms;
        this.ppapCompatibilityLevel = ppapCompatibilityLevel;
        this.stripeAccountId = stripeAccountId;
    }

    public List<PaymentMeans> getPaymentMeans() {
        return paymentMeans;
    }

    public void setPaymentMeans(List<PaymentMeans> paymentMeans) {
        this.paymentMeans = paymentMeans;
    }

    public List<DeliveryTerms> getDeliveryTerms() {
        return deliveryTerms;
    }

    public void setDeliveryTerms(List<DeliveryTerms> deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }

    public Integer getPpapCompatibilityLevel() {
        return ppapCompatibilityLevel;
    }

    public void setPpapCompatibilityLevel(Integer ppapCompatibilityLevel) {
        this.ppapCompatibilityLevel = ppapCompatibilityLevel;
    }

    public String getStripeAccountId() {
        return stripeAccountId;
    }

    public void setStripeAccountId(String stripeAccountId) {
        this.stripeAccountId = stripeAccountId;
    }
}
