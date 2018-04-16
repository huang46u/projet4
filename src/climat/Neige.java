package climat;
// Trame des TP de synthese d'images
// DUT Informatique - 2016/2017
// Prepares par P. Even, Universite de Lorraine / IUT de Saint-Die

import com.jogamp.opengl.GL2;

import worlds.World;

public class Neige
{
  private float[] dir; 
  private Drop[] drops; 
  private int nbd = 1;
  private World world;

  
  public Neige (float[] dir,World world)
  {
   this.world=world;
    this.dir = dir;
    
  }

  public void init ()
  {
	  
	  drops=new Drop[2000];
	  for(int i=0;i<2000;i++){
		 // float[] pos={(float)(Math.random()*200),(float)(Math.random()*200),500.0f};
		  float[] pos={(float)Math.random()*200,(float)Math.random()*200,100.0f};
		  drops[i]= new Drop (pos,dir,world);
	  }

  }

  public void draw ( GL2 gl,int offsetCA_x, int offsetCA_y, float offset,
			float stepX, float stepY)
  {
	  
    //gl.glDisable (GL2.GL_LIGHTING);
    
      for (int i = 0; i < nbd; i++) {
    	  
    	  drops[i].drawneige(gl, offsetCA_x, offsetCA_y, offset, stepX, stepY);
      }
    //gl.glEnable (GL2.GL_LIGHTING);
  }

  public void background ()
  {
    for (int i = 0; i < nbd; i++) 
    	if (drops[i].background ()) nbd --;
    if(nbd<1997){
    	nbd+=4;}
    }
}
