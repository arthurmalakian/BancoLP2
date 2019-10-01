package br.imd.bank.entities;
import br.imd.bank.accounts.BankAcc;
public class Report {
    public void generateReport(BankAcc acc) {
        acc.showData();
    }
    public void generateReport(Bank bank){
        bank.showData();
    }
}