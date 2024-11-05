import java.util.ArrayList;
import java.util.List;

/**
 * Kelas yang mengelola akun bank dan menyediakan layanan transaksi.
 */
public class Bank {
    /** Daftar akun di bank */
    private List<Account> accounts = new ArrayList<>();

    /** Daftar transaksi di bank */
    private List<Transaction> transactions = new ArrayList<>();

    /**
     * Membuat akun baru untuk pemilik yang diberikan.
     *
     * @param owner Nama pemilik akun
     * @return Akun yang baru dibuat
     */
    public Account createAccount(String owner) {
        Account account = new Account(owner);
        accounts.add(account);
        return account;
    }

    /**
     * Melakukan penyetoran ke akun yang ditentukan.
     *
     * @param account Akun tujuan setoran
     * @param amount Jumlah yang akan disetor
     */
    public void deposit(Account account, double amount) {
        account.deposit(amount);
        transactions.add(new Transaction("credit", amount));
    }

    /**
     * Melakukan penarikan dari akun yang ditentukan.
     *
     * @param account Akun yang akan dilakukan penarikan
     * @param amount Jumlah yang akan ditarik
     * @return true jika penarikan berhasil, false jika gagal
     */
    public boolean withdraw(Account account, double amount) {
        boolean success = account.withdraw(amount);
        if (success) {
            transactions.add(new Transaction("debit", amount));
        }
        return success;
    }

    /**
     * Melakukan transfer antar akun.
     *
     * @param fromAccount Akun pengirim
     * @param toAccount Akun penerima
     * @param amount Jumlah yang akan ditransfer
     * @return true jika transfer berhasil, false jika saldo tidak mencukupi
     */
    public boolean transfer(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            transactions.add(new Transaction("transfer", amount));
            return true;
        }
        return false;
    }

    /**
     * Mendapatkan daftar semua transaksi di bank.
     *
     * @return Daftar transaksi
     */
    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
}
