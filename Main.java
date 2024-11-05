/**
 * Kelas Main untuk menjalankan simulasi sederhana dari sistem manajemen bank.
 * Melakukan berbagai operasi perbankan seperti membuat akun, penyetoran, penarikan, dan transfer.
 */
public class Main {
    public static void main(String[] args) {
        // Membuat instance Bank
        Bank bank = new Bank();

        // Membuat akun untuk dua nasabah
        Account account1 = bank.createAccount("Irfaan");
        Account account2 = bank.createAccount("Naufal");

        // Melakukan penyetoran ke akun Irfaan
        System.out.println("Menyetorkan Rp1000 ke akun Irfaan.");
        bank.deposit(account1, 1000);
        System.out.println("Saldo Irfaan setelah setoran: Rp" + account1.getBalance());

        // Melakukan penyetoran ke akun Naufal
        System.out.println("Menyetorkan Rp500 ke akun Naufal.");
        bank.deposit(account2, 500);
        System.out.println("Saldo Naufal setelah setoran: Rp" + account2.getBalance());

        // Melakukan penarikan dari akun Irfaan
        System.out.println("Menarik Rp300 dari akun Irfaan.");
        if (bank.withdraw(account1, 300)) {
            System.out.println("Penarikan berhasil. Saldo Irfaan sekarang: Rp" + account1.getBalance());
        } else {
            System.out.println("Penarikan gagal. Saldo tidak mencukupi.");
        }

        // Melakukan transfer dari akun Irfaan ke akun Naufal
        System.out.println("Melakukan transfer Rp200 dari Irfaan ke Naufal.");
        if (bank.transfer(account1, account2, 200)) {
            System.out.println("Transfer berhasil.");
            System.out.println("Saldo Irfaan: Rp" + account1.getBalance());
            System.out.println("Saldo Naufal: Rp" + account2.getBalance());
        } else {
            System.out.println("Transfer gagal. Saldo tidak mencukupi.");
        }

        // Menampilkan daftar transaksi yang telah terjadi
        System.out.println("\nDaftar transaksi yang terjadi:");
        for (Transaction transaction : bank.getTransactions()) {
            System.out.println(transaction.getType() + " - Rp" + transaction.getAmount() + " pada " + transaction.getTimestamp());
        }
    }
}
