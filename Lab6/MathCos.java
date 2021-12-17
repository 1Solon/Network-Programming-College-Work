public class MathCos extends Thread {
    private volatile double input;
    private volatile double output; 

    public MathCos(double input){
        this.input = input;
    }

    @Override
    public void run(){
        output = Math.cos(input);
    }   

    public double getOuput(){
        return output;
    }
}
