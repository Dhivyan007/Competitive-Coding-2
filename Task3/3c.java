import java.util.Scanner; 
public class task3c { 
    public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in); 
        System.out.println("Enter password:"); 
        String password = scan.nextLine(); 
        int errors = 0; 
        if (password.length() < 8) { 
            System.out.println("Password must be at least 8 characters long."); 
            errors++; 
        } 
        if (!password.matches(".*[@#$%^&+=!].*")) { 
            System.out.println("Password must contain at least one special 
character (@, #, $, etc.)."); 
            errors++; 
        } 
        if (errors == 0) { 
            System.out.println("Password is valid."); 
        } else { 
            System.out.println("Password is invalid. Please ensure it meets all 
criteria."); 
        } 
        scan.close(); 
    } }
