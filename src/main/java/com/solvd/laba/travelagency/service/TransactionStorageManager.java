package com.solvd.laba.travelagency.service;

import com.solvd.laba.travelagency.model.finance.payment.PaymentCredentials;
import com.solvd.laba.travelagency.model.finance.payment.Transaction;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class TransactionStorageManager {
    private static final Logger log = LogManager.getLogger(TransactionStorageManager.class);
    private static final String FILE_PATH = "src/main/resources/data.json";

    public static void saveTransaction(Transaction transaction) {
        JSONObject sender = convertPaymentCredentialsToJson(transaction.getSender());
        JSONObject receiver = convertPaymentCredentialsToJson(transaction.getReceiver());
        JSONObject newTransaction = new JSONObject()
                .put("sender", sender)
                .put("receiver", receiver)
                .put("amount", transaction.getPayable().getPrice())
                .put("timestamp", transaction.getTimestamp());
        try {
            File file = new File(FILE_PATH);
            JSONObject parent = new JSONObject(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
            JSONArray transactions = parent.getJSONArray("transactions");
            transactions.put(newTransaction);
            parent.put("transactions", transactions);
            FileUtils.writeStringToFile(file, parent.toString(4), StandardCharsets.UTF_8);
        } catch(IOException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    public static List<String> getTransactionsInPeriod(LocalDate startDate, LocalDate endDate) {
        if(startDate.isAfter(endDate)){
            throw new IllegalArgumentException("End date must be after start date");
        }
        try {
            File file = new File(FILE_PATH);
            JSONObject parent = new JSONObject(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
            JSONArray transactions = parent.getJSONArray("transactions");
            return StreamSupport.stream(transactions.spliterator(), false)
                    .map(JSONObject.class::cast)
                    .filter(json -> {
                        LocalDate date = LocalDateTime.parse(json.getString("timestamp")).toLocalDate();
                        return date.isEqual(startDate) || date.isEqual(endDate)
                                || (date.isAfter(startDate) && date.isBefore(endDate));
                    }).map(json -> json.toString(4))
                    .toList();
        } catch(IOException ex) {
            log.error(ex.getMessage(), ex);
        }
        return List.of();
    }

    public static List<String> getTransactionsOnDate(LocalDate date) {
        try {
            File file = new File(FILE_PATH);
            JSONObject parent = new JSONObject(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
            JSONArray transactions = parent.getJSONArray("transactions");
            return StreamSupport.stream(transactions.spliterator(), false)
                    .map(JSONObject.class::cast)
                    .filter(json -> {
                        LocalDate d = LocalDateTime.parse(json.getString("timestamp")).toLocalDate();
                        return date.isEqual(d);
                    }).map(json -> json.toString(4))
                    .toList();
        } catch(IOException ex) {
            log.error(ex.getMessage(), ex);
            return new ArrayList<>();
        }
    }

    public static void clearTransactions() {
        try {
            File file = new File(FILE_PATH);
            JSONObject parent = new JSONObject(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
            parent.put("transactions", new JSONArray());
            FileUtils.writeStringToFile(file, parent.toString(4), StandardCharsets.UTF_8);
        } catch(IOException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private static JSONObject convertPaymentCredentialsToJson(PaymentCredentials credentials) {
        return new JSONObject()
                .put("credential_type", credentials.getCredentialType())
                .put("number", credentials.getCredentialId());
    }
}
