import java.util.*; 
public class task3b { 
    public static void main(String[] args){ 
        Scanner scan = new Scanner(System.in); 
        String a = scan.next(); 
        String res = ""; 
        for(int i=0;i<a.length();i++){ 
            char ch = a.charAt(i); 
            res = res + ch; 
        } 
        if(a.equals(res)){ 
            System.out.println("palindrome"); 
        } 
        else{ 
            System.out.println("not a palindrome"); 
        } 
    } 
} 
