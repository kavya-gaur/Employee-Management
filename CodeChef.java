
import java.util.*;

public class CodeChef {
    static int fibo(int n){
        if (n==1){
            return 1;
        }
        return n * fibo(n-1);
    }
    public static void main (String args[]){
        System.out.println(fibo(5));
    }
}






