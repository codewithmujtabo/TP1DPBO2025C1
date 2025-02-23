class Petshop:

    __id = 0
    __name = ""
    __category = ""
    __price = 0

    def __init__(self, id = 0, name = "", category = "", price = 0):
        self.__id = id
        self.__name = name
        self.__category = category
        self.__price = price

    # Getters
    def get_id(self):
        return self.__id
    
    def get_name(self):
        return self.__name
    
    def get_category(self):
        return self.__category
    
    def get_price(self):
        return self.__price
    
    # Setters
    def set_id(self, id):
        self.__id = id
    
    def set_name(self, name):
        self.__name = name
    
    def set_category(self, category):
        self.__category = category
    
    def set_price(self, price):
        self.__price = price

    pets = []

    # Fungsi untuk menampilkan data
    def menampilkan(pets):
        if not pets:
            print("❌ Data masih kosong!")
            return

        # Find max length for each field
        max_id = max(len(str(pet.get_id())) for pet in pets)
        max_name = max(len(pet.get_name()) for pet in pets)
        max_category = max(len(pet.get_category()) for pet in pets)
        max_price = max(len(str(pet.get_price())) for pet in pets)

        # Ensure minimum width for better formatting
        max_id = max(max_id, 2)
        max_name = max(max_name, 4)
        max_category = max(max_category, 8)
        max_price = max(max_price, 5)

        
        for i in range(max_id + max_name + max_category + max_price + 13):
            print("-", end = "")
        print()

        # Print table header
        print("| ID ".ljust(max_id + 2), "| Name ".ljust(max_name + 2), "| Category ".ljust(max_category + 2), "| Price ".ljust(max_price + 1),"|")
        
        for i in range(max_id + max_name + max_category + max_price + 13):
            print("-", end = "")
        print()

        # Print pet data
        for pet in pets:
            print("|",str(pet.get_id()).ljust(max_id), 
                  "|",pet.get_name().ljust(max_name), 
                  "|",pet.get_category().ljust(max_category), 
                  "|",str(pet.get_price()).ljust(max_price), "|")
        
        for i in range(max_id + max_name + max_category + max_price + 13):
            print("-", end = "")
        print()

    # Fungsi untuk menambahkan data baru
    def menambahkan(self):
        print("Masukkan ID, nama, kategori, dan harga hewan peliharaan:")
        
        self.__id = int(input())
        self.__name = str(input())
        self.__category = str(input())
        self.__price = int(input())

    # Fungsi untuk mengubah data
    def mengubah(pets, target_id):
        for pet in pets:
            if pet.get_id() == target_id:
                print("Masukkan Nama, Kategori, Harga baru untuk hewan peliharaan tersebut:")
                pet.set_name(str(input()))
                pet.set_category(str(input()))
                pet.set_price(int(input()))
                print("✅ Data berhasil diubah!")
                return
        
        print("❌ Data tidak ditemukan!")

    # Fungsi untuk mencari data
    def mencari(pets, target_id):
        for pet in pets:
            # Find max length for each field
            max_id = max(len(str(pet.get_id())) for pet in pets)
            max_name = max(len(pet.get_name()) for pet in pets)
            max_category = max(len(pet.get_category()) for pet in pets)
            max_price = max(len(str(pet.get_price())) for pet in pets)

            # Ensure minimum width for better formatting
            max_id = max(max_id, 2)
            max_name = max(max_name, 4)
            max_category = max(max_category, 8)
            max_price = max(max_price, 5)
            if pet.get_id() == target_id:
                print("Data ditemukan!")
                for i in range(max_id + max_name + max_category + max_price + 13):
                    print("-", end = "")
                print()

                # Print table header
                print("| ID ".ljust(max_id + 2), "| Name ".ljust(max_name + 2), "| Category ".ljust(max_category + 2), "| Price ".ljust(max_price + 2),"|")
                
                for i in range(max_id + max_name + max_category + max_price + 13):
                    print("-", end = "")
                print()

                print("|",str(pet.get_id()).ljust(max_id), 
                  "|",pet.get_name().ljust(max_name), 
                  "|",pet.get_category().ljust(max_category), 
                  "|",str(pet.get_price()).ljust(max_price), "|")
                
                for i in range(max_id + max_name + max_category + max_price + 13):
                    print("-", end = "")
                print()

                return
        print("❌ Data tidak ditemukan!")

    # Fungsi untuk menghapus data
    def menghapus(pets, target_id):
        for pet in pets:
            if pet.get_id() == target_id:
                pets.remove(pet)
                print("✅ Data berhasil dihapus!")
                return
        print("❌ Data tidak ditemukan!")
        