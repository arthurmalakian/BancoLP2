package br.imd.bank.test;
import br.imd.bank.accounts.BankAcc;
import br.imd.bank.accounts.CheckingAcc;
import br.imd.bank.accounts.SavingsAcc;
import br.imd.bank.comparators.*;
import br.imd.bank.entities.Bank;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class TestClass {
    Bank bank = null;
    @Before
    public void init(){
        bank = new Bank();
    }
    @org.junit.Test
    public void mustBeOrderedbyName(){
        BankAcc joaot = new SavingsAcc(1,40,200);
        BankAcc joaoa = new SavingsAcc(2,40,200);
        BankAcc joaof = new SavingsAcc(3,40,200);
        BankAcc joaop = new SavingsAcc(4,40,200);
        BankAcc creison = new CheckingAcc(5,40,0.05);
        bank.addAcc(joaot);
        bank.addAcc(joaoa);
        bank.addAcc(joaof);
        bank.addAcc(joaop);
        bank.addAcc(creison);
        joaot.activate("João Terra","192.168.10.1");
        joaoa.activate("João Alho","192.168.10.2");
        joaof.activate("João Fernando","192.168.10.3");
        joaop.activate("João Paulo","192.168.10.4");
        creison.activate("Creison","192.168.10.5");
        Collections.sort(bank.accounts, new BankAccNameComparator());
        assertSame(creison, bank.accounts.get(0));
        assertSame(joaoa, bank.accounts.get(1));
        assertSame(joaof, bank.accounts.get(2));
        assertSame(joaop, bank.accounts.get(3));
        assertSame(joaot, bank.accounts.get(4));

    }
    @Test
    public void mustBeOrderedbyCPF(){
        BankAcc joaot = new SavingsAcc(1,40,200);
        BankAcc joaoa = new SavingsAcc(2,40,200);
        BankAcc joaof = new SavingsAcc(3,40,200);
        BankAcc joaop = new SavingsAcc(4,40,200);
        BankAcc creison = new CheckingAcc(5,40,0.05);
        bank.addAcc(joaot);
        bank.addAcc(joaoa);
        bank.addAcc(joaof);
        bank.addAcc(joaop);
        bank.addAcc(creison);
        joaot.activate("João Terra","192.168.10.1");
        joaoa.activate("João Alho","192.168.10.2");
        joaof.activate("João Fernando","192.168.10.3");
        joaop.activate("João Paulo","192.168.10.4");
        creison.activate("Creison","192.168.10.5");
        Collections.sort(bank.accounts, new BankAccCpfComparator());
        assertSame(creison, bank.accounts.get(4));
        assertSame(joaoa, bank.accounts.get(1));
        assertSame(joaof, bank.accounts.get(2));
        assertSame(joaop, bank.accounts.get(3));
        assertSame(joaot, bank.accounts.get(0));

    }
    @Test
    public void mustBeOrderedbyNamethenCPF(){
        BankAcc joaot = new SavingsAcc(1,40,200);
        BankAcc joaoa = new SavingsAcc(2,40,200);
        BankAcc joaof = new SavingsAcc(3,40,200);
        BankAcc joaop = new SavingsAcc(4,40,200);
        BankAcc creison = new CheckingAcc(5,40,0.05);
        bank.addAcc(joaot);
        bank.addAcc(joaoa);
        bank.addAcc(joaof);
        bank.addAcc(joaop);
        bank.addAcc(creison);
        joaot.activate("João Terra","192.168.10.1");
        joaoa.activate("João Alho","192.168.10.2");
        joaof.activate("João Alho","192.168.10.3");
        joaop.activate("João Paulo","192.168.10.4");
        creison.activate("Creison","192.168.10.5");
        Collections.sort(bank.accounts, new BankAccNameCpfComparator());
        assertSame(creison, bank.accounts.get(4));
        assertSame(joaoa, bank.accounts.get(1));
        assertSame(joaof, bank.accounts.get(2));
        assertSame(joaop, bank.accounts.get(3));
        assertSame(joaot, bank.accounts.get(0));

    }
    @Test
    public void mustBeOrderedbyActive(){
        BankAcc joaot = new SavingsAcc(1,40,200);
        BankAcc joaoa = new SavingsAcc(2,40,200);
        BankAcc joaof = new SavingsAcc(3,40,200);
        BankAcc joaop = new SavingsAcc(4,40,200);
        BankAcc creison = new CheckingAcc(5,40,0.05);
        bank.addAcc(joaot);
        bank.addAcc(joaoa);
        bank.addAcc(joaof);
        bank.addAcc(joaop);
        bank.addAcc(creison);
        joaot.activate("João Terra","192.168.10.1");
        joaoa.activate("João Alho","192.168.10.2");
        joaof.activate("João Fernando","192.168.10.3");
        joaop.activate("João Paulo","192.168.10.4");
        creison.activate("Creison","192.168.10.5");

        joaoa.deactivate("192.168.10.2");
        creison.deactivate("192.168.10.5");

        Collections.sort(bank.accounts, new BankAccActiveComparator());

        assertSame(creison, bank.accounts.get(4));
        assertSame(joaoa, bank.accounts.get(3));
        assertSame(joaof, bank.accounts.get(1));
        assertSame(joaop, bank.accounts.get(2));
        assertSame(joaot, bank.accounts.get(0));

    }
    @Test
    public void mustBeOrderedbyCPFthenActive(){
        BankAcc joaot = new SavingsAcc(1,40,200);
        BankAcc joaoa = new SavingsAcc(2,40,200);
        BankAcc joaof = new SavingsAcc(3,40,200);
        BankAcc joaop = new SavingsAcc(4,40,200);
        BankAcc creison = new CheckingAcc(5,40,0.05);
        bank.addAcc(joaot);
        bank.addAcc(joaoa);
        bank.addAcc(joaof);
        bank.addAcc(joaop);
        bank.addAcc(creison);
        joaot.activate("João Terra","192.168.10.1");
        joaoa.activate("João Alho","192.168.10.4");
        joaof.activate("João Fernando","192.168.10.3");
        joaop.activate("João Paulo","192.168.10.4");
        creison.activate("Creison","192.168.10.4");
        joaoa.deactivate("192.168.10.4");
        creison.deactivate("192.168.10.4");
        Collections.sort(bank.accounts, new BankAccCpfActiveComparator());

        assertSame(creison, bank.accounts.get(4));
        assertSame(joaoa, bank.accounts.get(2));
        assertSame(joaof, bank.accounts.get(1));
        assertSame(joaop, bank.accounts.get(3));
        assertSame(joaot, bank.accounts.get(0));

    }
}
