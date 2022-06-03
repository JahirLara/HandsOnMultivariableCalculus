import java.lang.Math;
public class VectorOperations{
	
    public double magnitude(Vector v){
        return  Math.sqrt(Math.pow(v.getxComponent(), 2) + Math.pow(v.getyComponent(), 2) + Math.pow(v.getzComponent(), 2));
    }

    /*public double magnitudeAB(Vector a, Vector b){
        return  Math.sqrt(Math.pow(b.getxComponent()-a.getxComponent(),2) + Math.pow(b.getyComponent()-a.getyComponent(),2));
    }*/

    public double slope(Vector a){
        return a.getyComponent()/a.getxComponent();
    }

    /*public double slopeAB(Vector a, Vector b){
        return ((b.getyComponent()-a.getyComponent())/(b.getxComponent()-a.getxComponent()));
    }*/

    public boolean equalVectors(Vector a, Vector b){
        return magnitude(a)==magnitude(b) && slope(a)==slope(b)?true: false;
    }

    public Vector vectorsAddition(Vector ... vectors){
        float x=0,y=0,z=0;
        for(Vector v:vectors){
            x+=v.getxComponent();
            y+=v.getyComponent();
            z+=v.getzComponent();
        }

        return new Vector(x, y, z);
    }

    public Vector vectorSubstraction(Vector a, Vector b){
        double x,y,z;

        x = a.getxComponent()-b.getxComponent();
        y = a.getyComponent()-b.getyComponent();
        z = a.getzComponent()-b.getzComponent();

        return new Vector(x, y, z);
    }

    public Vector scarlarMult(int s, Vector v){
        double x,y,z;
        
        x = s*v.getxComponent();
        y = s*v.getyComponent();
        z = s*v.getzComponent();

        return new Vector(x, y, z);
    }

    public Vector vectorComponents(Vector initA,Vector endB){
        double xCompoent = endB.getxComponent()-initA.getxComponent();
        double yComponent = endB.getyComponent()-initA.getyComponent();
        return new Vector(xCompoent, yComponent);

    }

    public double dotProduct(Vector a, Vector b){
        return (a.getxComponent()*b.getxComponent())+(a.getyComponent()*b.getyComponent())+(a.getzComponent()*b.getzComponent());
    }

    public Vector crossProduct(Vector a,Vector b){
        double rX=0, rY=0, rZ=0;
        rX = (a.getyComponent()*b.getzComponent())-(b.getyComponent()*a.getzComponent());
        rY = -(a.getxComponent()*b.getzComponent())+(b.getxComponent()*a.getzComponent());
        rZ = (a.getxComponent()*b.getyComponent())-(b.getxComponent()*a.getyComponent());
        return new Vector(rX, rY, rZ);
    }

    public double angleBetweenVectors(Vector a, Vector b){
         return Math.toDegrees(Math.acos(dotProduct(a, b)/(magnitude(a)*magnitude(b))));
    }
}