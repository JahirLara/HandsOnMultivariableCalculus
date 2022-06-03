public class DataSets {
    //Data Sets para SLR

    /*private double x[] = {23,26,30,34,43,48,52,57,58};
    private double y[] = {651,762,856,1063,1190,1298,1421,1440,1518};*/

    private double x[] = {1,2,3,4,5,6,7,8,9};
    private double y[] = {3,6,9,12,15,18,21,24,27};

    //Data Sets para MLR
    
    double x1[] = {23,26,30,34,43,48,52,57,58};
    double x2[] = {1,2,3,4,5,6,7,8,9};
    double y1[] = {651,762,856,1063,1190,1298,1421,1440,1518};

    public double[] getX() {
        return x;
    }
    public double[] getY() {
        return y;
    }
    public double[] getX1(){
        return x1;
    }
    public double[] getX2(){
        return x2;
    }
    public double[] getY1(){
        return y1;
    }

    public double getN(){
        double n = y.length;
        return n;
    }
    public double getK(){
    	double k = y1.length;
	return k;
    }

}
