import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner value =  new Scanner(System.in);
        double xValues[] = {23,26,30,34,43,48,52,57,58};
        double yValues[] = {651,762,856,1063,1190,1298,1421,1440,1518};
        double x;
        int intentos = 0;

        SLR slr = new SLR(xValues,yValues);

        slr.calculateBetas();
        /*slr.printEquation();    
        System.out.println("\n");*/
        slr.setBethas();
        int iteraciones=0;
        while(slr.lossFunction()>0.0001){
            slr.minimizeTerms();
            System.out.printf("\nError: %.9f",slr.lossFunction());
            iteraciones++;
        }
        System.out.println("\n iteraciones: "+iteraciones);
        slr.printEquation();
        
        /*for(int i=0;i<9;i++){
            System.out.println(slr.predictValue(xValues[i]));
        }*/
        

    }
}
