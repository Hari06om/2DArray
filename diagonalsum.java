import  java.util.*;
public class diagonalsum {

    public static void input(int arr[][],int n,int m,Scanner sc ){  
        for(int i =0;i<n;i++){
            for(int j =0;j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void  display(int arr[][],int n, int m){
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }

    }

    public static void diagonal(int arr[][] , int n, int m){
        int sum =0;
        

            for(int i=0 ;i<n;i++){  
                sum += arr[i][i];
                sum += arr[i][n-1-i];
                
            }
        System.out.print("The sum of the dialgonal is: " +sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of row and colmns: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][]  = new int[n][m];
        System.out.print("Enter the element of matrix: ");
        input(arr,n,m ,sc );
        display(arr,n,m);
        diagonal(arr,n,m);
    }    
}
