class OptimizedSolution {

    void CalculateSums3or5Opt() {

        long finalResult =   calculatesum(3,15000,3)+
                            calculatesum(5,15000,5)-
                            calculatesum(15,15000,15);

        System.out.println(finalResult);
    }


    void CalculateSums3or5nonOpt() {
        System.out.println(calculatesumLoop());
    }

    private long calculatesum(int firstNumber, int lastNumber, int step) {
        int numberCount= ((lastNumber-firstNumber)/step)+1;
        return  (firstNumber + lastNumber)* numberCount/2;
    }


    private long calculatesumLoop() {
        long sum = 0;
        for (int i = 0; i < 15000; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        return sum;
    }
}
