import java.util.Scanner;

public class StudentGradeCalculator
{
    public static void main (String[] args)
    {
        String studentname;
        int MATH,OOP,DSA,PA, Total;
        double Avgpercentage;
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Student Name:");
         studentname=sc.nextLine();


         System.out.println("Enter Marks Obtained in Math is:");
         MATH=sc.nextInt();

         System.out.println("Enter Marks Obtained in Object Oriented Programming Langauge is:");
         OOP=sc.nextInt();

         System.out.println("Enter Marks Obtained in Data Structure And Algorithm is:");
         DSA=sc.nextInt();

         System.out.println("Enter Marks Obtained in Processor Architecture is:");
         PA=sc.nextInt();

         Total=MATH+DSA+OOP+PA;
         Avgpercentage=Total/4;

         System.out.println("Student Name:"+studentname);
         System.out.println("Math marks:"+MATH);
         System.out.println("OOP marks:"+OOP);
         System.out.println("DSA marks:"+DSA);
         System.out.println("PA marks:"+PA);
         System.out.println("Total marks:"+Total);
         System.out.println("Average marks:"+Avgpercentage);


         if(Avgpercentage>=60)
         {
            System.out.println("Grade:A");
         }
         else if(Avgpercentage>=50 && Avgpercentage<=60)
         {
            System.out.println("Grade:B");
         }
         else if(Avgpercentage>=30 && Avgpercentage<=50)
         {
            System.out.println("Grade:C");
         }
         else 
         {
            System.out.println("Grade:FAIL");
         }

         sc.close();
       
    }  
}

       











         
         





    
