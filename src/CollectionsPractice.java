import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CollectionsPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Collections
         */

        // ===== PERBEDAAN ARRAY VS ARRAYLIST =====
        System.out.println("=== PERBEDAAN ARRAY VS ARRAYLIST ===");

        // Latihan 1
        int[] arr = new int[3]; // ukuran tetap
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        // arr[3] = 40; // ERROR karena ukuran tetap

        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(10);
        arrList.add(20);
        arrList.add(30);
        arrList.add(40);
        arrList.add(50);

        System.out.println("Array length: " + arr.length);
        System.out.println("ArrayList size: " + arrList.size());
        // Array tidak bisa dinamis, ArrayList bisa bertambah panjang

        // ===== GENERICS DASAR =====
        System.out.println("\n=== GENERICS DASAR ===");
        ArrayList raw = new ArrayList();
        raw.add("String");
        raw.add(123);
        raw.add(45.6);

        ArrayList<String> listString = new ArrayList<>();
        listString.add("Hello");
        listString.add("World");

        ArrayList<Double> listDouble = new ArrayList<>();
        listDouble.add(3.14);
        listDouble.add(2.71);

        // listString.add(123); // ERROR (type safety)

        // ===== OPERASI CRUD =====
        System.out.println("\n=== OPERASI CRUD PADA ARRAYLIST ===");
        ArrayList<String> daftarMahasiswa = new ArrayList<>();
        daftarMahasiswa.add("Alice");
        daftarMahasiswa.add("Bob");
        daftarMahasiswa.add("Charlie");
        daftarMahasiswa.add("Diana");
        daftarMahasiswa.add("Eva");

        daftarMahasiswa.add(2, "Zara");
        System.out.println("Daftar Mahasiswa: " + daftarMahasiswa);

        System.out.println("Mahasiswa pertama: " + daftarMahasiswa.get(0));
        System.out.println("Mahasiswa terakhir: " + daftarMahasiswa.get(daftarMahasiswa.size() - 1));
        System.out.println("Ada Bob? " + daftarMahasiswa.contains("Bob"));
        System.out.println("Index Diana: " + daftarMahasiswa.indexOf("Diana"));
        System.out.println("Ukuran: " + daftarMahasiswa.size());

        daftarMahasiswa.set(1, "Budi");
        System.out.println("Setelah update: " + daftarMahasiswa);

        daftarMahasiswa.remove(0);
        daftarMahasiswa.remove("Charlie");
        System.out.println("Setelah remove: " + daftarMahasiswa);
        daftarMahasiswa.clear();
        System.out.println("Kosong? " + daftarMahasiswa.isEmpty());

        // ===== ITERASI =====
        System.out.println("\n=== ITERASI ARRAYLIST ===");
        ArrayList<Integer> angka = new ArrayList<>();
        angka.add(10);
        angka.add(20);
        angka.add(30);
        angka.add(40);
        angka.add(50);

        System.out.print("For loop: ");
        for (int i = 0; i < angka.size(); i++) {
            System.out.print(angka.get(i) + " ");
        }
        System.out.println();

        System.out.print("For-each: ");
        for (int a : angka) {
            System.out.print(a + " ");
        }
        System.out.println();

        System.out.print("While loop: ");
        int i = 0;
        while (i < angka.size()) {
            System.out.print(angka.get(i) + " ");
            i++;
        }
        System.out.println();

        System.out.print("Iterator: ");
        Iterator<Integer> it = angka.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // ===== ARRAYLIST KOMPLEKS =====
        System.out.println("\n=== ARRAYLIST DENGAN TIPE DATA KOMPLEKS ===");
        ArrayList<String[]> dataMahasiswa = new ArrayList<>();
        dataMahasiswa.add(new String[]{"Alice", "123", "Informatika"});
        dataMahasiswa.add(new String[]{"Bob", "456", "Sistem Informasi"});
        dataMahasiswa.add(new String[]{"Charlie", "789", "Teknik Elektro"});

        System.out.println("Nama\tNIM\tJurusan");
        for (String[] mhs : dataMahasiswa) {
            System.out.println(mhs[0] + "\t" + mhs[1] + "\t" + mhs[2]);
        }

        // ===== UTILITY METHODS COLLECTIONS =====
        System.out.println("\n=== UTILITY METHODS COLLECTIONS ===");
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 64, 34, 25, 12, 22, 11, 90);
        System.out.println("Original: " + numbers);

        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);

        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);

        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);

        System.out.println("Max: " + Collections.max(numbers));
        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Frequency of 22: " + Collections.frequency(numbers, 22));

        // ===== SEARCHING DAN SORTING =====
        System.out.println("\n=== SEARCHING DAN SORTING ===");
        ArrayList<String> buah = new ArrayList<>();
        Collections.addAll(buah, "Apel", "Jeruk", "Mangga", "Pisang", "Anggur");

        Collections.sort(buah);
        System.out.println("Sorted buah: " + buah);

        int idx = Collections.binarySearch(buah, "Mangga");
        System.out.println("BinarySearch 'Mangga': " + idx);

        int idxLinear = linearSearch(buah, "Jeruk");
        System.out.println("LinearSearch 'Jeruk': " + idxLinear);

        // ===== ARRAYLIST 2D =====
        System.out.println("\n=== ARRAYLIST 2D ===");
        ArrayList<ArrayList<Integer>> matrix2D = new ArrayList<>();
        for (int row = 0; row < 3; row++) {
            ArrayList<Integer> baris = new ArrayList<>();
            for (int col = 0; col < row + 2; col++) {
                baris.add((row + 1) * (col + 1));
            }
            matrix2D.add(baris);
        }
        printMatrix2D(matrix2D);

        // ===== PERPUSTAKAAN SEDERHANA =====
        System.out.println("\n=== SKENARIO APLIKASI NYATA ===");
        ArrayList<String[]> daftarBuku = new ArrayList<>();
        daftarBuku.add(new String[]{"Java Basics", "Author A", "2020", "tersedia"});
        daftarBuku.add(new String[]{"Data Structures", "Author B", "2019", "tersedia"});
        daftarBuku.add(new String[]{"Algorithms", "Author C", "2021", "tersedia"});

        pinjamBuku(daftarBuku, "Java Basics");
        kembalikanBuku(daftarBuku, "Java Basics");

        String[] result = cariBuku(daftarBuku, "Algorithms");
        if (result != null) {
            System.out.println("Buku ditemukan: " + result[0] + " - " + result[3]);
        }

        System.out.println("Buku tersedia:");
        for (String[] buku : daftarBuku) {
            if (buku[3].equals("tersedia")) {
                System.out.println(buku[0]);
            }
        }
    }

    // ===== HELPER METHODS =====
    public static void printArrayList(ArrayList<?> list, String title) {
        System.out.println(title + ": " + list);
    }

    public static int linearSearch(ArrayList<String> list, String target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void printMatrix2D(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static boolean pinjamBuku(ArrayList<String[]> daftarBuku, String judul) {
        for (String[] buku : daftarBuku) {
            if (buku[0].equalsIgnoreCase(judul) && buku[3].equals("tersedia")) {
                buku[3] = "dipinjam";
                System.out.println("Berhasil meminjam: " + judul);
                return true;
            }
        }
        return false;
    }

    public static boolean kembalikanBuku(ArrayList<String[]> daftarBuku, String judul) {
        for (String[] buku : daftarBuku) {
            if (buku[0].equalsIgnoreCase(judul) && buku[3].equals("dipinjam")) {
                buku[3] = "tersedia";
                System.out.println("Berhasil mengembalikan: " + judul);
                return true;
            }
        }
        return false;
    }

    public static String[] cariBuku(ArrayList<String[]> daftarBuku, String judul) {
        for (String[] buku : daftarBuku) {
            if (buku[0].equalsIgnoreCase(judul)) {
                return buku;
            }
        }
        return null;
    }

    public static double hitungRataRata(ArrayList<Integer> values) {
        if (values.isEmpty()) return 0;
        int sum = 0;
        for (int v : values) sum += v;
        return (double) sum / values.size();
    }
}
