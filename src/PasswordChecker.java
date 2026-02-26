import java.io.*;
import java.util.*;

public class PasswordChecker {

    public static String checkStrength(String password){

        int score = 0;

        if(password.length() >= 8) score++;
        if(password.matches(".*[A-Z].*")) score++;
        if(password.matches(".*[0-9].*")) score++;
        if(password.matches(".*[!@#$%^&*()].*")) score++;

        if(score <=1) return "WEAK PASSWORD";
        else if(score ==2 || score==3) return "MEDIUM";
        else return "STRONG";
    }

    public static boolean isBreached(String password) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("breached.txt"));
        String line;

        while((line = br.readLine()) != null){
            if(line.equals(password))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a password to check for strength:");
        String pass = sc.nextLine();

        System.out.println("Password Strength: " + checkStrength(pass));

        if(isBreached(pass))
            System.out.println("Caution!!!! This password is BREACHED!");
        else
            System.out.println("Safe password ----- :)");
    }
}
