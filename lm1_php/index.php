<?php
require_once 'Petshop.php';

// Initial array of 5 pets
$pets = [
    new Petshop(1, 'Bella', 'Cat', 1000000, 'Bella.jpg'),
    new Petshop(2, 'Bobby', 'Dog', 1200000, 'Bobby.jpg'),
    new Petshop(3, 'Coco', 'Bird', 900000, 'Coco.jpg'),
    new Petshop(4, 'Goldie', 'Fish', 800000, 'Goldie.jpg'),
    new Petshop(5, 'Leo', 'Lion', 700000, 'Leo.jpg'),
];

// Function to display pets in a table
function menampilkan($pets, $title) {
    echo "<h2>$title</h2>";
    echo "<table border='1' cellpadding='5' style='border-collapse: collapse; margin-bottom: 30px;'>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Image</th>
            </tr>";
    
    foreach ($pets as $pet) {
        echo "<tr>
                <td>" . $pet->getId() . "</td>
                <td>" . $pet->getName() . "</td>
                <td>" . $pet->getCategory() . "</td>
                <td>Rp " . $pet->getPrice() . "</td>
                <td><img src='images/" . $pet->getName() . ".jpg' alt='" . $pet->getName() . "' style='width: 100px; height: 100px; object-fit: cover;'></td>
              </tr>";
    }
    echo "</table>";
}

// Function to add new pets
function menambahkan(&$pets, $newPets) {
    foreach ($newPets as $pet) {
        $pets[] = $pet;
    }
}

// Function to search pets
function mencari($pets, $keyword) {
    return array_filter($pets, function($pet) use ($keyword) {
        return (stripos($pet->getName(), $keyword) !== false) || 
               (stripos($pet->getCategory(), $keyword) !== false);
    });
}

// Function to edit pets
function mengubah(&$pets, $id, $newName = null, $newCategory = null, $newPrice = null) {
    foreach ($pets as &$pet) {
        if ($pet->getId() == $id) {
            if ($newName !== null) $pet->setName($newName);
            if ($newCategory !== null) $pet->setCategory($newCategory);
            if ($newPrice !== null) $pet->setPrice($newPrice);
            $pet->setImage($pet->getName() . '.jpg');
            break;
        }
    }
}

// Function to delete pets
function menghapus(&$pets, $ids) {
    $pets = array_filter($pets, function($pet) use ($ids) {
        return !in_array($pet->getId(), $ids);
    });
    $pets = array_values($pets); // Reindex array
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Petshop Operations Demo</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; }
        th { background-color: #f2f2f2; }
        th, td { padding: 8px; text-align: left; }
    </style>
</head>
<body>
    <h1>Petshop</h1>

    <?php
    // 1. Show initial pets
    menampilkan($pets, "List awal (5 pets)");

    // 2. Add 5 more pets
    $newPets = [
        new Petshop(6, 'Nemo', 'Fish', 850000, 'Nemo.jpg'),
        new Petshop(7, 'Polly', 'Bird', 1100000, 'Polly.jpg'),
        new Petshop(8, 'Rocky', 'Dog', 950000, 'Rocky.jpg'),
        new Petshop(9, 'Simba', 'Lion', 1050000, 'Simba.jpg'),
        new Petshop(10, 'Tommy', 'Cat', 750000, 'Tommy.jpg')
    ];
    menambahkan($pets, $newPets);
    menampilkan($pets, "Nambahkan 5 pet baru (10 pets)");

    // 3. Edit some pets
    mengubah($pets, 1, "Bella Updated", "Cat", 1500000);  // Change Bella's category and price
    mengubah($pets, 5, "King Leo", null, 2000000);        // Change Leo's name and price
    mengubah($pets, 8, null, "Husky", 3000000);           // Change Rocky's category and price
    menampilkan($pets, "Mengubah 3 pet dalam list (Bella, Leo, and Rocky)");

    // 4. Search for pets
    $searchResults = mencari($pets, "Cat");
    menampilkan($searchResults, "Hasil Pencarian 'Cat'");

    // 5. Delete 3 pets
    menghapus($pets, [2, 6, 9]); // Delete Bobby, Nemo, and Simba
    menampilkan($pets, "List setelah semua operasi (7 pets)");
    ?>

</body>
</html>