package systemdesign.lld.designpattern.facade.runner;

import systemdesign.lld.designpattern.facade.IATMMachine;
import systemdesign.lld.designpattern.facade.impl.ATMMachine;
import systemdesign.lld.designpattern.facade.impl.PaytmPaymentService;

public class ATMApplicationRunner {
    public static void main(String[] args) {
        IATMMachine atmMachine = new ATMMachine(new PaytmPaymentService());

        atmMachine.checkBalance();
        atmMachine.WithdrawMoney(23000.00);
        atmMachine.transferMoney(23000.00, 9752109735L);
        atmMachine.WithdrawMoney(30000.00);
    }
}
