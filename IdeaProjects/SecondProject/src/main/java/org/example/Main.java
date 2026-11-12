/* package org.example;

public class Main {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int sum = a + b;

        System.out.println("Sum = " + sum);
    }
}
*/

/* package org.example;
public class Main {
    public static void main(String args[]) {
        int marks1 = 80;
        int marks2 = 70;
        int marks3 = 90;
        int marks4 = 60;
        int marks5 =  100;

        int average = marks1 + marks2 + marks3 + marks4 + marks5 / 5;
        System.out.println(average);
    }
} */

package org.example;
public class Main {

    public static void main(String[] args) {

        int number = 7;

        int remainder = number % 2;

        // Intentional logical error
        if (remainder == 1) {
            System.out.println("Number is Even");
        } else {
            System.out.println("Number is Odd");
        }
    }
}