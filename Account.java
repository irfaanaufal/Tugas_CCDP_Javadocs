import java.util.UUID;

/**
 * Kelas yang mewakili akun bank.
 * Setiap akun memiliki saldo, nomor akun, dan pemilik akun.
 */
public class Account {
    /** ID unik untuk akun */
    private final String accountNumber;

    /** Nama pemilik akun */
    private String owner;

    /** Saldo akun */
    private double balance;

    /**
     * Membuat akun baru dengan pemilik yang diberikan.
     *
     * @param owner Nama pemilik akun
     */
    public Account(String owner) {
        this.accountNumber = UUID.randomUUID().toString();
        this.owner = owner;
        this.balance = 0.0;
    }

    /**
     * Mendapatkan saldo akun.
     *
     * @return Saldo akun
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Mendapatkan nomor akun.
     *
     * @return Nomor akun
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Menambahkan jumlah ke saldo akun.
     *
     * @param amount Jumlah yang akan ditambahkan
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    /**
     * Mengurangi jumlah dari saldo akun.
     *
     * @param amount Jumlah yang akan dikurangi
     * @return true jika penarikan berhasil, false jika saldo tidak mencukupi
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
