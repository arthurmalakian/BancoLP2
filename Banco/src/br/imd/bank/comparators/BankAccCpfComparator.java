package br.imd.bank.comparators;

import br.imd.bank.accounts.BankAcc;

import java.util.Comparator;

public class BankAccCpfComparator implements Comparator<BankAcc> {
    public int compare(BankAcc acc1,BankAcc acc2){
        return acc1.getOwner_cpf().compareTo(acc2.getOwner_cpf());
    }
}
