package solidprimitive;
import com.jogamp.opengl.GL2;

public class Cylindre {
	private float hauteur,rayon;
	private int resolution;
	
	public Cylindre(float hauteur,float rayon,int resolution){
		this.hauteur=hauteur;
		this.rayon=rayon;
		this.resolution=resolution;
	}

	public void draw(GL2 gl)
	  {
	    gl.glBegin (GL2.GL_TRIANGLE_FAN);
	    gl.glNormal3f(0, 0, 1);
	      gl.glVertex3d(0, 0, hauteur/2);
	      for (int i=0;i<resolution;i++){
	    	  double ang=(2*Math.PI*i)/resolution;
	    	  double cosang=Math.cos(ang);
	    	  double sinang=Math.sin(ang);
	    	  gl.glVertex3d(rayon*cosang,rayon*sinang,hauteur/2);
	      }
	      gl.glVertex3d(rayon*Math.cos((2*Math.PI*0)/resolution),rayon*Math.sin((2*Math.PI*0)/resolution),hauteur/2);
	    gl.glEnd ();
	    
	    
	    gl.glBegin(GL2.GL_TRIANGLE_STRIP);
	    for(int i=0;i<resolution;i++){
	    	
	    	double ang=(2*Math.PI*i)/resolution;
	    	double cosang=Math.cos(ang);
	    	double sinang=Math.sin(ang);
	    	
	    	
	    	gl.glNormal3d(cosang,sinang, 0);
	    	
	    	gl.glVertex3d(rayon*cosang,rayon*sinang,hauteur/2);
	    	gl.glVertex3d(rayon*cosang,rayon*sinang,-hauteur/2);
	    }
	   
	    
	    gl.glNormal3d(Math.cos((2*Math.PI*0)/resolution),Math.sin((2*Math.PI*0)/resolution), 0);
	    gl.glVertex3d(rayon*Math.cos((2*Math.PI*0)/resolution),rayon*Math.sin((2*Math.PI*0)/resolution),hauteur/2);
	    gl.glVertex3d(rayon*Math.cos((2*Math.PI*0)/resolution),rayon*Math.sin((2*Math.PI*0)/resolution),-hauteur/2);
	    gl.glEnd();
	    
	    gl.glBegin (GL2.GL_TRIANGLE_FAN);
	   
	    gl.glNormal3f(0, 0,- 1);
	    gl.glVertex3d(0, 0, -hauteur/2);
	    for (int i=0;i<resolution;i++){
	    	double ang=-(2*Math.PI*i)/resolution;
	    	double cosang=Math.cos(ang);
	    	double sinang=Math.sin(ang);
	    	gl.glVertex3d(rayon*cosang,rayon*sinang,-hauteur/2);
	    }
	    gl.glVertex3d(rayon*Math.cos(-(2*Math.PI*0)/resolution),rayon*Math.sin(-(2*Math.PI*0)/resolution),-hauteur/2);
	    gl.glEnd ();
	   
	  }

}
