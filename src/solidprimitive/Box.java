package solidprimitive;
// Trame du TP de modelisation 3D : primitives solides
// DUT Informatique - 2016/2017
// Prepares par P. Even

import com.jogamp.opengl.GL2;


/** Box solid primitive */
public class Box 
{
  /** Half depth (X) */
  private float depth_2 = 1.0f;
  /** Half width (Y) */
  private float width_2 = 1.0f;
  /** Half height (Z) */
  private float height_2 = 1.0f;
  /** Box couleur*/
  private float[] color;

  /** Constructs a box with given parameters.
    * @param depth Box depth
    * @param width Box width
    * @param height Box height
   
    */ 
  public Box (float depth, float width, float height,float[] color)
  {
    depth_2 = depth / 2; 
    width_2 = width / 2; 
    height_2 = height / 2; 
    this.color=color;
   
  }

  /** Constructs a unit box
    */ 
  public Box ()
  {
  }

  /** Renders the box primitive.
    * @param gl GL2 context. 
    */ 
  public void draw (GL2 gl)
  {
    gl.glPushMatrix ();
     
      gl.glColor3f(color[0], color[1], color[2]);
      gl.glBegin (GL2.GL_QUADS);
        gl.glNormal3f (0.0f, 0.0f, -1.0f);
        gl.glVertex3f (-depth_2, -width_2, -height_2);
        gl.glVertex3f (-depth_2, width_2, -height_2);
        gl.glVertex3f (depth_2, width_2, -height_2);
        gl.glVertex3f (depth_2, -width_2, -height_2);

        gl.glNormal3f (-1.0f, 0.0f, 0.0f);
        gl.glVertex3f (-depth_2, -width_2, -height_2);
        gl.glVertex3f (-depth_2, -width_2, height_2);
        gl.glVertex3f (-depth_2, width_2, height_2);
        gl.glVertex3f (-depth_2, width_2, -height_2);

        gl.glNormal3f (0.0f, -1.0f, 0.0f);
        gl.glVertex3f (-depth_2, -width_2, -height_2);
        gl.glVertex3f (depth_2, -width_2, -height_2);
        gl.glVertex3f (depth_2, -width_2, height_2);
        gl.glVertex3f (-depth_2, -width_2, height_2);

        gl.glNormal3f (0.0f, 0.0f, 1.0f);
        gl.glVertex3f (depth_2, width_2, height_2);
        gl.glVertex3f (-depth_2, width_2, height_2);
        gl.glVertex3f (-depth_2, -width_2, height_2);
        gl.glVertex3f (depth_2, -width_2, height_2);

        gl.glNormal3f (1.0f, 0.0f, 0.0f);
        gl.glVertex3f (depth_2, width_2, height_2);
        gl.glVertex3f (depth_2, -width_2, height_2);
        gl.glVertex3f (depth_2, -width_2, -height_2);
        gl.glVertex3f (depth_2, width_2, -height_2);

        gl.glNormal3f (0.0f, 1.0f, 0.0f);
        gl.glVertex3f (depth_2, width_2, height_2);
        gl.glVertex3f (depth_2, width_2, -height_2);
        gl.glVertex3f (-depth_2, width_2, -height_2);
        gl.glVertex3f (-depth_2, width_2, height_2);
      gl.glEnd ();

    gl.glPopMatrix ();
  }
}
