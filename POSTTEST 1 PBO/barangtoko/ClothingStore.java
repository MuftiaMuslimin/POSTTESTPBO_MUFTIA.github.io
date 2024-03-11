package barangtoko;

import java.util.ArrayList;
import java.util.Scanner;

public class ClothingStore {
    public static void main(String[] args) {
        ArrayList<ClothingItem> clothingItems = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Toko Pakaian 'FASHION MM' ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tampilkan Item");
            System.out.println("3. Update Item");
            System.out.println("4. Hapus Item");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama item: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan harga item (Rp): ");
                    double price = scanner.nextDouble();
                    clothingItems.add(new ClothingItem(name, price));
                    System.out.println("Item berhasil ditambahkan.");
                    break;
                    case 2:
                    if (clothingItems.isEmpty()) {
                        System.out.println("Tidak ada item.");
                    } else {
                        System.out.println("Daftar Item:");
                        int index = 1;
                        for (ClothingItem item : clothingItems) {
                            System.out.println(index + ". " + item.getName());
                            System.out.println(" Harga: Rp" + String.format("%.0f", item.getPrice()));
                            index++;
                        }
                    }
                    break;
                    case 3:
                    if (clothingItems.isEmpty()) {
                        System.out.println("Tidak ada item untuk diupdate.");
                    } else {
                        System.out.print("Pilih nomor item yang akan diupdate (1-" + clothingItems.size() + "): ");
                        int updateIndex = scanner.nextInt();
                        scanner.nextLine(); // consume newline character
                        if (updateIndex >= 1 && updateIndex <= clothingItems.size()) {
                            System.out.print("Masukkan nama baru: ");
                            String newName = scanner.nextLine();
                            System.out.print("Masukkan harga baru (Rp): ");
                            double newPrice = scanner.nextDouble();
                            clothingItems.get(updateIndex - 1).setName(newName);
                            clothingItems.get(updateIndex - 1).setPrice(newPrice);
                            System.out.println("Item berhasil diupdate.");
                        } else {
                            System.out.println("Nomor item tidak valid.");
                        }
                    }
                    break;
                case 4:
                    if (clothingItems.isEmpty()) {
                        System.out.println("Tidak ada item untuk dihapus.");
                    } else {
                        System.out.print("Pilih nomor item yang akan dihapus (1-" + clothingItems.size() + "): ");
                        int deleteIndex = scanner.nextInt();
                        scanner.nextLine(); // consume newline character
                        if (deleteIndex >= 1 && deleteIndex <= clothingItems.size()) {
                            clothingItems.remove(deleteIndex - 1);
                            System.out.println("Item berhasil dihapus.");
                        } else {
                            System.out.println("Nomor item tidak valid.");
                        }
                    }
                    break;
                    case 5:
                    System.out.println("Terima kasih sudah berkunjung!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

class ClothingItem {
    private String name;
    private double price;

    public ClothingItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}