import java.util.*;

public class SearchAElementArray {
    
    public static boolean search(int arr[][],int x){
        int n=arr.length;
        int m = arr[0].length;
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(arr[i][j]== x){
                    System.out.print("Element found at cell (" + i+","+j+")");
                    return true;
                }
            }
        }
        System.out.print("Element not found");
        return false;
    }

    public static void input(int arr[][],Scanner sc ){
       int n = arr.length;
       int m = arr[0].length;
       for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }
    public static void print(int arr[][],Scanner sc ){
        int n = arr.length;
        int m = arr[0].length;
        for(int i =0;i<n;i++){
           for(int j=0;j<m;j++){
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
        print(arr,sc);
        System.out.print("Enter the element to be searched ");
        int x = sc.nextInt();
        search(arr,x);
    }
}