package com.solvd.laba.travelagency.service;

import com.solvd.laba.travelagency.exception.AlreadyPaidException;
import com.solvd.laba.travelagency.exception.MoneyTransferReceiverException;
import com.solvd.laba.travelagency.exception.NotEnoughMoneyException;
import com.solvd.laba.travelagency.model.finance.payment.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class PaymentProcessor {
    private static final Logger log = LogManager.getLogger(PaymentProcessor.class);

    public static void processTransaction(Supplier<Transaction> transactionSupplier) throws AlreadyPaidException {
        Transaction transaction = transactionSupplier.get();
        if(transaction.getPayable().isPaid()) {
            throw new AlreadyPaidException();
        }
        if(transaction.getSender().equals(transaction.getReceiver())) {
            throw new MoneyTransferReceiverException("Sender credentials cannot equal to receiver");
        }
        double amount = transaction.getPayable().getPrice();
        try {
            transaction.getSender().pay(amount, transaction.getReceiver());
            transaction.getPayable().setPaid(true);
            transaction.setTimestamp(LocalDateTime.now());
            TransactionStorageManager.saveTransaction(transaction);
        } catch(NotEnoughMoneyException ex){
            transaction.getPayable().setPaid(false);
            log.error(ex.getMessage());
        }
    }
}
