package day05;

import java.util.Objects;

public class TransferPerClient implements Comparable<TransferPerClient> {
    private String ID;
    private int balance;
    private int moves;

    public TransferPerClient(String ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransferPerClient)) return false;
        TransferPerClient account = (TransferPerClient) o;
        return Objects.equals(ID, account.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }


    public String getID() {
        return ID;
    }


    public void send(int amount) {
        this.balance -= amount;
        this.moves++;
    }

    public void receive(int amount) {
        this.balance += amount;
        this.moves++;
    }

    public int getBalance() {
        return balance;
    }

    public int getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID='" + ID + '\'' +
                ", balance=" + balance +
                ", moves=" + moves +
                '}';
    }

    @Override
    public int compareTo(TransferPerClient o) {
        return this.getID().compareTo(o.getID());
    }
}
