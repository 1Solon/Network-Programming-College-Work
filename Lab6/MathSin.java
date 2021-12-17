public class MathSin extends Thread {
    private volatile double input;
    private volatile double output; 

    public MathSin(double input){
        this.input = input;
    }

    @Override
    public void run(){
        output = Math.sin(input);
    }   

    public double getOuput(){
        return output;
    }
}
