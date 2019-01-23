import java.time.Instant;

public class Main {

    public static void main(String[] args){
        OptimizedSolution newSolution = new OptimizedSolution();

        long startTime = System.nanoTime();
        newSolution.CalculateSums3or5Opt();
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);

        long startTime2 = System.nanoTime();
        newSolution.CalculateSums3or5nonOpt();
        long endTime2 = System.nanoTime();
        System.out.println(endTime2-startTime2);
    }
}
