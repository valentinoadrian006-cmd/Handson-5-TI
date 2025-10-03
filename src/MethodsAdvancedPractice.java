import java.util.Arrays;

public class MethodsAdvancedPractice {

    // Static variable untuk demonstrasi
    private static int counter = 0;

    // Instance variable untuk demonstrasi
    private String instanceName;

    // Constructor
    public MethodsAdvancedPractice(String name) {
        this.instanceName = name;
        counter++;
    }

    public static void main(String[] args) {
        System.out.println("=== METHOD SIGNATURE DAN DECLARATION ===");
        System.out.println("calculate(int,int): " + calculate(5, 10));
        System.out.println("calculate(double,double): " + calculate(2.5, 3.5));
        System.out.println("calculate(int,int,int): " + calculate(1, 2, 3));
        System.out.println("calculate(String,String): " + calculate("Hello ", "World"));

        System.out.println("\n=== METHOD OVERLOADING ===");
        print(42);
        print(3.14);
        print("Java");
        print(new int[]{1, 2, 3, 4});

        System.out.println("\n=== STATIC VS INSTANCE METHODS ===");
        incrementCounter();
        System.out.println("Counter: " + getCounter());

        MethodsAdvancedPractice obj = new MethodsAdvancedPractice("Objek1");
        obj.displayInfo();

        System.out.println("\n=== PASS BY VALUE - PRIMITIVES ===");
        int originalNumber = 10;
        System.out.println("Before: " + originalNumber);
        modifyPrimitive(originalNumber);
        System.out.println("After: " + originalNumber);

        System.out.println("\n=== PASS BY VALUE OF REFERENCE - OBJECTS ===");
        int[] originalArray = {1, 2, 3, 4, 5};
        System.out.println("Before: " + Arrays.toString(originalArray));
        modifyArray(originalArray);
        System.out.println("After: " + Arrays.toString(originalArray));

        int[] anotherArray = {10, 20, 30};
        System.out.println("Before: " + Arrays.toString(anotherArray));
        reassignArray(anotherArray);
        System.out.println("After: " + Arrays.toString(anotherArray));

        System.out.println("\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Sorted copy: " + Arrays.toString(sortArrayCopy(numbers)));
        System.out.println("Original: " + Arrays.toString(numbers));
        System.out.println("Stats: " + Arrays.toString(getArrayStats(numbers)));
        System.out.println("Merged: " + Arrays.toString(mergeArrays(numbers, new int[]{100, 200})));

        System.out.println("\n=== VARIABLE ARGUMENTS (VARARGS) ===");
        System.out.println("Sum: " + sum(1, 2, 3, 4, 5));
        printInfo("Scores", 80, 90, 100);

        System.out.println("\n=== METHOD CHAINING ===");
        Calculator calc = new Calculator(10);
        double result = calc.add(5).multiply(2).subtract(4).getResult();
        System.out.println("Calculator result: " + result);

        System.out.println("\n=== RECURSIVE METHODS ===");
        System.out.println("Factorial 5: " + factorial(5));
        System.out.println("Fibonacci 7: " + fibonacci(7));
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Binary search 4: " + binarySearchRecursive(arr, 4, 0, arr.length - 1));

        System.out.println("\n=== UTILITY STATIC METHODS ===");
        System.out.println("Power: " + MathUtils.power(2, 5));
        System.out.println("Is prime 17: " + MathUtils.isPrime(17));
        System.out.println("GCD(48,18): " + MathUtils.gcd(48, 18));
        System.out.println("Reverse string: " + StringUtils.reverse("hello"));
        System.out.println("Is palindrome 'madam': " + StringUtils.isPalindrome("madam"));
        System.out.println("Word count: " + StringUtils.countWords("Java is fun"));
        ArrayUtils.printMatrix(new int[][]{{1, 2}, {3, 4}});
        System.out.println("Find duplicates: " + Arrays.toString(ArrayUtils.findDuplicates(new int[]{1, 2, 2, 3, 4, 4})));
        System.out.println("Arrays equal: " + ArrayUtils.areEqual(new int[]{1, 2}, new int[]{1, 2}));
    }

    // ===== METHOD OVERLOADING EXAMPLES =====
    public static int calculate(int a, int b) {
        return a + b;
    }
    public static double calculate(double a, double b) {
        return a + b;
    }
    public static int calculate(int a, int b, int c) {
        return a + b + c;
    }
    public static String calculate(String a, String b) {
        return a + b;
    }
    public static void print(int value) {
        System.out.println("Int: " + value);
    }
    public static void print(double value) {
        System.out.println("Double: " + value);
    }
    public static void print(String value) {
        System.out.println("String: " + value);
    }
    public static void print(int[] array) {
        System.out.println("Array: " + Arrays.toString(array));
    }

    // ===== STATIC VS INSTANCE METHODS =====
    public static int getCounter() {
        return counter;
    }
    public static void incrementCounter() {
        counter++;
    }
    public String getInstanceName() {
        return instanceName;
    }
    public void setInstanceName(String name) {
        this.instanceName = name;
    }
    public void displayInfo() {
        System.out.println("Instance name: " + instanceName + ", Counter: " + counter);
    }

    // ===== PASS BY VALUE DEMONSTRATIONS =====
    public static void modifyPrimitive(int number) {
        number = number + 10;
        System.out.println("Inside modifyPrimitive: " + number);
    }
    public static void modifyArray(int[] array) {
        if (array.length > 0) array[0] = 999;
    }
    public static void reassignArray(int[] array) {
        array = new int[]{7, 8, 9};
    }

    // ===== ARRAY METHODS =====
    public static int[] sortArrayCopy(int[] original) {
        int[] copy = Arrays.copyOf(original, original.length);
        Arrays.sort(copy);
        return copy;
    }
    public static double[] getArrayStats(int[] array) {
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        double avg = Arrays.stream(array).average().getAsDouble();
        return new double[]{min, max, avg};
    }
    public static int[] mergeArrays(int[] array1, int[] array2) {
        int[] merged = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, merged, array1.length, array2.length);
        return merged;
    }

    // ===== VARIABLE ARGUMENTS (VARARGS) =====
    public static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }
    public static void printInfo(String title, int... values) {
        System.out.println(title + ": " + Arrays.toString(values));
    }

    // ===== RECURSIVE METHODS =====
    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (array[mid] == target) return mid;
        if (array[mid] > target) return binarySearchRecursive(array, target, left, mid - 1);
        return binarySearchRecursive(array, target, mid + 1, right);
    }

    // ===== UTILITY CLASSES (INNER STATIC CLASSES) =====
    public static class MathUtils {
        public static double power(double base, int exponent) {
            if (exponent == 0) return 1;
            return base * power(base, exponent - 1);
        }
        public static boolean isPrime(int number) {
            if (number <= 1) return false;
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) return false;
            }
            return true;
        }
        public static int gcd(int a, int b) {
            return (b == 0) ? a : gcd(b, a % b);
        }
    }

    public static class StringUtils {
        public static String reverse(String str) {
            return new StringBuilder(str).reverse().toString();
        }
        public static boolean isPalindrome(String str) {
            return str.equals(reverse(str));
        }
        public static int countWords(String str) {
            return str.trim().split("\\s+").length;
        }
    }

    public static class ArrayUtils {
        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }
        }
        public static int[] findDuplicates(int[] array) {
            return Arrays.stream(array)
                    .distinct()
                    .filter(n -> Arrays.stream(array).filter(x -> x == n).count() > 1)
                    .toArray();
        }
        public static boolean areEqual(int[] array1, int[] array2) {
            return Arrays.equals(array1, array2);
        }
    }

    // ===== METHOD CHAINING EXAMPLE =====
    public static class Calculator {
        private double value;
        public Calculator(double initial) {
            this.value = initial;
        }
        public Calculator add(double n) {
            this.value += n;
            return this;
        }
        public Calculator multiply(double n) {
            this.value *= n;
            return this;
        }
        public Calculator subtract(double n) {
            this.value -= n;
            return this;
        }
        public double getResult() {
            return value;
        }
    }
}
