package Util;

import Model.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface StudentImplementation {
    public int insertData(Student s);

    public int updateData(Student s);

    public int deleteData(Student s);
   public ArrayList<Student> display();

}