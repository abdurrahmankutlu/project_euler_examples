import java.math.BigInteger;
import java.util.*;

/**
 * Project Euler Solutions naming of the functions is constructed as shortcut for ( Project Euler Solution ) as pes
 * and number of the solution follows 001 and if there is alternative version it is also added with a "v" character
 * following by the alternate version number
 */
class ProjectEulerSolutions {

    private long startTime, endTime;


    ProjectEulerSolutions() {
        System.out.println("Welcome to solutions for the Project Euler, Written By Abdurrahman Kutlu & Emre Yavuz");
    }

    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * <p>
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */
    void pes001v01() {
        startTime = System.nanoTime();

        long finalResult = calculateSumWithinInterval(3, 999, 3) +
                calculateSumWithinInterval(5, 995, 5) -
                calculateSumWithinInterval(15, 990, 15);

        endTime = System.nanoTime();

        System.out.println("Sum of multiples of 3 or 5 below 1000: " + finalResult + "Calculater within nanoseconds: " + (endTime - startTime));
    }

    private long calculateSumWithinInterval(int firstNumber, int lastNumber, int step) {
        int numberCount = ((lastNumber - firstNumber) / step) + 1;
        return (firstNumber + lastNumber) * numberCount / 2;
    }


    /**
     * Alternate Version !!!
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * <p>
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */
    void pes001v02() {
        startTime = System.nanoTime();

        long finalResult = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                finalResult += i;
        }

        endTime = System.nanoTime();
        System.out.println("Sum of multiples of 3 or 5 below 1000: " + finalResult + "Calculater within nanoseconds: " + (endTime - startTime));
    }

    /**
     * Written by Abdurrahman Kutlu
     */
    void pes005v01() {
        startTime = System.nanoTime();
        long commonMultiplier = 1;
        for (int i = 2; i <= 40; i++) {
            commonMultiplier = lowestCommonMultiplier(commonMultiplier,i);
        }

        endTime = System.nanoTime();
        System.out.println("Lowest Common Multiplier for the numbers between 1-20: " + commonMultiplier + " Calculater within nanoseconds: " + (endTime - startTime));
    }

    private long lowestCommonMultiplier(long a, int b) {
        for (int i = 1; i <= b; i++) {
            if (i * a % b == 0)
                return (i * a);
        }
        return a*b;
    }

    /**
     * Written by Emre Yavuz
     */
    void pes005v02(){
        startTime = System.nanoTime();

        int[] initial = new int[40];
        long result = 1;
        for (int i = 0; i < 40; i++) {
            initial[i] = i + 1;
        }

        for (int i = 0; i < initial.length; i++) {
            if (initial[i] == 1) continue;
            result *= initial[i];
            for (int j = i + 1; j < initial.length; j++) {
                if (initial[j] % initial[i] == 0) {
                    initial[j] /= initial[i];
                }
            }
        }

        endTime = System.nanoTime();
        System.out.println("Lowest Common Multiplier for the numbers between 1-20: " + result + " Calculater within nanoseconds: " + (endTime - startTime));
    }

    /**
     * Written by Burak Doğan Akyıldız
     */
    void pes005v03() {
        startTime = System.nanoTime();
        int baseLimit = 40;
        long[] baseNumbers = new long[baseLimit];
        long divider = 2;
        long result = 1;
        boolean isAllOne = true;
        boolean isAnyDividable = false;
        boolean isAnyDivided = false;


        for (int i = 0; i < baseNumbers.length; i++) {
            baseNumbers[i] = i + 1;
        }


        while (true) {

            isAllOne = true;
            isAnyDividable = false;
            isAnyDivided = false;

            for (int i = 0; i < baseNumbers.length; i++) {
                if (baseNumbers[i] % divider == 0) {
                    baseNumbers[i] = baseNumbers[i] / divider;
                    if (!isAnyDividable) {
                        isAnyDividable = baseNumbers[i] % divider == 0;
                    }
                    isAnyDivided = true;
                }

                if (baseNumbers[i] != 1) {
                    isAllOne = false;
                }
            }

            if (isAnyDivided) {
                result *= divider;
            }

            if (!isAnyDividable) {
                divider++;
            }

            if (isAllOne) {
                break;
            }
        }

        endTime = System.nanoTime();
        System.out.println("Lowest Common Multiplier for the numbers between 1-20: " + result + " Calculater within nanoseconds: " + (endTime - startTime));
    }

    /**
     * Written by Abdurrahman Kutlu
     */
    void pes005v04() {
        startTime = System.nanoTime();
        long commonMultiplier = 1;
        for (int i = 2; i <= 40; i++) {
            commonMultiplier = commonMultiplier*i/gcd(commonMultiplier,i);
        }
        endTime = System.nanoTime();
        System.out.println("Lowest Common Multiplier for the numbers between 1-20: " + commonMultiplier + " Calculater within nanoseconds: " + (endTime - startTime));

    }

    private long gcd(long a, int b) {
        long totalgcd=1;

        for(int i = 1; i <= a && i <= b; ++i)
        {
            if(a % i==0 && b % i==0)
                totalgcd = i;
        }
        return totalgcd;
    }
}
