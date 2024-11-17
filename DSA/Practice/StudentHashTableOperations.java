import java.util.LinkedList;

public class StudentHashTableOperations {

    // Student class to store information about a student
    static class Student {
        int id;
        String name;

        // Constructor for Student
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // String representation of Student
        @Override
        public String toString() {
            return "Student ID: " + id + ", Name: " + name;
        }
    }

    // HashTable class to store student records using collision handling
    static class HashTable {
        private Student[] table;              // Array for linear probing
        private LinkedList<Student>[] chainTable; // Array for separate chaining
        private int size;                     // Size of the hash table
        private boolean useSeparateChaining;   // Flag to decide the method of collision handling

        // Constructor to initialize the hash table
        public HashTable(int size, boolean useSeparateChaining) {
            this.size = size;
            this.useSeparateChaining = useSeparateChaining;

            if (useSeparateChaining) {
                chainTable = new LinkedList[size];
                for (int i = 0; i < size; i++) {
                    chainTable[i] = new LinkedList<>();
                }
            } else {
                table = new Student[size];
            }
        }

        // Hash function to map student ID to an index
        private int hash(int id) {
            return id % size;   // Simple hash function (modulo operation)
        }

        // Insert a student record into the hash table
        public void insert(Student student) {
            int index = hash(student.id);  // Get the index using the hash function

            if (useSeparateChaining) {
                // Separate Chaining: add the student to the linked list at the computed index
                chainTable[index].add(student);
            } else {
                // Linear Probing: find the next available slot
                while (table[index] != null) {
                    index = (index + 1) % size;  // Linear probing: move to the next slot
                }
                table[index] = student;  // Insert the student at the available index
            }
        }

        // Search for a student record by their ID
        public Student search(int id) {
            int index = hash(id);

            if (useSeparateChaining) {
                // Separate Chaining: search the linked list at the computed index
                for (Student student : chainTable[index]) {
                    if (student.id == id) {
                        return student;
                    }
                }
            } else {
                // Linear Probing: search the table linearly
                while (table[index] != null) {
                    if (table[index].id == id) {
                        return table[index];  // Return the student if found
                    }
                    index = (index + 1) % size;  // Linear probing: move to the next slot
                }
            }
            return null;  // Student not found
        }

        // Delete a student record by their ID
        public void delete(int id) {
            int index = hash(id);

            if (useSeparateChaining) {
                // Separate Chaining: remove the student from the linked list
                chainTable[index].removeIf(student -> student.id == id);
            } else {
                // Linear Probing: find and remove the student
                while (table[index] != null) {
                    if (table[index].id == id) {
                        table[index] = null;  // Remove the student by setting the slot to null
                        return;
                    }
                    index = (index + 1) % size;  // Linear probing: move to the next slot
                }
                System.out.println("Student not found with ID: " + id);
            }
        }

        // Display all student records in the hash table
        public void display() {
            if (useSeparateChaining) {
                // Display all students using separate chaining (linked lists)
                for (int i = 0; i < size; i++) {
                    if (!chainTable[i].isEmpty()) {
                        System.out.println("Index " + i + ": " + chainTable[i]);
                    }
                }
            } else {
                // Display all students using linear probing (array)
                for (int i = 0; i < size; i++) {
                    if (table[i] != null) {
                        System.out.println("Index " + i + ": " + table[i]);
                    }
                }
            }
        }
    }

    // Main method to test the hash table operations
    public static void main(String[] args) {
        // Create a hash table with a capacity of 10 students, using linear probing
        HashTable hashTable = new HashTable(10, false);
        System.out.println("Using Linear Probing for collision handling\n");

        // Insert some student records
        System.out.println("Inserting students into the hash table:");
        hashTable.insert(new Student(1, "Alice"));
        hashTable.insert(new Student(2, "Bob"));
        hashTable.insert(new Student(3, "Charlie"));
        hashTable.display();  // Display the state after insertion

        // Search for a student with ID 2
        System.out.println("\nSearching for student with ID 2:");
        Student student = hashTable.search(2);
        if (student != null) {
            System.out.println("Found: " + student);
        } else {
            System.out.println("Student not found.");
        }

        // Delete a student with ID 1
        System.out.println("\nDeleting student with ID 1:");
        hashTable.delete(1);
        hashTable.display();  // Display the state after deletion

        // Create a hash table with a capacity of 10 students, using separate chaining
        HashTable chainHashTable = new HashTable(10, true);
        System.out.println("\nUsing Separate Chaining for collision handling\n");

        // Insert some student records using separate chaining
        System.out.println("Inserting students into the hash table:");
        chainHashTable.insert(new Student(1, "Alice"));
        chainHashTable.insert(new Student(2, "Bob"));
        chainHashTable.insert(new Student(3, "Charlie"));
        chainHashTable.insert(new Student(2, "Bob2"));  // Duplicate student for chaining
        chainHashTable.display();  // Display the state after insertion

        // Search for a student with ID 2
        System.out.println("\nSearching for student with ID 2:");
        student = chainHashTable.search(2);
        if (student != null) {
            System.out.println("Found: " + student);
        } else {
            System.out.println("Student not found.");
        }

        // Delete a student with ID 1
        System.out.println("\nDeleting student with ID 1:");
        chainHashTable.delete(1);
        chainHashTable.display();  // Display the state after deletion
    }
}
