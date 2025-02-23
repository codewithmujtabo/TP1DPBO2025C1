#include "Petshop.cpp"
using namespace std;

int main() {

    Petshop pet;
    int choice, target_id;
    list<Petshop> llist;
    while(true) {
        cout << "1. Menampilkan data yang tersedia\n";
        cout << "2. Menambahkan data baru\n";
        cout << "3. Mengubah data yang sudah ada\n";
        cout << "4. Menghapus data yang diinginkan\n";
        cout << "5. Mencari data yang diinginkan berdasarkan ID\n";
        cout << "6. Keluar\n";

        cin >> choice;

        switch (choice) {
            case 1:
                cout << "\nDaftar Petshop:\n";
                Petshop::menampilkan(llist);
                cout << '\n';
                break;
            case 2:
                Petshop::menambahkan(llist);
                break;
            case 3:
                cout << "Masukkan ID yang ingin diubah: ";
                cin >> target_id;
                Petshop::mengubah(llist, target_id);
                break;
            case 4:
                cout << "Masukkan ID yang ingin dihapus: ";
                cin >> target_id;
                Petshop::menghapus(llist, target_id);
                break;
            case 5:
                cout << "Masukkan ID yang ingin dicari: ";
                cin >> target_id;
                Petshop::mencari(llist, target_id);
                break;
            case 6:
                cout << "Keluar dari program!\n";
                return 0;
            default:
                cout << "Pilihan tidak valid!\n";
        }
    }

    // cout << '\n' << "Automatic output : " << '\n';
    // cout << '\n' << pet.get_id() << "." << pet.get_name() << "-" << pet.get_category() << "-" << pet.get_price() << '\n';
    // pet.menampilkan();
    return 0;
}