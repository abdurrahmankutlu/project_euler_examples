
/**
 * Project Euler Solutions naming of the functions is constructed as shortcut for ( Project Euler Solution ) as pes
 * and number of the solution follows 001 and if there is alternative version it is also added with a "v" character
 * following by the alternate version number
 */
class ProjectEulerSolutions {

    private long startTime,endTime;

    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     *
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */
    void pes001v01() {
        startTime = System.nanoTime();

        long finalResult =  calculateSumWithinInterval(3,999,3)+
                            calculateSumWithinInterval(5,995,5)-
                            calculateSumWithinInterval(15,990,15);

        endTime = System.nanoTime();
        System.out.println("Sum of multiples of 3 or 5 below 1000: "+finalResult + "Calculater within nanoseconds: "+(endTime-startTime));
    }
    private long calculateSumWithinInterval(int firstNumber, int lastNumber, int step) {
        int numberCount= ((lastNumber-firstNumber)/step)+1;
        return  (firstNumber + lastNumber)* numberCount/2;
    }


    /** Alternate Version !!!
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     *
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
        System.out.println("Sum of multiples of 3 or 5 below 1000: "+finalResult + "Calculater within nanoseconds: "+(endTime-startTime));
    }

    ProjectEulerSolutions(){
        System.out.println("Welcome to solutions for the Project Euler, Written By Abdurrahman Kutlu & Emre Yavuz");
    }
}
