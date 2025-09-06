import java.util.*;
class task1b{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int n1 = n/2;
        int n2 = n1/3;
        int n3 = n2/5;
        if(n3==1){
            System.out.println(n+"is an ugly number");

        }
        else{
            System.out.println("not ugly a number");
        }
    }
