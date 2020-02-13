import service.TransactionRepository;
import service.DisplayData;
import service.Impl.TransactionRepositoryH2Impl;
import service.Impl.DisplayDataHTMLImpl;
import service.FileReader;
import service.Impl.FileReaderJSONImpl;

public class Application {

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderJSONImpl();
        TransactionRepository transactionRepository = new TransactionRepositoryH2Impl();
        DisplayData displayData = new DisplayDataHTMLImpl();
        //-------
        transactionRepository.saveTransactions(fileReader.getTransactions("input"));
        displayData.displayTransactionsReport(transactionRepository.getTablesDifferences("otherTransactionsTable"));
    }
}
