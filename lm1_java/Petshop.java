import java.util.ArrayList;
import java.util.Scanner;

public class Petshop {
    private int id;
    private String name;
    private String category;
    private int price;

    public Petshop() {
        this.id = 0;
        this.name = "";
        this.category = "";
        this.price = 0;
    }

    public Petshop(int id, String name, String category, int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getter & Setter
    // Get ID
    public int getId() {
        return this.id;
    }

    // Set ID
    public void setId(int id) {
        this.id = id;
    }

    // Get name
    public String getName() {
        return this.name;
    }

    // Set name
    public void setName(String name) {
        this.name = name;
    }

    // Get category
    public String getCategory() {
        return this.category;
    }

    // Set categpry
    public void setCategory(String category) {
        this.category = category;
    }

    // Get price
    public int getPrice() {
        return this.price;
    }

    // Set price
    public void setPrice(int price) {
        this.price = price;
    }

    // Fungsi untuk menampilkan data
    static void menampilkan(ArrayList<Petshop> list) {
        if (list.isEmpty()) {
            System.out.println("Daftar Petshop kosong.");
            return;
        }
    
        System.out.println("Daftar Petshop:");
    
        // Find the maximum width of each column
        int maxIdLength = 2; // At least "ID" length
        int maxNameLength = 4; // At least "Nama" length
        int maxCategoryLength = 8; // At least "Kategori" length
        int maxPriceLength = 5; // At least "Harga" length
    
        for (Petshop pet : list) {
            maxIdLength = Math.max(maxIdLength, String.valueOf(pet.getId()).length());
            maxNameLength = Math.max(maxNameLength, pet.getName().length());
            maxCategoryLength = Math.max(maxCategoryLength, pet.getCategory().length());
            maxPriceLength = Math.max(maxPriceLength, String.valueOf(pet.getPrice()).length());
        }
    
        // Print header with dynamic spacing
        System.out.printf("| %-"+maxIdLength+"s | %-"+maxNameLength+"s | %-"+maxCategoryLength+"s | %-"+maxPriceLength+"s |\n",
                          "ID", "Nama", "Kategori", "Harga");
    
        // Print separator line
        System.out.println("-".repeat(maxIdLength + maxNameLength + maxCategoryLength + maxPriceLength + 10));
    
        // Print each pet's data with alignment
        for (Petshop pet : list) {
            System.out.printf("| %-"+maxIdLength+"d | %-"+maxNameLength+"s | %-"+maxCategoryLength+"s | %-"+maxPriceLength+"d |\n",
                              pet.getId(), pet.getName(), pet.getCategory(), pet.getPrice());
        }
    }
    
    

    // Fungsi untuk menambahkan data baru
    static void menambahkan(ArrayList<Petshop> list) {
        int i, n = 0, id, price;
        String name, category;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Masukkan ID, nama, kategori, dan harga hewan peliharaan:");
            id = sc.nextInt();
            name = sc.next();
            category = sc.next();
            price = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Salah Input!");
            sc.next();
            return;
        }

        Petshop temp = new Petshop(id, name, category, price);

        list.add(temp);
    }

    // Fungsi untuk mengubah data
    static void mengubah(ArrayList<Petshop> list, int target_id) {
        String name, category;
        int price;
        Scanner sc = new Scanner(System.in);
        for (Petshop pet : list) {
            if(pet.getId() == target_id) {
                System.out.println("Masukkan Nama, Kategori, Harga baru untuk hewan peliharaan tersebut:");
                name = sc.next();
                category = sc.next();
                price = sc.nextInt();

                pet.setName(name);
                pet.setCategory(category);
                pet.setPrice(price);
                System.out.println("Data berhasil diubah!");
                return;
            }
        }
        System.out.println("ID tidak ditemukan!");
    }

    // Fungsi untuk mencari data
    static void mencari(ArrayList<Petshop> list, int target_id) {
        for (Petshop pet : list) {
            if (pet.getId() == target_id) {
                System.out.println("Data ditemukan:");
                
                // Print header with dynamic spacing
                System.out.print("|ID");
                for (int i = 0; i < 5 - "ID".length(); i++) System.out.print(" ");
                System.out.print("|Nama");
                for (int i = 0; i < 15 - "Nama".length(); i++) System.out.print(" ");
                System.out.print("|Kategori");
                for (int i = 0; i < 10 - "Kategori".length(); i++) System.out.print(" ");
                System.out.print("|Harga");
                for (int i = 0; i < 8 - "Harga".length(); i++) System.out.print(" ");
                System.out.println("|");
    
                // Print separator
                System.out.println("----------------------------------------------");
    
                // Print pet data with spacing
                System.out.print("|" + pet.getId());
                for (int i = 0; i < 5 - String.valueOf(pet.getId()).length(); i++) System.out.print(" ");
                System.out.print("|" + pet.getName());
                for (int i = 0; i < 15 - pet.getName().length(); i++) System.out.print(" ");
                System.out.print("|" + pet.getCategory());
                for (int i = 0; i < 10 - pet.getCategory().length(); i++) System.out.print(" ");
                System.out.print("|" + pet.getPrice());
                for (int i = 0; i < 8 - String.valueOf(pet.getPrice()).length(); i++) System.out.print(" ");
                System.out.println("|");
            }
        }
    }
    

    // Fungsi untuk menghapus data
    static void menghapus(ArrayList<Petshop> list, int target_id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == target_id) {
                list.remove(i); 
                System.out.println("Data berhasil dihapus!");
                return;
            }
        }
        System.out.println("ID tidak ditemukan!");
    }
}
