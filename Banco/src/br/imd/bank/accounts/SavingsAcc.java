package br.imd.bank.accounts;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
public class SavingsAcc extends BankAcc{
    private double limit;
    public SavingsAcc(int acc_num, double funds, double limit) {
        super(acc_num, funds);
        this.limit = limit;
    }
    public double getLimit() {
        return limit;
    }
    public void setLimit(double limit) {
        this.limit = limit;
    }
    public int withdraw(double amount) {
        if (amount > getFunds() + getLimit()) {
            System.out.println("Insufficient funds.");
            return -1;
        }
        setFunds(getFunds()-amount);
        return 0;
    }
    public void deposit(double amount) {
        setFunds(getFunds()+amount);
    }
    public void activate(String owner_name,String owner_cpf){
        setOwner_name(owner_name);
        setOwner_cpf(owner_cpf);
        setActive(true);
        LocalDate localdate = LocalDate.now();
        Date date = Date.from(localdate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        setRegistryDate(date);
        setCancelDate(null);
    }
    public void deactivate(String owner_cpf){
        if (!owner_cpf.equals(this.getOwner_cpf())){
            System.out.println("CPF does not match.");
            return;
        }
        LocalDate localdate = LocalDate.now();
        Date date = Date.from(localdate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        setCancelDate(date);
        setActive(false);
    }
    public void showData() {
        System.out.println("Saving Account");
        System.out.println("Account number: "+this.getAcc_num());
        System.out.println("Account owner: "+this.getOwner_name());
        System.out.println("Account owner cpf: "+this.getOwner_cpf());
        System.out.println("Active Status: "+this.isActive());
        System.out.println("Activation Day: "+this.getRegistryDate());
        System.out.println("Deactivation Day: "+this.getCancelDate());
        System.out.println("Funds: $"+this.getFunds());
        System.out.println("Limit: $"+ this.getLimit());
    }
}