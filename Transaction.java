import java.time.LocalDateTime;

/**
 * Kelas yang merepresentasikan transaksi di akun bank.
 */
public class Transaction {
    /** Jenis transaksi (debit/kredit) */
    private String type;

    /** Jumlah transaksi */
    private double amount;

    /** Waktu transaksi */
    private LocalDateTime timestamp;

    /**
     * Membuat transaksi baru.
     *
     * @param type Jenis transaksi
     * @param amount Jumlah transaksi
     */
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Mendapatkan jenis transaksi.
     *
     * @return Jenis transaksi
     */
    public String getType() {
        return type;
    }

    /**
     * Mendapatkan jumlah transaksi.
     *
     * @return Jumlah transaksi
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Mendapatkan waktu transaksi.
     *
     * @return Waktu transaksi
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
