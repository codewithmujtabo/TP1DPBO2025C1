#include <iostream>
#include <string>
#include <list>

using namespace std;

class Petshop {
    private:
        int id;
        string name;
        string category;
        int price;

    public:
        Petshop() {
            this->id = '-';
            this->name = "";
            this->category = "";
            this->price = '-';
        }

        // **Parameterized Constructor**
        Petshop(int id, string name, string category, int price) {
            this->id = id;
            this->name = name;
            this->category = category;
            this->price = price;
        }

        

        // Get id
        int get_id() {
            return this->id;
        }

        // Set id
        void set_id(int id) {
            this->id = id;
        }

        // Get name
        string get_name() {
            return this->name;
        }

        // Set name
        void set_name(string name) {
            this->name = name;
        }

        // Get category
        string get_category() {
            return this->category;
        }

        // Set category
        void set_category(string category) {
            this->category = category;
        }

        // Get price
        int get_price() {
            return this->price;
        }

        // Set price
        void set_price(int price) {
            this->price = price;
        }
        
        // Fungsi untuk MENAMPILKAN data
        static void menampilkan(list<Petshop>& llist) {
            int maxLenId = 2, maxLenName = 4, maxLenCategory = 8, maxLenPrice = 5;
            for (auto it = llist.begin(); it != llist.end(); it++) {
                if (maxLenId < to_string(it->id).length()) {
                    maxLenId = to_string(it->id).length();
                }
                if (maxLenName < it->name.length()) {
                    maxLenName = it->name.length();
                }
                if (maxLenCategory < it->category.length()) {
                    maxLenCategory = it->category.length();
                }
                if (maxLenPrice < to_string(it->price).length()) {
                    maxLenPrice = to_string(it->price).length();
                }
            }

            for(int i = 0; i < maxLenId + maxLenName + maxLenCategory + maxLenPrice + 9; i++) {
                cout << "-";
            }

            cout << "\n|ID";
            for(int i = 0; i < maxLenId - 1; i++) {
                cout << " ";
            }
            cout << "|Name";
            for(int i = 0; i < maxLenName - 3; i++) {
                cout << " ";
            }
            cout << "|Category";
            for(int i = 0; i < maxLenCategory - 7; i++) {
                cout << " ";
            }
            cout << "|Price";
            for(int i = 0; i < maxLenPrice - 4; i++) {
                cout << " ";
            }
            cout << "|\n";

            for(auto it = llist.begin(); it != llist.end(); it++) {
                // cout << it->id << ". " << it->name << " - "  << it->category << " - " << it->price << '\n';
                for(int i = 0; i < maxLenId + maxLenName + maxLenCategory + maxLenPrice + 9; i++) {
                    cout << "-";
                }
                cout << "\n|" << it->id;
                for(int i = 0; i < maxLenId - to_string(it->id).length() + 1; i++) {
                    cout << " ";
                }
                cout << "|" << it->name;
                for(int i = 0; i < maxLenName - it->name.length() + 1; i++) {
                    cout << " ";
                }
                cout << "|" << it->category;
                for(int i = 0; i < maxLenCategory - it->category.length() + 1; i++) {
                    cout << " ";
                }
                cout << "|" << it->price;
                for(int i = 0; i < maxLenPrice - to_string(it->price).length() + 1; i++) {
                    cout << " ";
                }
                cout << "|\n";
            }
        }

        // Fungsi untuk MENAMBAHKAN data
        static void menambahkan(list<Petshop>& llist) {
            int id, price;
            string name, category;

            cout << "Masukkan ID, Nama, Kategori, Harga:\n";
            cin >> id >> name >> category >> price;

            llist.push_back(Petshop(id, name, category, price));
            cout << "Data berhasil ditambahkan!\n";
        }

        // Fungsi untuk MENGUBAH data
        static void mengubah(list<Petshop>& llist, int target_id) {
            for(auto& item : llist) {
                if(item.id == target_id) {
                    int price;
                    string name, category;
                    cout << "Masukkan Nama, Kategori, Harga baru untuk item tersebut: \n";
                    cin >> name >> category >> price;

                    item.name = name;
                    item.category = category;
                    item.price = price;

                    cout << "Data berhasil diubah1\n";
                    return;
                }
            }
            cout << "ID tidak ditemukan!\n";
        }

        // Fungsi untuk MENGHAPUS data
        static void menghapus(list<Petshop>& llist, int target_id) {
            for(auto it = llist.begin(); it != llist.end(); it++) {
                if(it->id == target_id) {
                    cout << "Menghapus data dengan ID" << it->id << "...\n";
                    llist.erase(it);
                    cout << "Data berhasil dihapus!\n";
                    return;
                }
            }
            cout << "ID tidak ditemukan!\n";
        }

        // Fungsi untuk MENCARI data
        static void mencari(list<Petshop>& llist, int target_id) {
            for(auto& item : llist) {
                if(item.id == target_id) {
                    cout << "Data ditemukan:\n";
                    item.menampilkan(llist);
                    return;
                }
            }
            cout << "Data tidak ditemukan!\n";
        }

        // **Destructor**
        ~Petshop() {
        }
};