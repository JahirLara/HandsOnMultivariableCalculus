import java.util.Scanner;
public class Test {
    
    public static void main(String[] args) {
        double iteraciones;
	    String option;
        GradentDescent GD = new GradentDescent();
        iteraciones = 0;
        try (Scanner opt = new Scanner(System.in)) {
            option = opt.next();
        }
        
        if(option.equals("simple")){
            while(GD.lossFunctionSimple()>0.0001){
                    GD.iterateBethasSimple();
                    iteraciones++;
                    if(iteraciones%100==0) System.out.printf("\n Error: %.9f\n",GD.lossFunctionSimple());
                }
            System.out.printf("\n Error: %.9f\n",GD.lossFunctionSimple());

            System.out.printf("B0: %.10f \nB1: %.10f \nIteraciones: %.0f",GD.getC(),GD.getM(),iteraciones);
        }
        
        else if(option.equals("multiple")){
            while(GD.lossFunctionMultiple()>0.0001){
                GD.iterateBethasMultiple();
                    iteraciones++;
                if(iteraciones%1000==0) System.out.printf("\n Error: %.9f",GD.lossFunctionMultiple());
                }
            System.out.printf("\n Error: %.9f\n",GD.lossFunctionMultiple());

            System.out.printf("B0: %.10f \nB1: %.10f \nB2: %.10f \nIteraciones: %.0f",GD.getC(), GD.getM(), GD.getB(), iteraciones);
        }
        
    }
}
