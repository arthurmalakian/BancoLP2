package br.imd.bank.entities;
import br.imd.bank.accounts.BankAcc;
import br.imd.bank.interfaces.Printer;
import java.util.ArrayList;
public class Bank implements Printer {
    public ArrayList<BankAcc> accounts = new ArrayList<BankAcc>();
    public BankAcc searchAcc(int number){
        for(BankAcc d : accounts){
            if(d.getAcc_num() == number){
                return d;
            }
        }
        return null;
    }
    public void addAcc(BankAcc acc){
        if (searchAcc(acc.getAcc_num()) != null){
            System.out.println("Account already exists.");
            return;
        }
        accounts.add(acc);
    }
    public void delAcc(BankAcc acc){
        if (searchAcc(acc.getAcc_num()) == null){
            System.out.println("Account not found.");
            return;
        }
        accounts.remove(acc);
    }
    public void showData(){
        for(BankAcc b : accounts) {
            b.showData();
        }
    }
    public ArrayList<BankAcc> searchByOwnerName(String name){
        ArrayList<BankAcc> tmp = new ArrayList<BankAcc>();
        for (BankAcc acc : accounts){
            if (acc.getOwner_name().contains(name)){
                tmp.add(acc);
            }
        }
        return tmp;
    }
    public ArrayList<BankAcc> searchByOwnerCPF(String cpf){
        ArrayList<BankAcc> tmp = new ArrayList<BankAcc>();
        for (BankAcc acc : accounts){
            if (acc.getOwner_cpf().contains(cpf)){
                tmp.add(acc);
            }
        }
        return tmp;
    }

}
