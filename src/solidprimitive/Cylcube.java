package solidprimitive;
import com.jogamp.opengl.GL2;

public class Cylcube{	
	private float hauteur;
	private int resolution;
	

	public Cylcube(float hauteur,int resolution){
		this.hauteur=hauteur;
		
		this.resolution=resolution;
	}
	
	public void draw(GL2 gl) {
		double rayon=hauteur/2;
		gl.glBegin (GL2.GL_TRIANGLE_FAN);
	    gl.glNormal3f(0, 0, 1);
	      gl.glVertex3d(0, 0, hauteur/2);
	      for (int i=0;i<resolution;i++){
	    	  double ang=(Math.PI*i)/resolution;
	    	  double cosang=Math.cos(ang);
	    	  double sinang=Math.sin(ang);
	    	  gl.glVertex3d(rayon*cosang,rayon*sinang,rayon);
	      }
	      
	      gl.glVertex3d(rayon*Math.cos((Math.PI)),rayon*Math.sin((Math.PI)),rayon);
	      gl.glVertex3d(-rayon,-hauteur, rayon);
		  gl.glVertex3d(rayon,-hauteur, rayon);
		  gl.glVertex3d(rayon,0,rayon);
	      
	    gl.glEnd ();
	    
	   gl.glBegin(GL2.GL_TRIANGLE_STRIP);
	    for(int i=0;i<resolution;i++){
	    	double ang=(Math.PI*i)/resolution;
	    	double cosang=Math.cos(ang);
	    	double sinang=Math.sin(ang);
	    	gl.glNormal3d(cosang,sinang, 0);
	    	
	    	gl.glVertex3d(rayon*cosang,rayon*sinang,rayon);
	    	gl.glVertex3d(rayon*cosang,rayon*sinang,-rayon);
	    }
	    gl.glNormal3d(Math.cos(Math.PI),Math.sin(Math.PI), 0);
	    gl.glVertex3d(rayon*Math.cos(Math.PI),rayon*Math.sin(Math.PI),rayon);
	    gl.glVertex3d(rayon*Math.cos(Math.PI),rayon*Math.sin(Math.PI),-rayon);
	    gl.glEnd();
	   
	    gl.glBegin(GL2.GL_QUADS);
	    gl.glNormal3f(-1, 0, 0);
	    	gl.glVertex3d(-rayon,0, rayon);
	    	gl.glVertex3d(-rayon,-hauteur, rayon);
	    	gl.glVertex3d(-rayon,-hauteur, -rayon);
	    	gl.glVertex3d(-rayon, 0, -rayon);
	    gl.glEnd();
	    
	    gl.glBegin(GL2.GL_QUADS);
	    gl.glNormal3f(1, 0, 0);
	    gl.glVertex3d(rayon,0, rayon);
    	gl.glVertex3d(rayon,-hauteur, rayon);
    	gl.glVertex3d(rayon,-hauteur, -rayon);
    	gl.glVertex3d(rayon, 0, -rayon);
    	 gl.glEnd();
    	gl.glBegin(GL2.GL_QUADS);
	    gl.glNormal3f(0, -1, 0);
	    gl.glVertex3d(-rayon,-hauteur, rayon);
	    gl.glVertex3d(-rayon,-hauteur, -rayon);
	    gl.glVertex3d(rayon,-hauteur, -rayon);
	    gl.glVertex3d(rayon,-hauteur, rayon);
	    gl.glEnd();

	    gl.glBegin (GL2.GL_TRIANGLE_FAN);
	    gl.glNormal3f(0, 0, -1);
	    gl.glVertex3d(0, 0, -hauteur/2);
	      for (int i=0;i<resolution;i++){
	    	  double ang=(Math.PI*i)/resolution;
	    	  double cosang=Math.cos(ang);
	    	  double sinang=Math.sin(ang);
	    	  gl.glVertex3d(rayon*cosang,rayon*sinang,-rayon);
	      }
	      
	      gl.glVertex3d(rayon*Math.cos(-(Math.PI)),rayon*Math.sin(-(Math.PI)),-rayon);
	      gl.glVertex3d(-rayon,-hauteur, -rayon);
		  gl.glVertex3d(rayon,-hauteur, -rayon);
		  gl.glVertex3d(rayon,0,-rayon);
	      
	    gl.glEnd ();
		
	}

}
