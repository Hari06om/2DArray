import java.util.*;

public class array2d {
    
    public static void input(int arr[][],Scanner sc ){
        int n = arr.length;
        int m = arr[0].length;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void print(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of the rows and columns ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        System.out.println("Enter the elements of the array ");
        input(arr,sc);
        System.out.println("The elements of the array are ");
        print(arr);
        sc.close();
    }
}
