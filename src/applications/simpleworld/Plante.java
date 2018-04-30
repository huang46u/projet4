package applications.simpleworld;
import com.jogamp.opengl.GL2;

import lsystem.Grammar;
import worlds.World;

public class Plante extends Vie{
	
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	private Grammar grammar;
	private float length;
	private float[] pos={0.0f,0.0f,length/2};
	
	public Plante(int __x, int __y, World __world) {
		super(__x, __y, __world);
		setHp(100);
		this.initgeneration();
		length=10.f;
		
		
		// TODO Auto-generated constructor stub
	}	
	public void initgeneration(){
		grammar=new Grammar("Test");
		grammar.addGeneration("X","F[$$[^X][&X]%%[^X][&X]]");
		grammar.addGeneration("X","F[%%[^^X][&X]%%[^X][&X]]");
		grammar.addGeneration("X","F[$[^X][$X]^[%X][&X]]");
		//grammar.addGeneration("F", "FF");
		grammar.setStart("X");
	}
	
	public void draw(double hauteur,double rayon,double resolution,GL2 gl){
		gl.glPushMatrix();
		gl.glRotatef(-90, 0.0f, 0.0f, 1.0f);
		gl.glBegin (GL2.GL_TRIANGLE_FAN);
	    //gl.glNormal3f(0, 0, 1);
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
	    	//gl.glNormal3d(cosang,sinang, 0);

	    	gl.glVertex3d(rayon*cosang,rayon*sinang,hauteur/2);
	    	gl.glVertex3d(rayon*cosang,rayon*sinang,-hauteur/2);
	    }
	    gl.glNormal3d(Math.cos((2*Math.PI*0)/resolution),Math.sin((2*Math.PI*0)/resolution), 0);
	    gl.glVertex3d(rayon*Math.cos((2*Math.PI*0)/resolution),rayon*Math.sin((2*Math.PI*0)/resolution),hauteur/2);
	    gl.glVertex3d(rayon*Math.cos((2*Math.PI*0)/resolution),rayon*Math.sin((2*Math.PI*0)/resolution),-hauteur/2);
	    gl.glEnd();
	    
	    gl.glBegin (GL2.GL_TRIANGLE_FAN);
	   
	    //gl.glNormal3f(0, 0,- 1);
	    gl.glVertex3d(0, 0, -hauteur/2);
	    for (int i=0;i<resolution;i++){
	    	double ang=-(2*Math.PI*i)/resolution;
	    	double cosang=Math.cos(ang);
	    	double sinang=Math.sin(ang);
	    	gl.glVertex3d(rayon*cosang,rayon*sinang,-hauteur/2);
	    }
	    gl.glVertex3d(rayon*Math.cos(-(2*Math.PI*0)/resolution),rayon*Math.sin(-(2*Math.PI*0)/resolution),-hauteur/2);
	    gl.glEnd ();
	    gl.glPopMatrix();
	}
	
	@Override
	public void step() {
		if ( world.getIteration() % 360 == 0 ){
			if(world.isDAYTIME()){
		if(grammar.getLevel()<2){
			if(Math.random()<0.5){
			grammar.setLevel(grammar.getLevel()+1);
			grammar.iterate(1);
			}
			
			}
			}
		}
	}
	public Grammar getGrammar() {
		return grammar;
	}

	public void setGrammar(Grammar grammar) {
		this.grammar = grammar;
	}

	public void displayUniqueObject(World myWorld, GL2 gl, int offsetCA_x, int offsetCA_y, float offset, float stepX,
			float stepY, float lenX, float lenY, float normalizeHeight) {
		// TODO Auto-generated method stub
		int x2 = (x-(offsetCA_x%myWorld.getWidth()));
		if ( x2 < 0) x2+=myWorld.getWidth();
		int y2 = (y-(offsetCA_y%myWorld.getHeight()));
		if ( y2 < 0) y2+=myWorld.getHeight();
		float height = Math.max ( 0 , (float)myWorld.getCellHeight(x, y) );
		float altitude =height * normalizeHeight ;
		gl.glPushMatrix();
		
		gl.glTranslatef(offset+x2*stepX, offset+y2*stepY, altitude);
		
		//gl.glBegin(GL2.GL_QUADS);
		for(int i=0;i<grammar.getResult().length();i++){
			
			char ch=grammar.getResult().charAt(i);
			
			switch(ch){
			case 'F':  
				gl.glTranslatef(pos[0], pos[1], pos[2]);
				draw(length,0.5f,3,gl);
	            break; 
			case 'X':  
				gl.glTranslatef(pos[0], pos[1], pos[2]/2);
				draw(length/2,0.1f,3,gl);
	            break; 
	        case '$':  
	            gl.glRotatef(30, 0.0f, 1.0f, 0.0f);
	            break;  
	        case '%':  
	        	gl.glRotatef(-15, 0.0f, 1.0f, 0.0f); 
	            break;  
	        case '^':  
	        	gl.glRotatef(30, 1.0f, 0.0f, 0.0f);  
	            break;  
	        case '&':  
	        	gl.glRotatef(-15, 1.0f, 0.0f, 0.0f);
	            break;  
	        case '[':  
	            gl.glPushMatrix(); 
	            break;  
	        case ']':  
	            gl.glPopMatrix();  
	            break;  
	        default:  
	            break;  
			}
		}
		
	/*	gl.glTranslatef(pos[0], pos[1], pos[2]);
		draw(20.0f,0.3f,10,gl);
			gl.glPushMatrix();
			gl.glRotatef(30, 0.0f, 1.0f, 0.0f);  
			gl.glTranslatef(pos[0], pos[1], pos[2]);
			draw(20.0f,0.3f,10,gl);
				gl.glPushMatrix();
				gl.glRotatef(30, 0.0f, 1.0f, 0.0f);  
				gl.glTranslatef(pos[0], pos[1], pos[2]);
				draw(20.0f,0.3f,10,gl);
				gl.glPopMatrix();
				gl.glPushMatrix();
				gl.glRotatef(-30, 0.0f, 1.0f, 0.0f);  
				gl.glTranslatef(pos[0], pos[1], pos[2]);
				draw(20.0f,0.3f,10,gl);
				gl.glPopMatrix();
			gl.glPopMatrix();
			gl.glPushMatrix();
			gl.glRotatef(-30, 0.0f, 1.0f, 0.0f);  
			gl.glTranslatef(pos[0], pos[1], pos[2]);
			draw(20.0f,0.3f,10,gl);
			gl.glPopMatrix();*/
		gl.glPopMatrix();
	
		pos[0]=0.0f;
		pos[1]=0.0f;
		pos[2]=length/2;
	}

	
}
