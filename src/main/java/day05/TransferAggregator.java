package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TransferAggregator {
    private Map<String, TransferPerClient> accounts = new TreeMap<>();

    public void start() {
        readInData(Path.of("src/test/resources/transfers.csv"));
    }

    private void readInData(Path path) {
        try (BufferedReader bf = Files.newBufferedReader(path)) {
            String line;
            while ((line = bf.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException io) {
            throw new IllegalArgumentException("no file");
        }
    }

    private void processLine(String line) {
        String[] tmp = line.split(",");
        String sender = tmp[0];
        String receiver = tmp[1];
        int amount = Integer.parseInt(tmp[2].trim());
        validateID(sender);
        validateID(receiver);
        manageTransfer(sender, receiver, amount);

    }

    private void manageTransfer(String sender, String receiver, int amount) {
        accounts.get(sender).send(amount);
        accounts.get(receiver).receive(amount);
    }


    private TransferPerClient validateID(String id) {
        TransferPerClient tfc = accounts.get(id);
        if (tfc == null) {
            tfc = new TransferPerClient(id);
            accounts.put(id, tfc);
        }
        return tfc;
    }

    public Map<String, TransferPerClient> getAccounts() {
        return accounts;
    }

    public void summer() {
        for (Map.Entry<String,TransferPerClient> transfer : accounts.entrySet()) {
            System.out.printf("%s %,12d %5d\n",
                    transfer.getValue().getID(), transfer.getValue().getBalance(), transfer.getValue().getMoves());
        }
    }
}
