package model;

public class Patient {
    private String id, name, gender, diagnosis;
    private int age;

    // Constructor
    public Patient(String id, String name, int age, String gender, String diagnosis) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.diagnosis = diagnosis;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    // CSV serialization
    public String toCSV() {
        return id + "," + name + "," + age + "," + gender + "," + diagnosis;
    }

    // CSV deserialization
    public static Patient fromCSV(String line) {
        String[] parts = line.split(",");
        return new Patient(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
    }
}