package second;

public class Rectangle {

    private double chang;
    private double kuan;

    public Rectangle(double chang,double kuan){
        this.chang = chang;
        this.kuan = kuan;
    }

    public double getArea(){
        return this.chang*this.kuan;
    }
}
