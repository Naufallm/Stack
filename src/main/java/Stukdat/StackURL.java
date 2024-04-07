package Stukdat;


import java.util.Scanner;
public class StackURL {

    private String[] riwayat;
    private int currentPosition = -1;
    private int maxSize;
    private Scanner scanner = new Scanner(System.in);

    public StackURL(int maxSize) {
        this.maxSize = maxSize;
        riwayat = new String[maxSize];
    }

    public void start() {
        while (true) {
            System.out.println("\nRiwayat Navigasi");
            System.out.println("1. Kunjungi URL");
            System.out.println("2. Kembali");
            System.out.println("3. Maju");
            System.out.println("4. URL Saat Ini");
            System.out.println("5. Keluar");

            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    visitURL();
                    break;
                case 2:
                    back();
                    break;
                case 3:
                    forward();
                    break;
                case 4:
                    System.out.println("URL Saat Ini: " + getCurrentURL());
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void visitURL() {
        System.out.print("Masukkan URL: ");
        String url = scanner.next();

        // (menambahkan ke riwayat)
        currentPosition++;
        if (currentPosition >= maxSize) {
            // Geser elemen lama untuk menghemat ruang
            for (int i = 0; i < maxSize - 1; i++) {
                riwayat[i] = riwayat[i + 1];
            }
        }
        riwayat[currentPosition] = url;

        //  history "maju" untuk simulasi stack (LIFO)
        for (int i = currentPosition + 1; i < maxSize; i++) {
            riwayat[i] = null;
        }

        System.out.println("Mengunjungi URL: " + url);
    }

    private void back() {
        if (currentPosition > 0) {
            currentPosition--;
            String urlSebelumnya = riwayat[currentPosition];

            System.out.println("Kembali ke URL: " + urlSebelumnya);
        } else {
            System.out.println("Tidak ada URL sebelumnya");
        }
    }

    private void forward() {
        if (currentPosition < maxSize - 1 && riwayat[currentPosition + 1] != null) {
            currentPosition++;
            String urlBerikutnya = riwayat[currentPosition];

            System.out.println("Maju ke URL: " + urlBerikutnya);
        } else {
            System.out.println("Tidak ada URL berikutnya");
        }
    }

    private String getCurrentURL() {
        if (currentPosition >= 0) {
            return riwayat[currentPosition];
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        StackURL navigasi = new StackURL(10); // Set max size
        navigasi.start();
    }
}
