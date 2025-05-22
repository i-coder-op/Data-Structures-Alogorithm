package systemdesign.lld.designpattern.facade;

public interface IATMMachine {
    public void WithdrawMoney(Double money);
    public void checkBalance();
    public void transferMoney(Double money, long accountNumber);
}
