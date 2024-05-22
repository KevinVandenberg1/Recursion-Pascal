// Name: Kevin Vandenberg
// Class: CS 145
// Assignment: Lab 6 Recursion
// Notice: I have used ChatGPT and w3schools as a reference
//
// Extra Credit:
//  - For pascal's triangle, I made it more efficient by using an arrayList alongside recursion. (Line 19, 46-52)
//  - For pascal's triangle, I used only recursion without iteration (Lines 24 -85)
//  
//  - I implemented Least Common Denominator as well (Lines 88 - 122)
//
//  - I used package to make this into a single file (Line 16)


package Lab6;
import java.util.ArrayList;
class Recursion {
    private int maxRow;
    private ArrayList<Integer> pascalRow = new ArrayList<Integer>();


    // Sets up fields for the class when the method is ran
    public void pascalTriangle(int row) {
        pascalRow.clear(); // Clears the arrayList if it has values
        this.maxRow = row;
        pascalTriangleRecursion(row);
        System.out.println("____________________________");
    } 
    
    //Recursively iterates through each row
    // Starts from bottom, to top
    private void pascalTriangleRecursion(int row) {
        if (row == 1) {
            pascalRow.add(1);
            printSpaces(maxRow-row);
            printNumber(1);
            System.out.println();
        } else {
            pascalTriangleRecursion(row-1);
            updateArray(row);
            printSpaces(maxRow-row);
            printNums(row, 0);
            System.out.println();
        }
    }

    // Updates the array of values each time a new row is called
    private void updateArray(int row) {
        if (pascalRow.size() <= 1) {
            pascalRow.add(1);
        } else {
            updateHelper(pascalRow.size()-1);
            pascalRow.add(1);
        }
    }
    
    // Helper method to updating the array, navigates each position in a given row
    private void updateHelper(int pos) {
        if(pos > 0) {
            int sum = pascalRow.get(pos) + pascalRow.get(pos-1);
            pascalRow.set(pos, sum);
            updateHelper(pos-1);
        }
    }

    // Prints the numbers recursively in a given row
    private void printNums(int row, int pos) {
        if (pos != (pascalRow.size())) {
            printNumber(pascalRow.get(pos));
            printNums(row, pos+1);
        }
    }

    // Prints a given number when passed it
    private void printNumber(int num) {
        System.out.print("|" + num + "| ");
    }

    // Prints the spaces
    private void printSpaces(int row) {
        System.out.print("  ");
        if (row > 0) {
            printSpaces(row-1);
        }
        
    }


    // Finds the least common denominator for two fractions
    public int  leastCommonDenominator(int aNum, int a, int bNum, int b) {
        int aDiv = largestCommonDivsor(a, aNum, a);
        int bDiv = largestCommonDivsor(b, bNum, b);
        a /= aDiv; aNum /= aDiv;
        b /= bDiv; bNum /= bDiv;
        return leastCommonMultiple(a, b, a);

    }

    // Finds the largest common divisor for two numbers, a and b
    // Returns the largest common divisor.
    // c must be A
    private int largestCommonDivsor(int a, int b, int c) {
        if (a < b) {
            return largestCommonDivsor(b,a,b);
        } else if (((a % c) != 0) ||((b%c) != 0)) {
            return largestCommonDivsor(a,b,c-1);
        } else {
            return c;
        }
    }

    // returns the least common multiple of two denominators.
    // A and B are each different denominators, c is either a or b
    private int leastCommonMultiple(int a, int b, int c) {
        if (a < b) {
            return leastCommonMultiple(b, a, b);
        } 
        if ((((c % a) != 0) || ((c % b) != 0)) && c!= 1) {
            return leastCommonMultiple(a, b, c-1);
        } else if (c==1) {
            return a * b;
        } else {
            return c;
        }
    }
}



// The test class
public class TestClass {
    public static void main(String[] args) {
        Recursion test = new Recursion();

        test.pascalTriangle(2);
        test.pascalTriangle(3);
        test.pascalTriangle(4);
        test.pascalTriangle(5);
        test.pascalTriangle(6);
        System.out.print("LCD of 4/6 and 6/71 is");
        System.out.println(test.leastCommonDenominator(4, 6, 6, 71));
        System.out.print("LCD of 9/153 and 7/126 is");
        System.out.println(test.leastCommonDenominator(9, 153, 7, 126));
    }
}