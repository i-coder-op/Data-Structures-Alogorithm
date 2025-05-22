package systemdesign.lld.designpattern.facade.impl;

import systemdesign.lld.designpattern.facade.IATMMachine;
import systemdesign.lld.designpattern.facade.IPaymentService;

public class ATMMachine implements IATMMachine {
    public static Double moneyInAccount = 50000.00;

    public IPaymentService paymentService;

    public ATMMachine(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void WithdrawMoney(Double money) {
        if (money > moneyInAccount) {
            System.out.println("Please maintain the sufficient balance in you A/C to withdraw " + money);
            checkBalance();
        } else {
            moneyInAccount = moneyInAccount - money;
            System.out.println("Amount withdrawn from your account: " + money);
            checkBalance();
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Available balance in your A/C is: " + moneyInAccount);
    }

    @Override
    public void transferMoney(Double money, long accountNumber) {
        if (money > moneyInAccount) {
            System.out.println("Please maintain the sufficient balance in you A/C to transfer " + money + " to A/C Number: " + accountNumber);
            checkBalance();
        } else {
            paymentService.pay(money, accountNumber);
            moneyInAccount = moneyInAccount-money;
            checkBalance();
        }
    }
}
