// ### WORLD OF CELLS ### 
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package lsystem;

import com.jogamp.opengl.GL2;

import objects.CommonObject;
import worlds.World;

public class Tree extends CommonObject {
	private static Grammar grammar;
	private static float[] pos={0.0f,0.0f,2.0f};
	
	public Tree(){
		 
	}
	
	public static void initgeneration(int iter){
		grammar=new Grammar("Test");
		grammar.addGeneration("F","F[$[^X][&X]][%[^X][&X]]");
		grammar.addGeneration("F","F[%[^X][&X]]");
		grammar.addGeneration("X","F[$[^X][&X]]");
		
		//grammar.addGeneration("F", "FF");
		grammar.setStart("F");
		
		grammar.iterate(iter);
		
		System.out.println(grammar.getResult());
	}
	
	public static void draw(double hauteur,double rayon,double resolution,GL2 gl){
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
	
    public static void displayObjectAt(World myWorld, GL2 gl, int cellState, float x, float y, double height, float offset, 
    		float stepX, float stepY, float lenX, float lenY, float normalizeHeight )
    {
        //float smoothFactorAvg = ( smoothFactor[0] + smoothFactor[1] + smoothFactor[2] + smoothFactor[3] ) / 4.f;
        
        switch ( cellState )
        {
        	case 1:
        		gl.glColor3f(0.f,0.6f-(float)(0.2*Math.random()),0.f);
        		break;
        	case 2:
        		gl.glColor3f(1.f-(float)(0.2*Math.random()),0.f,0.f);
        		break;
        	case 3:
        		gl.glColor3f(0.f+(float)(0.2*Math.random()),0.f+(float)(0.2*Math.random()),0.f+(float)(0.2*Math.random()));
        		break;
        }
        if ( cellState > 0 )
        {
    		float altitude = (float)height * normalizeHeight ;
    		
    		//float heightFactor, double heightBooster, float smoothFactor[]
    		gl.glPushMatrix();
    		
    		gl.glTranslatef(offset+x*stepX, offset+y*stepY, altitude);
    		gl.glScalef(3.0f,3.0f,3.0f);
    		gl.glBegin(GL2.GL_QUADS);
    		/*for(int i=0;i<grammar.getResult().length();i++){
    			
    			char ch=grammar.getResult().charAt(i);
    			
    			switch(ch){
    			case 'F':  
    				gl.glTranslatef(pos[0], pos[1], pos[2]);
    				draw(4.0f,0.2f,3,gl);
    	            break; 
    			case 'X':  
    				gl.glTranslatef(pos[0], pos[1], pos[2]/2);
    				draw(2.0f,0.1f,3,gl);
    	            break; 
    	        case '$':  
    	            gl.glRotatef((float)Math.random()*30, 0.0f, 1.0f, 0.0f);
    	            break;  
    	        case '%':  
    	        	gl.glRotatef(-(float)Math.random()*30, 0.0f, 1.0f, 0.0f); 
    	            break;  
    	        case '^':  
    	        	gl.glRotatef((float)Math.random()*30, 1.0f, 0.0f, 0.0f);  
    	            break;  
    	        case '&':  
    	        	gl.glRotatef(-(float)Math.random()*30, 1.0f, 0.0f, 0.0f);
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
				gl.glPopMatrix();
			gl.glPopMatrix();
		*/
          /*  gl.glVertex3f( offset+x*stepX-lenY/16.f, offset+y*stepY+lenY/2.f, altitude + 4.f );
            gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude );
            
            gl.glVertex3f( offset+x*stepX+lenY/16.f, offset+y*stepY-lenY/2.f, altitude + 4.f );
            gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude );

            gl.glVertex3f( offset+x*stepX-lenY/2.f, offset+y*stepY+lenY/16.f, altitude + 4.f );
            gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude );
           
            gl.glVertex3f( offset+x*stepX+lenY/2.f, offset+y*stepY-lenY/16.f, altitude + 4.f );
            gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude );*/
            
            gl.glVertex3f( -lenY/16.f, lenY/2.f, 4.f );
            gl.glVertex3f( 0.0f, 0.0f, 0.0f);
            
            gl.glVertex3f( 0.0f+lenY/16.f, 0.0f-lenY/2.f, 0.0f + 4.f );
            gl.glVertex3f( 0.0f, 0.0f, 0.0f );

            gl.glVertex3f( 0.0f-lenY/2.f, 0.0f+lenY/16.f, 0.0f + 4.f );
            gl.glVertex3f( 0.0f, 0.0f, 0.0f );
           
            gl.glVertex3f( 0.0f+lenY/2.f, 0.0f-lenY/16.f, 0.0f + 4.f );
            gl.glVertex3f( 0.0f, 0.0f, 0.0f );
            
            gl.glEnd();
            gl.glPopMatrix();
        }
    }

}
