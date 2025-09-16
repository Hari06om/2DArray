import  java.util.*;

public class sprialmatrix {
        public static void input(int arr[][],Scanner sc ){
            int n = arr.length;
            int m = arr[0].length;
            for(int i =0;i<n;i++){
                for(int j =0;j<m;j++){
                    arr[i][j] = sc.nextInt();
                }

            }
        }
         public static void print(int arr[][]){
            int n =arr.length;
            int m = arr[0].length;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    System.out.print(arr[i][j]+ " ");
                }
                System.out.println();
            }
         }
         
         public static void spiral(int arr[][]) {
        int sr = 0;
        int sc = 0;
        int er = arr.length - 1;
        int ec = arr[0].length - 1;

        while (sr <= er && sc <= ec) {
            // top
            for (int i = sc; i <= ec; i++) {
                System.out.print(arr[sr][i] + " ");
            }

            // right
            for (int i = sr + 1; i <= er; i++) {
                System.out.print(arr[i][ec] + " ");
            }

            // bottom
            if (sr < er) { // ✅ extra check
                for (int i = ec - 1; i >= sc; i--) {
                    System.out.print(arr[er][i] + " ");
                }
            }

            // left
            if (sc < ec) { // ✅ extra check
                for (int i = er - 1; i > sr; i--) {
                    System.out.print(arr[i][sc] + " ");
                }
            }

            sr++;
            sc++;
            er--;
            ec--;
        }
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of the rows and columns : ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];

        System.out.println("Enter the elements of the array : ");
        input(arr,sc);
        System.out.println("The elements of the array are : ");
        print(arr);
        System.out.print("The sprial order is : ");
        spiral(arr);

    }    
}
