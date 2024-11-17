public class StudentHashTable {
    
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

    // HashTable class to store Student records
    static class HashTable {
        private Student[] table;   // Array to hold the student records
        private int size;          // Size of the hash table
        
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

            // If the slot is already occupied, use linear probing to find the next available slot
            while (table[index] != null) {
                index = (index + 1) % size;
            }

            // Insert the student at the available index
            table[index] = student;
        }

        // Search for a student record by their ID
        public Student search(int id) {
            int index = hash(id);
            
            // Use linear probing to search for the student
            while (table[index] != null) {
                if (table[index].id == id) {
                    return table[index];  // Return the student record if found
                }
                index = (index + 1) % size;
            }
            
            // If we reach here, the student was not found
            return null;
        }

        // Delete a student record by their ID
        public void delete(int id) {
            int index = hash(id);
            
            // Use linear probing to find the student and delete their record
            while (table[index] != null) {
                if (table[index].id == id) {
                    table[index] = null;  // Remove the student record from the table
                    return;
                }
                index = (index + 1) % size;
            }

            // If we reach here, the student was not found
            System.out.println("Student not found with ID: " + id);
        }

        // Display all student records in the hash table
        public void display() {
            for (int i = 0; i < size; i++) {
                if (table[i] != null) {
                    System.out.println(table[i]);  // Print the student at this index
                }
            }
        }
    }

    // Main method to test the HashTable with Student records
    public static void main(String[] args) {
        // Create a hash table with a capacity of 10 students
        HashTable hashTable = new HashTable(10);
        
        // Insert some student records
        hashTable.insert(new Student(1, "Alice"));
        hashTable.insert(new Student(2, "Bob"));
        hashTable.insert(new Student(3, "Charlie"));
        
        // Display all student records in the hash table
        System.out.println("All student records:");
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
        System.out.println("\nAll student records after deletion:");
        hashTable.display();
    }
}
