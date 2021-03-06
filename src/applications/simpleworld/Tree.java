// ### WORLD OF CELLS ### 
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package applications.simpleworld;

import com.jogamp.opengl.GL2;

import objects.CommonObject;
import worlds.World;

public class Tree extends CommonObject {
	
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
    		
    		gl.glBegin(GL2.GL_QUADS);
    		
            
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
