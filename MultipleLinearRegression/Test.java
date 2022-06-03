import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        double[] x1Val = {23,26,30,34,43,48,52,57,58};
        double[] x2Val = {1,2,3,4,5,6,7,8,9};
        double[] yVal = {651,762,856,1063,1190,1298,1421,1440,1518};
        double x1,x2;
        double oldMSE;
        Scanner value =  new Scanner(System.in);
        MLR mlr = new MLR(x1Val, x2Val, yVal);
        mlr.printFunction();
        mlr.setBethas();
        /*while(mlr.lossFunction()>0.0001){
            mlr.minimizeTerms();
            System.out.println("\n");
            System.out.printf("\nError: %.9f\n",mlr.lossFunction());
        }*/
       for(int i=0;i<1000;i++){
            mlr.minimizeTerms();
            System.out.println("\n");
            System.out.printf("\nError: %.9f",mlr.lossFunction());
        
       }
        
    }
}
