package com.imokhonko.model.helper;

import com.imokhonko.model.Bank;
import com.imokhonko.model.Client;
import com.imokhonko.model.Credit;
import com.imokhonko.model.Loan;
import com.imokhonko.model.exceptions.InvalidCreditMonthsException;
import com.imokhonko.model.exceptions.InvalidCreditSumException;
import com.imokhonko.model.exceptions.NoSuchCreditInBankException;
import com.imokhonko.model.exceptions.UnableOpenCreditException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreditFiller {

    private static Client client = new Client.Builder().name("Ivan").age(19).build();

    private static Bank privat24 = new Bank("Privat24", 1237823);;
    private static Bank universalBank = new Bank("Universal Bank", 38912832);
    private static Bank otpBank = new Bank("ОТП Банк", 6895433);

    private static Credit credit5Percent = new Credit.Builder().name("For students").minSum(1000).maxSum(100000).months(12).percents(0.05).build();
    private static Credit credit7Percent = new Credit.Builder().name("For families").minSum(35000).maxSum(500000).months(36).percents(0.07).build();
    private static Credit credit5and5Percent = new Credit.Builder().name("Standard").minSum(5000).maxSum(50000).months(12).percents(0.055).payAhead(true).maxMonthIncrease(5).build();
    private static Credit credit1Percent = new Credit.Builder().name("Premium").minSum(20000).maxSum(1000000).months(12).percents(0.01).build();

    public static Client getClient() {
        return client;
    }

    public static void openLoansForClient() {
        try {
            getBanks().get(0).openLoan(new Loan(getClient(), getCredits().get(1), 45000, 10));
        } catch(UnableOpenCreditException e) {
            e.printStackTrace();
        } catch(NoSuchCreditInBankException e) {
            e.printStackTrace();
        } catch(InvalidCreditSumException e) {
            e.printStackTrace();
        } catch(InvalidCreditMonthsException e) {
            e.printStackTrace();
        }
    }

    public static List<Bank> getBanks() {
        privat24.setAvailableCredits(getCredits().get(0));
        privat24.setAvailableCredits(getCredits().get(1));
        universalBank.setAvailableCredits(getCredits().get(2));
        otpBank.setAvailableCredits(getCredits().get(3));

        return Arrays.asList(privat24, universalBank, otpBank);
    }

    private static List<Credit> getCredits() {
        List<Credit> credits = new ArrayList<>();
        credits.add(credit1Percent);
        credits.add(credit7Percent);
        credits.add(credit5and5Percent);
        credits.add(credit5Percent);

        return credits;
    }

}
