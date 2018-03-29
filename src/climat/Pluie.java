package climat;

import com.jogamp.opengl.GL2;

import worlds.World;

public class Pluie {
	 /** Rain direction */
	  private float[] dir;
	  /** Drops of water */
	  private Drop[] drops;
	  /** Count of active drops */
	  private int nbd = 1;
	  private World world;

	  /** Creates a water sprinkling.
	    * @param pos Sprinkling start position.
	    * @param dir Sprinkling direction.
	    */
	  public Pluie (float[] dir,World world)
	  {
	   this.world=world;
	    this.dir = dir;
	    
	  }

	  /** Initializes the water sprinkling.
	    * @param gl GL2 context.
	    */
	  public void init ()
	  {
		  
		  drops=new Drop[2000];
		  for(int i=0;i<2000;i++){
			 // float[] pos={(float)(Math.random()*200),(float)(Math.random()*200),500.0f};
			  float[] pos={(float)Math.random()*200,(float)Math.random()*200,100.0f};
			  System.out.println(pos[0]+" , "+pos[1]+" , "+pos[2]);
			  drops[i]= new Drop (pos,dir,world);
		  }

	  }

	  /** Renders the water sprinkling.
	    * @param gl GL2 context. 
	    */ 
	  public void draw ( GL2 gl,int offsetCA_x, int offsetCA_y, float offset,
				float stepX, float stepY)
	  {
		  
	    //gl.glDisable (GL2.GL_LIGHTING);
	    
	      for (int i = 0; i < nbd; i++) {
	    	  
	    	  drops[i].drawpluie(gl, offsetCA_x, offsetCA_y, offset, stepX, stepY);
	      }
	    //gl.glEnable (GL2.GL_LIGHTING);
	  }

	  /** Background task.
	   */
	  public void background ()
	  {
	    for (int i = 0; i < nbd; i++) 
	    	if (drops[i].background ()) nbd --;
	    if(nbd<1997){
	    	nbd+=4;}
	    }
}
