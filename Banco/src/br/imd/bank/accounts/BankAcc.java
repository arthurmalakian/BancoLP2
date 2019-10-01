package br.imd.bank.accounts;
import br.imd.bank.interfaces.Printer;
import java.util.Date;
public abstract class BankAcc implements Printer {
    private int acc_num;
    private double funds;
    private String owner_name;
    private String owner_cpf;
    private Date registryDate;
    private Date cancelDate;
    private boolean active;
    public BankAcc(int acc_num, double funds) {
        this.acc_num = acc_num;
        this.funds = funds;
        this.active = false;
    }
    public int getAcc_num() {
        return acc_num;
    }
    public void setAcc_num(int acc_num) {
        this.acc_num = acc_num;
    }
    public double getFunds() {
        return funds;
    }
    public void setFunds(double funds) {
        this.funds = funds;
    }
    public String getOwner_name() {
        return owner_name;
    }
    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }
    public String getOwner_cpf() {
        return owner_cpf;
    }
    public void setOwner_cpf(String owner_cpf) {
        this.owner_cpf = owner_cpf;
    }
    public Date getRegistryDate() {
        return registryDate;
    }
    public void setRegistryDate(Date registryDate) {
        this.registryDate = registryDate;
    }
    public Date getCancelDate() {
        return cancelDate;
    }
    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public abstract int withdraw(double amount);
    public abstract void deposit(double amount);
    public abstract void activate(String owner_name,String owner_cpf);
    public abstract void deactivate(String owner_cpf);
    public void transfer(BankAcc acc2, double value){
        if (this.withdraw(value) != -1){
            acc2.deposit(value);
        }else{
            System.out.println("Insufficient funds.");
        }
    }
    public boolean equals(Object o){
        if(!(o instanceof BankAcc)){
            return false;
        }
        final BankAcc tmp = (BankAcc) o;
        return this.getAcc_num() == (tmp.getAcc_num());
    }
}
