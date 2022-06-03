public class Vector{
	private double xComponent;
    private double yComponent;
    private double zComponent;

    public Vector(double x,double y, double z){
        xComponent = x;
        yComponent = y;
        zComponent = z;
    }

    public Vector(double x, double y){
        xComponent = x;
        yComponent = y;
        zComponent = 0;
    }

    public double getxComponent() {
        return xComponent;
    }
    public double getyComponent() {
        return yComponent;
    }
    public double getzComponent() {
        return zComponent;
    }

    public void printVector(char vectorName){
        if(this.zComponent!=0){
            System.out.printf("%c(%.0f, %.0f, %.0f)\n",vectorName,this.xComponent,this.yComponent,this.zComponent);
        }
        else{
            System.out.printf("%c(%.0f, %.0f)\n",vectorName,this.xComponent,this.yComponent);
        }
    }


}