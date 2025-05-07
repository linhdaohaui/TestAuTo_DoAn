package Interface;

public class InterfacePurchase {
    public static String xpath_btn_termOfService = "//input[@id='termsofservice']";
    public static String xpath_btn_purchase ="//button[@id='checkout']";

    public static String xpath_btn_billingAd = "//input[@onclick='Billing.save()']";
    public static String xpath_btn_shipAd ="//input[@onclick='Shipping.save()']";
    public static String xpath_btn_shipMed ="//input[@class='button-1 shipping-method-next-step-button']";
    public static String xpath_btn_payMed = "//input[@class='button-1 payment-method-next-step-button']";
    public static String xpath_btn_payInfor ="//input[@class='button-1 payment-info-next-step-button']";
    public static String xpath_confirmOrder ="//input[@value='Confirm']";
    public static String xpath_dialog_term= "//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']";
    public static String xpath_content_sign_in = "//h1[normalize-space()='Welcome, Please Sign In!']";
    public static String mess_purchase_success ="//div[@class='title']";
    public static String mess_contain_term ="Please accept the terms of service before the next step.";
    public static String xpath_acc = "//h1[normalize-space()='My account - Addresses']";

}
