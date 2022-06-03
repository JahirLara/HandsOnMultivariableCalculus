import java.lang.Math;

import javax.swing.text.html.HTMLDocument.RunElement;
public class MLR{
    private double n,x1,x2,x12,x22,x1x2,y,x1y,x2y,detSys,detB0,detB1,detB2,betaZero,betaOne,betaTwo;
    private double[] x1Values, x2Values, yValues;
    double a=0,b=0,c=0,L=0.0001,MSE=0;
    public MLR(double[]x1Val,double[] x2Val,double[] yVal){
        x1Values = x1Val;
        x2Values = x2Val;
        yValues = yVal;
        n = x1Val.length;
        for(int i=0;i<n;i++){
            x1 += x1Val[i];
            x2 += x2Val[i];
            x12 += Math.pow(x1Val[i], 2);
            x22 += Math.pow(x2Val[i], 2);
            x1x2 += x1Val[i]*x2Val[i];
            y += yVal[i];
            x1y += x1Val[i]*yVal[i];
            x2y += x2Val[i]*yVal[i];
        }
    }

    public void calculateDeterminants(){
        detSys = (n*x12*x22)+(2*(x1*x1x2*x2))-(x2*x2*x12)-(n*x1x2*x1x2)-(x1*x1*x22);
        detB0 = (y*x12*x22)+(x1*x1x2*x2y)+(x2*x1y*x1x2)-(x2*x12*x2y)-(y*x1x2*x1x2)-(x1*x1y*x22);
        detB1 = (n*x1y*x22)+(y*x1x2*x2)+(x2*x1*x2y)-(x2*x1y*x2)-(n*x1x2*x2y)-(y*x1*x22);
        detB2 = (n*x12*x2y)+(x1*x1y*x2)+(y*x1*x1x2)-(y*x12*x2)-(n*x1y*x1x2)-(x1*x1*x2y);
    }
    public void calculateBetas(){
        betaZero = detB0/detSys;
        betaOne = detB1/detSys;
        betaTwo = detB2/detSys;
    }
    public void printFunction(){
        calculateDeterminants();
        calculateBetas();
        if(betaOne<0 && betaTwo<0){
            System.out.printf("y = %.0f %.0fx1 %.0fx2",betaZero,betaOne,betaTwo);
        }
        if(betaOne<0 && betaTwo>0){
            System.out.printf("y = %.0f %.0fx1 +%.0fx2",betaZero,betaOne,betaTwo);
        }
        if(betaOne>0 && betaTwo<0){
            System.out.printf("y = %.0f +%.0fx1 %.0fx2",betaZero,betaOne,betaTwo);
        }
        else{
            System.out.printf("y = %.0f +%.0fx1 +%.0fx2",betaZero,betaOne,betaTwo);
        }
    }

    public double predictValue(double v1,double v2){
        double predictValue = betaZero + (betaOne*v1) + (betaTwo*v2);
        //System.out.printf("El valor de y cuando x1 vale %.1f y x2 vale %.1f es: %.2f",v1,v2,predictValue);
        return predictValue;
    }
    public void setBethas(){
        betaTwo=0;
        betaOne=0;
        betaZero=0;
    }
    public void minimizeTerms(){
        double sumatoria_a = 0;
        double sumatoria_b = 0;
        double sumatoria_c =0;
        for(int i=0;i<n;i++){
            sumatoria_a += -2.0/n*(x2Values[i]*(yValues[i]-predictValue(x1Values[i], x2Values[2])));
            sumatoria_b += -2.0/n*(x1Values[i]*(yValues[i]-predictValue(x1Values[i], x2Values[2])));
            sumatoria_c += -2.0/n*((yValues[i]-predictValue(x1Values[i], x2Values[2])));
        }
        a = a - L*sumatoria_a;
        b = b - L*sumatoria_b;
        c = c - L*sumatoria_c;

        betaTwo = a;
        betaOne = b;
        betaZero = c;
    }
    public double lossFunction(){
        
        double sumatoria = 0;
        for(int i=0;i<n;i++){
            sumatoria += yValues[i]-predictValue(x1Values[i], x2Values[i]);
        }
        sumatoria = sumatoria/n;
        MSE = sumatoria*sumatoria;

        return MSE;
    }

}
