package homework3;
import java.util.Random;

public class MathRandomizer
{
    private int fNum;       //first number
    private int sNum;       //second number
    private int answer;     //answer computed by first and second
    private String operation;   //"plus, times, minus"

    public MathRandomizer() {fNum = 0; sNum = 0; operation = "";}

    public int getfNum(){return fNum;}
    public int getsNum(){return sNum;}
    public String getOperation() {return operation;}
    public void setfNum(int fNum) {this.fNum = fNum;}
    public void setsNum(int sNum) {this.sNum = sNum;}
    public void setOperation(String operation) {this.operation = operation;}

    public int makeRandomNum()  //returns a random int from 1 to 10 inclusively
    {
        Random rGen = new Random();
        return rGen.nextInt(9) + 1;
    }

    public String operationChoice()     //returns random operation
    {
        Random rGen = new Random();
        int choice = rGen.nextInt(2) + 1;
        switch (choice)
        {
            case 1: operation = " plus ";
                    break;
            case 2: operation = " minus ";
                    break;
            case 3: operation = " times ";
                    break;
        }
        return getOperation();
    }
}
