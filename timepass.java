import jdk.swing.interop.SwingInterOpUtils;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class timepass {

    public static void main(String[] args) {
        Scanner scn =new  Scanner(System.in);
//        String a = scn.nextLine();
//        String b = scn.nextLine();
//        a=a.toLowerCase();
//        b=b.toLowerCase();
//
//
//        if (a.length()==b.length()) {
//            char[] a1 = a.toCharArray();
//            char[] b1 = b.toCharArray();
//
//            Arrays.sort(a1);
//            Arrays.sort(b1);
//
//            boolean result = Arrays.equals(a1, b1);
//
//            if (result) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        else {
//            return false;
//        }
//
//
//        int n = scn.nextInt();
//        int [] arr = new int [n];
//        int sum,count;
//        count=0;
//        for (int i=0;i<n;i++){
//            arr[i]=scn.nextInt();
//        }
//
//        for (int i=0;i<n;i++){
//            for (int j=i;j<n;j++){
//                sum=0;
//                for (int k=i;k<=j;k++){
//                    sum+=arr[k];
//                }
//                if(sum<0){
//                    count++;
//                }
//            }
//
//        }
//        System.out.println(count);

//        int n = scn.nextInt();
//
//        for (int i=1;i<=n;i++){
//            for (int j=n-i;j>=1;j--){
//                System.out.print(" ");
//            }
//            for(int k=1;k<=i;k++){
//                System.out.print("#");
//            }
//            System.out.println();

//            int t = scn.nextInt();
//            for (int i=0;i<t;i++) {
//                int n = scn.nextInt();
//                if (n < 4) {
//                    System.out.println("MILD");
//                } else if (n >= 4 && n < 7) {
//                    System.out.println("MEDIUM");
//                } else if (n >= 7) {
//                    System.out.println("HOT");
//                }
//            }


//            int t = scn.nextInt();
//            for (int i=0;i<t;i++){
//                int a=scn.nextInt();
//                int b=scn.nextInt();
//                System.out.println(b-a);
//            }


//            int t = scn.nextInt();
//            int [] arr;
//            int count=0;
//
//            for (int i=0;i<t;i++){
//                int items = scn.nextInt();
//                int min_fresh = scn.nextInt();
//                for (int j=0;j<items;j++){
//                    int a = scn.nextInt();
//                    if (a>=min_fresh){
//                        count++;
//                    }
//                }
//                arr = new int [count];
//                for (int k=0;k<count;k++)
//
//




//        String [] operations = {"--X","X++","X++"};
//        int X=0;
//
//        for (int i=0;i<operations.length;i++){
//            if(operations[i]=="++X" || operations[i]=="X++"){
//                ++X;
//            }
//            else if(operations[i]=="--X" || operations[i]=="X--"){
//                --X;
//            }
//        }
//
//        System.out.println(Integer.MIN_VALUE);

        int size, i, j, temp;
        int arr[] = new int[50];
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        size = scan.nextInt();

        System.out.print("Enter Array Elements : ");
        for(i=0; i<size; i++)
        {
            arr[i] = scan.nextInt();
        }

        System.out.print("Sorting Array using Selection Sort Technique..\n");
        for(i=0; i<size-1; i++)
        {
            for(j=i+1; j<size; j++)
            {
                if(arr[i] > arr[j])
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.print("Now the Array after Sorting is :\n");
        for(i=0; i<size; i++)
        {
            System.out.print(arr[i]+ "  ");
        }











        }












    }

