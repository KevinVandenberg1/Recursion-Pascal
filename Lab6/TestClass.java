
package Lab6;
import java.util.ArrayList;
class Recursion {
    private int maxRow;
    private ArrayList<Integer> pascalRow = new ArrayList<Integer>();


    public void pascalTriangle(int row) {
        this.maxRow = row;
        pascalTriangleRecursion(row);
    } 
    
    private void pascalTriangleRecursion(int row) {
        if (row == 1) {
            pascalRow.add(1);
            printSpaces(maxRow-row);
            printNumber(row, 1);
            System.out.println();
        } else {
            pascalTriangleRecursion(row-1);
            updateArray(row);
            printSpaces(maxRow-row);
            printNums(row, 0);
            System.out.println();
        }
    }

    private void updateArray(int row) {
        if (pascalRow.size() <= 1) {
            pascalRow.add(1);
        } else {
            updateHelper(pascalRow.size()-1);
            pascalRow.add(1);
        }
    }
    private void updateHelper(int pos) {
        if(pos > 0) {
            int sum = pascalRow.get(pos) + pascalRow.get(pos-1);
            pascalRow.set(pos, sum);
            updateHelper(pos-1);
        }
    }

    private void printNums(int row, int pos) {
        if (pos != (pascalRow.size())) {
            printNumber(row, pascalRow.get(pos));
            printNums(row, pos+1);
        }
    }

    private void printNumber(int row, int num) {
        System.out.print("|" + num + "| ");
    }
    private void printSpaces(int row) {
        System.out.print("  ");
        if (row > 0) {
            printSpaces(row-1);
        }
        
    }


    public void leastCommonDenominator(int a, int aNum, int b, int bNum) {
    }
}

public class TestClass {
    public static void main(String[] args) {
        Recursion test = new Recursion();

        test.pascalTriangle(15);
    }
}