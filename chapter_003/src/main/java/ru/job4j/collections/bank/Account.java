package ru.job4j.collections.bank;

public class Account {
    private long value;
    private String requisites;

    public Account(long value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    boolean transfer(Account destination, long amount) {
        boolean isTransfer = false;

        if (this.value >= amount) {
            this.value = this.value - amount;
            destination.setValue(destination.getValue() + amount);
            isTransfer = true;
        }
        return isTransfer;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (value != account.value) {
            return false;
        }
        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (value ^ (value >>> 32));
        result = 31 * result + (requisites != null ? requisites.hashCode() : 0);
        return result;
    }
}
