package systemdesign.lld.designpattern.facade.impl;

import systemdesign.lld.designpattern.facade.IPaymentService;

public class PaytmPaymentService implements IPaymentService {
    @Override
    public void pay(Double money, long accountNumber) {
        System.out.println(money + " has been transferred to A/C number: " + accountNumber);
    }
}
