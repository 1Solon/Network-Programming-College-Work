public class MathThreads{
    public static void main(String[] args) throws InterruptedException {
        // Generate threads
        MathSin sin = new MathSin(5);
        Thread threadsin = new Thread(sin);

        MathCos cos = new MathCos(5);
        Thread threadcos = new Thread(cos);

        MathTan tan = new MathTan(5);
        Thread threadtan = new Thread(tan);

        // Start threads
        threadsin.start();
        threadcos.start();
        threadtan.start();

        // Join threads, catches 
        threadsin.join();
        threadcos.join();
        threadtan.join();

        // performs calculation
        double finished = sin.getOuput() + cos.getOuput() + tan.getOuput();
        System.out.print("The solution to sin(5) + cos(5) + tan(5) is " + finished);


    }
}
