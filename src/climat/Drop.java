package climat;
// Trame des TP de synthese d'images
// DUT Informatique - 2016/2017
// Prepares par P. Even, Universite de Lorraine / IUT de Saint-Die

import java.util.Random;
import com.jogamp.opengl.GL2;

import solidprimitive.Box;
import solidprimitive.Cylindre;
import worlds.World;


/** Drop of water */
public class Drop
{
  /** Drop activity */
  private boolean active = false;
  /** Drop position */
  private float x = -2.f, y = 0.f, z = 2.f;
  /** Drop speed */
  private float vx = 0.0f, vy = 0.0f, vz = 1.0f;
  /** Start position */
  private float[] startPos;
  /** Start direction */
  private float[] startDir;
  /** World where it display*/
  private World world;
  /** drop color*/
  private float[] color={0.0f,0.0f,1.0f};

  /** Creates a drop of water.
    * @param pos Start position. 
    * @param dir Start direction. 
    */ 
  public Drop (float[] pos, float[] dir,World world)
  {
    startPos = pos;
    startDir = dir;
    x=pos[0];
    y=pos[1];
    z=pos[2];
    this.world=world;
    
  }
  /** Renders the drop of water.
    * @param gl GL2 context. 
    */ 
  public void drawpluie ( GL2 gl,int offsetCA_x, int offsetCA_y, float offset,
			float stepX, float stepY)
  {
//		gl.glBegin(GL2.GL_QUADS);
//			gl.glVertex3f (x, y, z);
//			gl.glVertex3f(x, y, z-100.f);
//			gl.glVertex3f(x+100.0f, y, z-100.f);
//			gl.glVertex3f(x+10.f, y, z);
//		gl.glEnd();
		int x2 = ((int)x-(offsetCA_x%world.getWidth()));
	  	if ( x2 < 0) x2+=world.getWidth();
	  	int y2 = ((int)y-(offsetCA_y%world.getHeight()));
	  	if ( y2 < 0) y2+=world.getHeight();
	  	float trans_x=offset+x2*stepX;
	  	float trans_y=offset+y2*stepY;
		gl.glPushMatrix();
	  	gl.glTranslatef(trans_x, trans_y, z);
	  	
	  	Box drop = new Box(0.05f,0.05f,1.f,color);
	  	drop.draw(gl);
	  	gl.glPopMatrix();
  }
  /** Renders the drop of neige.
   * @param gl GL2 context. 
   */ 
 public void drawneige ( GL2 gl,int offsetCA_x, int offsetCA_y, float offset,
			float stepX, float stepY)
 {
//		gl.glBegin(GL2.GL_QUADS);
//			gl.glVertex3f (x, y, z);
//			gl.glVertex3f(x, y, z-100.f);
//			gl.glVertex3f(x+100.0f, y, z-100.f);
//			gl.glVertex3f(x+10.f, y, z);
//		gl.glEnd();
		int x2 = ((int)x-(offsetCA_x%world.getWidth()));
	  	if ( x2 < 0) x2+=world.getWidth();
	  	int y2 = ((int)y-(offsetCA_y%world.getHeight()));
	  	if ( y2 < 0) y2+=world.getHeight();
	  	float trans_x=offset+x2*stepX;
	  	float trans_y=offset+y2*stepY;
		gl.glPushMatrix();
	  	gl.glTranslatef(trans_x, trans_y, z);
	  	gl.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
	  	gl.glColor3f(1.0f, 1.0f, 1.0f);
	  	Cylindre drop =new Cylindre(0.01f,0.5f,6);
	  	drop.draw(gl);
	    gl.glEnd();
	    
	    
	  	gl.glPopMatrix();
 }

  /** Activates the drop.
   */
  public void activate ()
  {
    active = true;
  }
  
  
  /** Background task.
   * Returns true if the drop is no more active.
   */
  public boolean background ()
  {
	
	//float inc = -0.00013f;
	x+=vx*startDir[0];
	y+=vy*startDir[1];
	z+=vz*startDir[2];
	//vz+=inc;
	if(z<0){
		x=startPos[0];
		y=startPos[1];
		z=startPos[2];
	}
    return (false);
  }
 
}
