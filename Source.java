import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class SalaryData {
    String name;
    int daysInMonth;
    double salary;

    public SalaryData(String name, int daysInMonth, double salary)
    {
        this.name = name;
        this.daysInMonth = daysInMonth;
        this.salary = salary;
    }
}

class Validator 
{
    public static String validateSalaryData(SalaryData s) throws Exception
    {
        if (s.daysInMonth != 28  && s.daysInMonth != 30 && s.daysInMonth != 31)
        {
            throw new InvalidDayException("Invalid Days");
        }

        if (s.salary < 0 || s.salary > 1000000)
        {
            throw new InvalidSalaryException("Invalid Salary");
        }

        return "Valid Data";
    }

    public double getToTalSalary(SalaryData s)
    {
        double ans = 0.0;
        try
        {
            Validator.validateSalaryData(s);
            ans = s.daysInMonth * s.salary;
        }
        catch (Exception ex){

        }
        return ans;
    }
}

class InvalidDayException extends Exception{
    public InvalidDayException(String str)
    {
        super(str);
    }
}

class InvalidSalaryException extends Exception{
    public InvalidSalaryException(String str)
    {
        super(str);
    }
}

public class Source
{
    public static void main(String[] args) throws Exception{
        SalaryData s = new SalaryData("Steve", 30, 10000);
        Validator val = new Validator();
        String ans = val.validateSalaryData(s);
        double sal = val.getToTalSalary(s);
        System.out.println("ans = " + ans);
        System.out.println("sal = " + sal);
    }
}

