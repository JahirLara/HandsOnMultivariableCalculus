public class GradentDescent {
    private double k,n, L,m,b,c,MSE,oldMSE;
    private double oldBethas[] = {0,0,0};
    private DataSets dataSets;
    public GradentDescent(){
        m=0;
        c=0;
	    b=0;
        L=0.0001;
        dataSets = new DataSets();
        n = dataSets.getN();
	    k = dataSets.getK();
    }

    public double predictValue(double x, double x2){
        double valuePredicted = (m*x) + (b*x2) + c;
        return valuePredicted;
    }

//Para SLR
    public void iterateBethasSimple(){
        double sum_m = 0;
        double sum_c =0;
        for(int i=0;i<n;i++){
            sum_m += -2.0/n*(dataSets.getX()[i]*(dataSets.getY()[i]-predictValue(dataSets.getX()[i],0)));
            sum_c += -2.0/n*(dataSets.getY()[i]-predictValue(dataSets.getX()[i],0));
        }
        m = m - L*sum_m;
        c = c - L*sum_c;
    }

    public double lossFunctionSimple(){
        double sum=0;
        for(int i=0;i<n;i++){
            sum += dataSets.getY()[i]-predictValue(dataSets.getX()[i],0);
        }
        sum = sum/n;
        MSE = sum*sum;
        return MSE;
    }

//Para MLR
    public void iterateBethasMultiple(){
	    oldBethas[0] = m;
	    oldBethas[1] = b;
	    oldBethas[2] = c;
	    oldMSE = lossFunctionMultiple();
    	double sumatoria_m = 0;
        double sumatoria_b = 0;
        double sumatoria_c =0;
        for(int i=0;i<n;i++){
            sumatoria_m += -2.0/n*((dataSets.getY1()[i]-predictValue(dataSets.getX1()[i],dataSets.getX2()[i]))*dataSets.getX1()[i]);
            sumatoria_b += -2.0/n*((dataSets.getY1()[i]-predictValue(dataSets.getX1()[i],dataSets.getX2()[i]))*dataSets.getX2()[i]);
            sumatoria_c += -2.0/n*(dataSets.getY1()[i]-predictValue(dataSets.getX1()[i],dataSets.getX2()[i]));
        }
        m = m - L*sumatoria_m;
        b = b - L*sumatoria_b;
        c = c - L*sumatoria_c;
	    if(oldMSE<=lossFunctionMultiple()){
	        m = oldBethas[0];
	        b = oldBethas[1];
	        c = oldBethas[2];
	        L = L/2.0;
	    }
    }

    public double lossFunctionMultiple(){
	double sumatoria = 0;
        for(int i=0;i<k;i++){
            sumatoria += dataSets.getY1()[i]-predictValue(dataSets.getX1()[i],dataSets.getX2()[i]);
        }
        sumatoria = sumatoria/n;
        MSE = sumatoria*sumatoria;

        return MSE;    	
    }



    public double getM() {
        return m;
    }
    public double getC() {
        return c;
    }
    public double getB(){
    	return b;
    }
}
