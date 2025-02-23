import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i, id, price, choice, target_id;
        String name, category;
        ArrayList<Petshop> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) { 
            System.out.println("Pilih opsi:");
            System.out.println("1. Tampilkan data");
            System.out.println("2. Tambahkan data baru");
            System.out.println("3. Mengubah data berdasarkan ID");
            System.out.println("4. Mencari data berdasarkan ID");
            System.out.println("5. Menghapus data berdasarkan ID");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan: ");
    
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    Petshop.menampilkan(list);
                    break;
                case 2:
                    Petshop.menambahkan(list);
                    break;
                case 3:
                    System.out.println("Masukkan ID pet yang mau mengubah:");
                    target_id = sc.nextInt();
                    Petshop.mengubah(list, target_id);
                    break;
                case 4:
                    System.out.println("Masukkan ID pet yang mau mencari:");
                    target_id = sc.nextInt();
                    Petshop.mencari(list, target_id);
                    return;
                case 5:
                    System.out.println("Masukkan ID pet yang mau menghapus:");
                    target_id = sc.nextInt();
                    Petshop.menghapus(list, target_id);
                    break;
                case 6:
                    System.out.println("Terima kasih! Program selesai.");
                    sc.close();
                    return;
                default:
                    System.out.println("Tidak ada pilihan seperti ini!");
                    break;
            }
        }

    }
}
