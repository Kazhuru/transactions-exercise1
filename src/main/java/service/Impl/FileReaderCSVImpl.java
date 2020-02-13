package service.Impl;

import models.Transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class FileReaderCSVImpl implements service.FileReader {
    public static final String CSV = ".csv";

    @Override
    public List<Transaction> getTransactions(String fileName) {
        List<Transaction> transactions = new LinkedList<>();
        Path path = Paths.get(fileName.concat(CSV));

        try {
            BufferedReader bufferedReader =
                    Files.newBufferedReader(path, StandardCharsets.US_ASCII);

            bufferedReader.readLine(); //To jump the CSV first line
            String csvLine = bufferedReader.readLine();
            while (csvLine != null) {
                String[] transactionData = csvLine.split(",");
                transactions.add(createTransaction(transactionData));
                csvLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactions;
    }

    private Transaction createTransaction(String[] transactionData) {
        return new Transaction(
                Long.parseLong(transactionData[0]),
                Double.parseDouble(transactionData[1]),
                transactionData[2], transactionData[3], transactionData[4]);
    }
}
