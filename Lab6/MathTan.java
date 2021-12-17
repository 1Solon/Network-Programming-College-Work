public class MathTan extends Thread{
    private volatile double input;
    private volatile double output; 

    public MathTan(double input){
        this.input = input;
    }

    @Override
    public void run(){
        output = Math.tan(input);
    }   

    public double getOuput(){
        return output;
    }
}
