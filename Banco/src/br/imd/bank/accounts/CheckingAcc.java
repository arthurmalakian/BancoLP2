package br.imd.bank.accounts;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class CheckingAcc extends BankAcc {
    public double operationTax;
    public CheckingAcc(int acc_num, double funds, double operationTax) {
        super(acc_num, funds);
        this.operationTax = operationTax;
    }
    public double getOperationTax() {
        return operationTax;
    }
    public void setOperationTax(double operationTax) {
        this.operationTax = operationTax;
    }
    public int withdraw(double amount) {
        if((amount + amount * getOperationTax() > getFunds())) {
            System.out.println("Insufficient funds");
            return -1;
        }
        setFunds(getFunds() - amount - amount * getOperationTax());
        return 0;
    }
    public void deposit(double amount) {
        setFunds(getFunds()+amount-amount*getOperationTax());
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
        System.out.println("Checking Account");
        System.out.println("Account number: "+this.getAcc_num());
        System.out.println("Account owner: "+this.getOwner_name());
        System.out.println("Account owner cpf: "+this.getOwner_cpf());
        System.out.println("Active Status: "+this.isActive());
        System.out.println("Activation Day: "+this.getRegistryDate());
        System.out.println("Deactivation Day: "+this.getCancelDate());
        System.out.println("Funds: $"+this.getFunds());
        System.out.println("Operation tax: "+ Math.round(this.getOperationTax() * 100)+"%");
    }
}
