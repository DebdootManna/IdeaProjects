public class HashTableWithLinearProbing {
    
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

    // HashTable class to store student records using Linear Probing for collision handling
    static class HashTable {
        private Student[] table;  // Array to hold student records
        private int size;         // Size of the hash table
        
        // Constructor to initialize the hash table with a given size
        public HashTable(int size) {
            this.size = size;
            this.table = new Student[size];
        }

        // Hash function to map student ID to an index
        private int hash(int id) {
            return id % size;   // Simple hash function (modulo operation)
        }

        // Insert a student record into the hash table
        public void insert(Student student) {
            int index = hash(student.id);  // Get the index using the hash function

            // Use linear probing to find the next available slot
            while (table[index] != null) {
                index = (index + 1) % size;  // Linear probing: move to the next slot
            }

            // Insert the student at the available index
            table[index] = student;
        }

        // Search for a student record by their ID
        public Student search(int id) {
            int index = hash(id);

            // Use linear probing to search the table
            while (table[index] != null) {
                if (table[index].id == id) {
                    return table[index];  // Return the student if found
                }
                index = (index + 1) % size;  // Linear probing: move to the next slot
            }

            // If the student is not found
            return null;
        }

        // Delete a student record by their ID
        public void delete(int id) {
            int index = hash(id);

            // Use linear probing to find and delete the student
            while (table[index] != null) {
                if (table[index].id == id) {
                    table[index] = null;  // Remove the student by setting the slot to null
                    return;
                }
                index = (index + 1) % size;  // Linear probing: move to the next slot
            }

            System.out.println("Student not found with ID: " + id);
        }

        // Display all student records in the hash table
        public void display() {
            for (int i = 0; i < size; i++) {
                if (table[i] != null) {
                    System.out.println("Index " + i + ": " + table[i]);
                }
            }
        }
    }

    // Main method to test the HashTable with Linear Probing
    public static void main(String[] args) {
        // Create a hash table with a capacity of 10 students
        HashTable hashTable = new HashTable(10);

        // Insert some student records
        hashTable.insert(new Student(1, "Alice"));
        hashTable.insert(new Student(2, "Bob"));
        hashTable.insert(new Student(3, "Charlie"));

        // Display all records after insertion
        System.out.println("All student records (using linear probing):");
        hashTable.display();

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

        // Display all records again after deletion
        System.out.println("\nAll student records after deletion (using linear probing):");
        hashTable.display();
    }
}
