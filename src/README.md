**Nama:** **[Adrian valentino]**
**NIM:** **[2481042]**
**Kelas:** **Teknik Informatika**
**Mata kuliah:** **Pemrograman Berorientasi Objek**


1.Overloading & Signature

Ada banyak versi method calculate() dan print(). Bedanya cuma di tipe sama jumlah parameternya. Jadi Java bisa bedain method meskipun namanya sama → ini namanya overloading.

2. Static vs Instance

counter itu static, milik kelas, dipakai bareng semua object.

instanceName itu punya masing-masing object.

Static bisa dipanggil tanpa bikin object, tapi kalau instance butuh bikin object dulu.

3. Pass by Value

Java tuh selalu pass by value:

Kalau primitive (int, double, dll) → nilainya gak berubah di luar method.

Kalau object/array → isi dalamnya bisa berubah, tapi referensinya gak bisa diganti dari luar.

4. Array & Varargs

Ada latihan sorting array, nyari min/max/avg, nge-merge dua array.
Juga ada varargs (sum(int... numbers)) biar bisa lempar jumlah parameter bebas ke method.

5. Fitur Lanjutan

Recursion buat factorial, fibonacci, binary search.

Method chaining (contoh di Calculator → bisa tulis calc.add(5).multiply(2).subtract(1) langsung berantai).

Utility class (MathUtils, StringUtils, ArrayUtils) → ngumpulin method-method berguna biar gampang dipake lagi.