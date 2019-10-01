package br.imd.bank.comparators;

import br.imd.bank.accounts.BankAcc;

import java.util.Comparator;

public class BankAccActiveComparator implements Comparator<BankAcc> {
    public int compare(BankAcc acc1,BankAcc acc2){
        return Boolean.valueOf(acc2.isActive()).compareTo(Boolean.valueOf(acc1.isActive()));
    }
}
