public class Main {
    public static <E extends Comparable<E>> void sort(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                E temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] integers = {64, 34, 25, 12, 22, 11, 90};
        String[] strings = {"Zebra", "Apple", "Orange", "Banana"};
        Double[] doubles = {3.14, 1.41, 2.71, 1.73};

        System.out.println("Before sorting:");
        System.out.print("Integers: ");
        printArray(integers);
        System.out.print("Strings: ");
        printArray(strings);
        System.out.print("Doubles: ");
        printArray(doubles);

        sort(integers);
        sort(strings);
        sort(doubles);

        System.out.println("\nAfter sorting:");
        System.out.print("Integers: ");
        printArray(integers);
        System.out.print("Strings: ");
        printArray(strings);
        System.out.print("Doubles: ");
        printArray(doubles);

        // Custom class example
        Student[] students = {
                new Student("John", 85),
                new Student("Alice", 92),
                new Student("Bob", 78),
                new Student("Carol", 95)
        };

        System.out.print("\nStudents before sorting: ");
        printArray(students);
        sort(students);
        System.out.print("Students after sorting: ");
        printArray(students);

        System.out.println("\nThis Practical is made by 23CS043 Debdoot Manna");
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.score, other.score);
    }

    @Override
    public String toString() {
        return name + "(" + score + ")";
    }
}