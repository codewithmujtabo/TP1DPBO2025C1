from Petshop import Petshop

pets = []
while True:
    print("\n📌 Pilih Opsi:")
    print("1. Menampilkan data")
    print("2. Menambahkan data baru")
    print("3. Mengubah data berdasarkan ID")
    print("4. Mencari data berdasarkan ID")
    print("5. Menghapus data berdasarkan ID")
    print("6. Keluar dari program")

    choice = int(input("Pilihan: "))
    if choice == 1:
        Petshop.menampilkan(pets)
    elif choice == 2:
        pet = Petshop()
        pet.menambahkan()
        pets.append(pet)
        print("Data berhasil ditambahkan!")
    elif choice == 3:
        target_id = int(input("Masukkan ID yang ingin diubah: "))
        Petshop.mengubah(pets, target_id)
    elif choice == 4:
        target_id = int(input("Masukkan ID yang ingin dicari: "))
        Petshop.mencari(pets, target_id)
    elif choice == 5:
        target_id = int(input("Masukkan ID yang ingin dihapus: "))
        Petshop.menghapus(pets, target_id)
    elif choice == 6:
        print("Keluar dari program.")
        break
    else:
        print("❌ Pilihan tidak valid, coba lagi!")