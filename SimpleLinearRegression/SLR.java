import java.lang.Math;
public class SLR{
    double n, L = 0.0003,m=0,c=0;
    private double betaOne, betaZero, xySum, xSum, ySum, x2Sum, xSum2, xAvg, yAvg, covariance, variance;
    private double[] xValues, yValues;
    


    public SLR(double[]xValuess, double[]yValuess){
        xValues = xValuess;
        yValues = yValuess;
        n = xValues.length;
        
    }
    public void calculateBetas(){
        for(int i=0;i<n;i++){
            xySum += xValues[i]*yValues[i];
            xSum += xValues[i];
            ySum += yValues[i];
            x2Sum += Math.pow(xValues[i], 2);
        }
        xSum2 = Math.pow(xSum, 2);
        //Beta1
        covariance = (n*xySum)-(xSum*ySum);
        variance = (n*x2Sum)-xSum2;
        betaOne = covariance/variance;
        //Beta2
        xAvg = xSum/n;
        yAvg = ySum/n;
        betaZero = yAvg - (betaOne*xAvg);
    }
    public double predictValue(double x){
        double y = betaZero + (betaOne*x);
        return y;
    }
    public void printEquation(){
        System.out.printf("y =  %f + %fx", betaZero, betaOne);
    }
    public void setBethas(){
        betaOne=0;
        betaZero=0;
    }
    public void minimizeTerms(){
        double sumatoria_m = 0;
        double sumatoria_c =0;
        for(int i=0;i<n;i++){
            sumatoria_m += -2.0/n*(xValues[i]*(yValues[i]-predictValue(xValues[i])));
            sumatoria_c += -2.0/n*(yValues[i]-predictValue(xValues[i]));
        }
        m = m - L*sumatoria_m;
        c = c - L*sumatoria_c;

        betaOne = m;
        betaZero = c;
    }

    public double lossFunction(){
        double sumatoria=0, MSE = 0;
        for(int i=0;i<n;i++){
            sumatoria += yValues[i]-predictValue(xValues[i]);
        }
        sumatoria = sumatoria/n;
        MSE = sumatoria*sumatoria;
        return MSE;
    }
}