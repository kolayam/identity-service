package eu.nimble.core.infrastructure.identity.clients;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.stripe.Stripe;
import com.stripe.exception.PermissionException;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.AccountLink;
import com.stripe.model.LoginLink;
import com.stripe.model.checkout.Session;
import com.stripe.param.AccountCreateParams;
import com.stripe.param.AccountLinkCreateParams;
import com.stripe.param.checkout.SessionCreateParams;

@Component
public class StripeClient {
    
    private static final Logger logger = LoggerFactory.getLogger(StripeClient.class);

    @Value("${nimble.stripe.secretKey}")
    private String stripeSecretKey;

    @Value("${nimble.stripe.refreshUrl}")
    private String stripeRefreshUrl;

    @Value("${nimble.stripe.returnUrl}")
    private String stripeReturnUrl;

    @Value("${nimble.frontend.url}")
    private String frontendUrl;


    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeSecretKey;
    }

    public eu.nimble.core.infrastructure.identity.entity.stripe.AccountLink createAccount() throws StripeException {
        // create an Express account
        AccountCreateParams params =
                AccountCreateParams.builder()
                        .setType(AccountCreateParams.Type.EXPRESS)
                        .setCountry("GB")
                                        .setCapabilities(
                        AccountCreateParams.Capabilities.builder()
                                .setCardPayments(
                                        AccountCreateParams.Capabilities.CardPayments.builder()
                                                .setRequested(true)
                                                .build()
                                )
                                .setTransfers(
                                        AccountCreateParams.Capabilities.Transfers.builder()
                                                .setRequested(true)
                                                .build()
                                ).build()
                        )
                        .build();

        Account account = Account.create(params);
        // return account link url
        return getAccountLink(account.getId());
    }

    public boolean deleteAccount(String accountId) throws StripeException {
        Account account = Account.retrieve(accountId);
        Account deletedAccount = account.delete();
        return deletedAccount.getDeleted();
    }

    public eu.nimble.core.infrastructure.identity.entity.stripe.AccountLink getAccountLink(String accountId) throws StripeException {
        // create an account link
        AccountLinkCreateParams accountLinkParams =
                AccountLinkCreateParams.builder()
                        .setAccount(accountId)
                        .setRefreshUrl(stripeRefreshUrl)
                        .setReturnUrl(stripeReturnUrl)
                        .setType(AccountLinkCreateParams.Type.ACCOUNT_ONBOARDING)
                        .build();

        AccountLink accountLink = AccountLink.create(accountLinkParams);

        eu.nimble.core.infrastructure.identity.entity.stripe.AccountLink stripeAccountLink = new eu.nimble.core.infrastructure.identity.entity.stripe.AccountLink();
        stripeAccountLink.setAccountId(accountId);
        stripeAccountLink.setUrl(accountLink.getUrl());
        // return account link url
        return stripeAccountLink;
    }

    public boolean validateAccount(String accountId) throws StripeException {
        try {
            Account account = Account.retrieve(accountId);
            return account.getDetailsSubmitted();
        } catch (PermissionException permissionException) {
            return false;
        }
    }

    public String getAccountLoginLink(String id) throws StripeException {
        boolean isAccountValid = validateAccount(id);
        if (isAccountValid) {
            LoginLink login_link = LoginLink.createOnAccount(
                    id,
                    (Map<String, Object>) null,
                    null
            );
            return login_link.getUrl();
        }
        return null;
    }


    public String createCheckout(String priceId){
        Stripe.apiKey = stripeSecretKey;
        String YOUR_DOMAIN = this.frontendUrl;
            SessionCreateParams params = SessionCreateParams.builder()
                    .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
                    .setSuccessUrl(YOUR_DOMAIN + "/success.html")
                    .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
                    .setAutomaticTax(
                            SessionCreateParams.AutomaticTax.builder()
                                    .setEnabled(true)
                                    .build())
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()
                                    .setQuantity(1L)
                                    // Provide the exact Price ID (for example, pr_1234) of the product you want to
                                    // sell
                                    .setPrice(priceId)
                                    .build())
                    .build();
            Session session;
            try {
                session = Session.create(params);
                return session.getUrl();

            } catch (StripeException e) {
                logger.error("Unexpected error while create checkout session:", e);
                throw new RuntimeException(e);
            }

    }
}