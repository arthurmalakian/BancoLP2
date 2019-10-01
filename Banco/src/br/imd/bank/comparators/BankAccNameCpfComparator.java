package br.imd.bank.comparators;
import br.imd.bank.accounts.BankAcc;
import java.util.Comparator;

public class BankAccNameCpfComparator implements Comparator<BankAcc> {
    public int compare(BankAcc acc1, BankAcc acc2){
        if(acc1.getOwner_name().compareTo(acc2.getOwner_name()) == 0){
            return acc1.getOwner_cpf().compareTo(acc2.getOwner_cpf());
        }else{
            return acc1.getOwner_name().compareTo(acc2.getOwner_name());
        }
    }
}
