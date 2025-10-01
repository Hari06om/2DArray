# 2D Arrays - Complete Guide

A comprehensive collection of tutorials, examples, and practice problems for mastering 2D Arrays (matrices) in programming.



## 🎯 Introduction to 2D Arrays

2D Arrays, also known as matrices, are data structures that store elements in a grid-like format with rows and columns. They are essentially "arrays of arrays" where each element is accessed using two indices: one for the row and one for the column.

**Key Concepts:**
- A 2D array is a collection of elements arranged in rows and columns
- Syntax: `datatype[][] arrayName = new datatype[rows][columns]`
- Elements are accessed using two indices: `array[row][column]`
- Useful for representing tabular data, grids, matrices, and game boards

---

## 🌍 Real Life Examples

2D Arrays have numerous practical applications in everyday scenarios:

1. **Seating Arrangements**: Movie theater seats, classroom seating charts, airplane seats
2. **Game Boards**: Chess board, Tic-Tac-Toe, Sudoku puzzles, Minesweeper
3. **Images**: Pixel data in images (each pixel has a position in a 2D grid)
4. **Spreadsheets**: Excel sheets, Google Sheets (rows and columns of data)
5. **Maps**: City grids, geographical coordinate systems
6. **Timetables**: Class schedules, train/bus schedules
7. **Scientific Data**: Temperature readings across different locations and times
8. **Game Development**: Tile-based maps, terrain generation

---

## 📊 Representation of 2D Arrays

2D Arrays can be visualized and represented in multiple ways:

### Visual Representation
```
   Col0  Col1  Col2
Row0 [ 1  ][ 2  ][ 3  ]
Row1 [ 4  ][ 5  ][ 6  ]
Row2 [ 7  ][ 8  ][ 9  ]
```

### Memory Representation
- **Row-major order**: Elements are stored row by row in contiguous memory
- **Logical view**: We see it as a grid, but physically it's stored linearly

### Mathematical Representation
```
Matrix A (3x3):
| 1  2  3 |
| 4  5  6 |
| 7  8  9 |
```

---

## 🔨 Creation of 2D Arrays

Different methods to create and initialize 2D arrays:

### Method 1: Declaration and Size Specification
```java
int[][] matrix = new int[3][4]; // 3 rows, 4 columns (initialized with 0s)
```

### Method 2: Declaration with Initialization
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

### Method 3: Creating Jagged Arrays (different column sizes)
```java
int[][] jagged = new int[3][];
jagged[0] = new int[2];
jagged[1] = new int[3];
jagged[2] = new int[1];
```

### Method 4: Dynamic Input
```java
Scanner sc = new Scanner(System.in);
int rows = sc.nextInt();
int cols = sc.nextInt();
int[][] matrix = new int[rows][cols];

for(int i = 0; i < rows; i++) {
    for(int j = 0; j < cols; j++) {
        matrix[i][j] = sc.nextInt();
    }
}
```

---

## 💾 2D Arrays in Memory

Understanding how 2D arrays are stored in memory:

### Memory Layout
- In languages like Java, 2D arrays are actually arrays of references to 1D arrays
- Each row is stored in a separate contiguous block of memory
- The main array stores references (addresses) to these row arrays

### Example:
```
int[][] arr = new int[3][4];

Memory visualization:
arr → [ref1][ref2][ref3]
       ↓     ↓     ↓
    [0][0][0][0] [0][0][0][0] [0][0][0][0]
     Row 0         Row 1         Row 2
```

### Address Calculation
For element at position `[i][j]`:
- **Row-major**: `Base Address + (i × number_of_columns + j) × size_of_element`

---

## 🌀 Spiral Matrix

The Spiral Matrix problem involves traversing a 2D matrix in a spiral order (clockwise from outside to inside).

### Traversal Pattern:
```
1  → 2  → 3  → 4
              ↓
12 → 13→ 14   5
↑          ↓  ↓
11   16← 15   6
↑             ↓
10← 9 ← 8 ← 7
```

### Output: `1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16`

### Approach:
1. Define boundaries: `top`, `bottom`, `left`, `right`
2. Traverse in four directions: right, down, left, up
3. After each direction, update the corresponding boundary
4. Continue until all elements are visited

---

## 💻 Spiral Matrix Code

Implementation of the Spiral Matrix traversal:

```java
public static void spiralMatrix(int[][] matrix) {
    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;
    
    while(top <= bottom && left <= right) {
        // Traverse right
        for(int i = left; i <= right; i++) {
            System.out.print(matrix[top][i] + " ");
        }
        top++;
        
        // Traverse down
        for(int i = top; i <= bottom; i++) {
            System.out.print(matrix[i][right] + " ");
        }
        right--;
        
        // Traverse left
        if(top <= bottom) {
            for(int i = right; i >= left; i--) {
                System.out.print(matrix[bottom][i] + " ");
            }
            bottom--;
        }
        
        // Traverse up
        if(left <= right) {
            for(int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left] + " ");
            }
            left++;
        }
    }
}
```

---

## ➕ Diagonal Sum

Calculate the sum of elements in both diagonals of a square matrix.

### Types of Diagonals:

1. **Primary Diagonal**: Elements where row index = column index `(i == j)`
   - Example: `matrix[0][0], matrix[1][1], matrix[2][2]`

2. **Secondary Diagonal**: Elements where row index + column index = n-1 `(i + j == n-1)`
   - Example: `matrix[0][2], matrix[1][1], matrix[2][0]`

### Visual Example:
```
     Primary(↘)    Secondary(↙)
     1   2   3        1   2   3
     4   5   6        4   5   6
     7   8   9        7   8   9
```

### Code:
```java
public static int diagonalSum(int[][] matrix) {
    int sum = 0;
    int n = matrix.length;
    
    for(int i = 0; i < n; i++) {
        // Primary diagonal
        sum += matrix[i][i];
        
        // Secondary diagonal (avoid counting center twice for odd n)
        if(i != n-1-i) {
            sum += matrix[i][n-1-i];
        }
    }
    return sum;
}
```

**Time Complexity**: O(n)

---

## 🔍 Search in Sorted Matrix

Searching for a target value in a matrix that is sorted in a specific way.

### Matrix Properties:
- **Row-wise sorted**: Each row is sorted from left to right
- **Column-wise sorted**: Each column is sorted from top to bottom

### Example Matrix:
```
10  20  30  40
15  25  35  45
27  29  37  48
32  33  39  50
```

### Approach (Staircase Search):
1. Start from **top-right corner** (or bottom-left corner)
2. If target equals current element: Found!
3. If target is less: Move left (eliminate column)
4. If target is greater: Move down (eliminate row)

### Why This Works:
- Top-right element is the smallest in its row (everything to the left is smaller)
- Top-right element is the largest in its column (everything below is larger)
- This allows us to eliminate either a row or column in each step

---

## 💻 Search in Sorted Matrix Code

```java
public static boolean searchSortedMatrix(int[][] matrix, int target) {
    int row = 0;
    int col = matrix[0].length - 1; // Start from top-right corner
    
    while(row < matrix.length && col >= 0) {
        if(matrix[row][col] == target) {
            System.out.println("Found at (" + row + ", " + col + ")");
            return true;
        }
        else if(target < matrix[row][col]) {
            col--; // Move left
        }
        else {
            row++; // Move down
        }
    }
    
    System.out.println("Element not found");
    return false;
}
```

**Time Complexity**: O(m + n) where m = rows, n = columns  
**Space Complexity**: O(1)

---

## 📝 Practice Questions

Test your understanding with these problems:

### Basic Level
1. Print a 2D array in matrix format
2. Find the sum of all elements in a 2D array
3. Find the maximum and minimum element in a matrix
4. Transpose of a matrix
5. Check if a matrix is symmetric

### Intermediate Level
6. Rotate a matrix by 90 degrees clockwise
7. Set matrix zeros (if element is 0, set entire row and column to 0)
8. Print boundary elements of a matrix
9. Print matrix in wave form (column-wise zigzag)
10. Count negative numbers in a row-wise and column-wise sorted matrix

### Advanced Level
11. Search in a row-wise and column-wise sorted matrix
12. Spiral matrix traversal (clockwise and anti-clockwise)
13. Find the median in a row-wise sorted matrix
14. Rotate matrix by 180 degrees in-place
15. Count islands in a binary matrix (DFS/BFS)

---

## ✅ Solutions for Practice Questions

Complete solutions with explanations are provided in the `/solutions` directory:

- `/solutions/basic/` - Solutions for basic level problems
- `/solutions/intermediate/` - Solutions for intermediate level problems
- `/solutions/advanced/` - Solutions for advanced level problems

Each solution includes:
- Detailed explanation of the approach
- Code implementation with comments
- Time and space complexity analysis
- Example test cases

---

## 🚀 Getting Started

1. Clone this repository
```bash
git clone https://github.com/hari06om/2d-arrays.git
```

2. Navigate to specific topic folders
```bash
cd 2d-arrays/topics
```

3. Run the examples
```bash
javac FileName.java
java FileName
```

---

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

---

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

## 📧 Contact

For questions or feedback, please open an issue or reach out at this github

---

**Happy Coding! 🎉**
