
package esof322.a1;

/**
 *Team 03
 * @author Megan Weller, Ashley Bertrand, Sheila Tupker
 */
public class Vector3D {
    private double x;
    private double y;
    private double z;
    
    //constructor Megan
    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
     }
    
    //Vector3D scale Megan
    public Vector3D(double f){
        x = x * f;
        y = y * f;
        z = z * f;            
    }
            
    //Vector3D add Ashley
    public Vector3D add(Vector3D v) {
        return v;
    }
    
    //Vector3D subtract Sheila
    
    //Vector3D negate Sheila
    
    //double dot Ashley
    public double dot(Vector3D v) {
        return 1;
    }
    
    //double magnitude Sheila
    
    //toString Ashley
    @Override
    public String toString() {
        return "Ashley is so cool";
    }
    
    //implementation of equals Megan 
}
