package Util;

import ConnectionHelper.ConnectionHelper;
import Model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO implements StudentImplementation {
   private static
   Connection conn= ConnectionHelper.createConnection();
   private static String insertDataQuery="insert into student values(?,?,?,?)";
   private static String updateQuery="update student set student_per=? where student_rollno=?";
   private static String deleteQuery ="delete from student where student_rollno=?";
   private static String displayQuery="select * from student";

    @Override
    public int deleteData(Student s) {
        try {
            PreparedStatement pstmt=conn.prepareStatement(deleteQuery);
            pstmt.setInt(1,s.getStudentRollNumber());
            int count=pstmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Student> display() {

            ArrayList<Student> studentList=new ArrayList<>();
            try {
                PreparedStatement pstmt=conn.prepareStatement(displayQuery);
                ResultSet rs=pstmt.executeQuery();
                Student s1=null;
                while(rs.next()){
                    s1=new Student();

                    s1.setStudentRollNumber(rs.getInt(1));//first fetching the data from result set and
                    s1.setStudentName(rs.getString(2));
                    s1.setStudentAddress(rs.getString(3));
                    s1.setStudentPercentage(rs.getDouble(4));
                    studentList.add(s1);
                }
                return studentList;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }



    @Override
    public int updateData(Student s) {
        try {
            PreparedStatement pstmt=conn.prepareStatement(updateQuery);
            pstmt.setDouble(1,s.getStudentPercentage());
            pstmt.setInt(2,s.getStudentRollNumber());
           int count= pstmt.executeUpdate();
           return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
   public int insertData(Student s){
       try {
          PreparedStatement pstmt= conn.prepareStatement(insertDataQuery);
          pstmt.setInt(1,0);
          pstmt.setString(2,s.getStudentName());
          pstmt.setString(3,s.getStudentAddress());
          pstmt.setDouble(4,s.getStudentPercentage());
          int count=pstmt.executeUpdate();
          return count;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }


   }

}
