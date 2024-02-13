package Model;

public class Student {
    public int getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(int studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public double getStudentPercentage() {
        return studentPercentage;
    }

    public void setStudentPercentage(double studentPercentage) {
        this.studentPercentage = studentPercentage;
    }

    private  int studentRollNumber;
    private String studentName;
    private String studentAddress;
    private double studentPercentage;
}
