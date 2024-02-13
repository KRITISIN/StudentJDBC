package Util;

import Model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

public class MainApp {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
       operation();
    }
    private static void operation(){
        boolean status =true;
        while(status) {
            System.out.println("-------------------");
            System.out.println("1 : Save Data     ");
            System.out.println("2 : Update Data   ");
            System.out.println("3 : Delete Data   ");
            System.out.println("4 : Display Data  ");
            System.out.println("5 : Exit");
            System.out.println("ENTER YOUR CHOICE ");
            System.out.println("---------------------");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    saveData();
                    break;
                case 2:
                    updateData();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    System.out.println("Thnk you for Visiting");
                    status=false;
                    break;
                default:
                    System.out.println("Default Choice");
                    break;
            }
        }
    }
    private static void updateData(){
        System.out.println("Enter Roll Number");
        int roll=sc.nextInt();
        System.out.println("Enter Percentage");
        double per=sc.nextDouble();

        Student s1=new Student();
        s1.setStudentRollNumber(roll);
        s1.setStudentPercentage(per);

        StudentImplementation si=new DAO();
        int result=si.updateData(s1);
        if(result>0){
            System.out.println("Data Updataed Successfully");
        }else{
            System.out.println("Something went wrong");
        }

    }
    private static void saveData(){
        System.out.println("ENTER YOUR FULL NAME");
        sc.nextLine();
        String fullName=sc.nextLine().toUpperCase();
        System.out.println("ENTER YOUR ADDRESS");

        String address=sc.nextLine().toUpperCase();
        System.out.println("ENTER YOUR PERCENTAGE");
        double percentage=sc.nextDouble();

        Student s1=new Student();
        s1.setStudentName(fullName);
        s1.setStudentAddress(address);
        s1.setStudentPercentage(percentage);

        StudentImplementation dao=new DAO();

        int result=dao.insertData(s1);
        if(result>0){
            System.out.println("Data Inserted Successfully");
        }else{
            System.out.println("Something went wrong");
        }

    }
    private static void delete(){
        System.out.println("Enter Student Roll no");
        int roll=sc.nextInt();

        Student s1=new Student();
        s1.setStudentRollNumber(roll);

        StudentImplementation s=new DAO();
        int result=s.deleteData(s1);
        if(result>0){
            System.out.println("Data Inserted Successfully");
        }else{
            System.out.println("Something went wrong");
        }
    }
    private static void display(){
        StudentImplementation si=new DAO(); //upcasting
        ArrayList<Student> studentData=si.display();
        System.out.println("ROLL NO\tNAME\t\t\t\t\tADDRESS\tPERCENTAGE");

        for(Student s:studentData){

               System.out.println(s.getStudentRollNumber()+"\t\t"+s.getStudentName()+"\t\t"+s.getStudentAddress()+"\t\t"+s.getStudentPercentage());
        }
    }
}
