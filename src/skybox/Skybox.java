package skybox;
import static com.jogamp.opengl.GL.GL_LINEAR;
import static com.jogamp.opengl.GL.GL_TEXTURE_2D;
import static com.jogamp.opengl.GL.GL_TEXTURE_MAG_FILTER;
import static com.jogamp.opengl.GL.GL_TEXTURE_MIN_FILTER;

import java.io.File;
import java.io.IOException;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureCoords;
import com.jogamp.opengl.util.texture.TextureIO;
public class Skybox {
	 private float depth_2 = 1.0f;
	  /** Half width (Y) */
	  private float width_2 = 1.0f;
	  /** Half height (Z) */
	  private float height_2 = 1.0f;
	  private Texture[] texture;
	  String[] texturepath;
	  float textureBack[]= new float[4]; 
	  float textureDown[] = new float[4]; 
	  float textureFront []= new float[4]; 
	  float textureLeft[] = new float[4]; 
	  float textureRight[] = new float[4]; 
	  float textureUp []= new float[4]; 
						
	  /** Constructs a box with given parameters.
	    * @param depth Skybox depth
	    * @param width SkyBox width
	    * @param height SkyBox height
	    * @param ref Box refence system (REF_CENTER or REF_BASE) 
	    */ 
	  public Skybox (float depth, float width, float height)
	  {
	    depth_2 = depth / 2; 
	    width_2 = width / 2; 
	    height_2 = height / 2;
	    setTexture(new Texture[6]);
	  }
	  
	  public Skybox(){
		  this(100.0f,100.0f,100.0f);
	  }
	  private void initTexture(){
		  texturepath=new String[6];
		  texturepath[0]="skybox/stormydays_bk.jpg";
		  texturepath[1]="skybox/stormydays_dn.jpg";
		  texturepath[2]="skybox/stormydays_ft.jpg";
		  texturepath[3]="skybox/stormydays_lf.jpg";
		  texturepath[4]="skybox/stormydays_rt.jpg";
		  texturepath[5]="skybox/stormydays_up.jpg";
	  }
	  public void load(GL2 gl){
		  initTexture();
		  try {
			  
				// Create a OpenGL Texture object from (URL, mipmap, file suffix)
				// Use URL so that can read from JAR and disk file.
			  for(int i=0;i<getTexture().length;i++){
					getTexture()[i] = TextureIO.newTexture(
							new File(texturepath[i]), // relative to project root 
							false);		
				}
			 /* U
				 * se linear filter for texture if image is larger than the original texture
				 */
				gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL2.GL_LINEAR);
				// Use linear filter for texture if image is smaller than the original texture
				gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL2.GL_LINEAR);
				// Texture image flips vertically. Shall use TextureCoords class to retrieve
				// the top, bottom, left and right coordinates, instead of using 0.0f and 1.0f.
		  }
			catch (GLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	  }
	  /** Renders the box primitive.
	    * @param gl GL2 context. 
	    */ 
	  public void draw (GL2 gl)
	  {
		  
		  gl.glPushMatrix();
		  
	      
	      //Down
	      //gl.glColor3f(0.0f, 0.0f, 0.0f);
		 gl.glTranslatef(0.0f, 0.0f, 70.0f);
		  gl.glBindTexture(GL2.GL_TEXTURE_2D, texture[1].getTextureObject());
		  gl.glBegin (GL2.GL_QUADS);
	      	gl.glNormal3f(0.0f, 0.0f, 1.0f);
	      	gl.glTexCoord2f(1,0);                                                                                               
	        gl.glVertex3f (-depth_2, -width_2, -height_2);
	        gl.glTexCoord2f(0,0);
	        gl.glVertex3f (-depth_2, width_2, -height_2);
	        gl.glTexCoord2f(0,1);
	        gl.glVertex3f (depth_2, width_2, -height_2);
	        gl.glTexCoord2f(1,1);
	        gl.glVertex3f (depth_2, -width_2, -height_2);
	      gl.glEnd ();
	        //Left
	       //gl.glColor3f(0.0f, 1.0f, 0.0f);
	      gl.glBindTexture(GL2.GL_TEXTURE_2D, texture[3].getTextureObject());
	       gl.glBegin (GL2.GL_QUADS);
	        gl.glNormal3f(1.0f, 0.0f, 0.0f);
	        gl.glTexCoord2f(0,0);
	        gl.glVertex3f (-depth_2, -width_2, -height_2);
	        gl.glTexCoord2f(0,1);
	        gl.glVertex3f (-depth_2, -width_2, height_2);
	        gl.glTexCoord2f(1,1);
	        gl.glVertex3f (-depth_2, width_2, height_2);
	        gl.glTexCoord2f(1,0);
	        gl.glVertex3f (-depth_2, width_2, -height_2);
	        gl.glEnd ();
	        //Front
	       // gl.glColor3f(0.0f, 0.0f, 1.0f);
	        
	        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture[2].getTextureObject());
	     gl.glBegin (GL2.GL_QUADS);
	        gl.glNormal3f(0.0f, 1.0f, 0.0f);
	        gl.glTexCoord2f(1,0);
	        gl.glVertex3f (-depth_2, -width_2, -height_2);
	        gl.glTexCoord2f(0,0);
	        gl.glVertex3f (depth_2, -width_2, -height_2);
	        gl.glTexCoord2f(0,1);
	        gl.glVertex3f (depth_2, -width_2, height_2);
	        gl.glTexCoord2f(1,1);
	        gl.glVertex3f (-depth_2, -width_2, height_2);
	        gl.glEnd ();
	        //Up
	        //gl.glColor3f(0.0f, 1.0f, 0.0f);
	        
	       
	    gl.glBindTexture(GL2.GL_TEXTURE_2D, texture[5].getTextureObject());
	      gl.glBegin (GL2.GL_QUADS);
	        gl.glNormal3f(0.0f, 0.0f, -1.0f);
	        gl.glTexCoord2f(0,0);
	        gl.glVertex3f (depth_2, width_2, height_2);
	        gl.glTexCoord2f(0,1);
	        gl.glVertex3f (-depth_2, width_2, height_2);
	        gl.glTexCoord2f(1,1);
	        gl.glVertex3f (-depth_2, -width_2, height_2);
	        gl.glTexCoord2f(1,0);
	        gl.glVertex3f (depth_2, -width_2, height_2);
	        gl.glEnd ();
	       //Right
	        //gl.glColor3f(0.0f, 1.0f, 1.0f);
	        
	     gl.glBindTexture(GL2.GL_TEXTURE_2D, texture[4].getTextureObject());
	       gl.glBegin (GL2.GL_QUADS);
	        gl.glNormal3f(-1.0f, 0.0f, 0.0f);
	        gl.glTexCoord2f(0,1);
	        gl.glVertex3f (depth_2, width_2, height_2);
	        gl.glTexCoord2f(1,1);
	        gl.glVertex3f (depth_2, -width_2, height_2);
	        gl.glTexCoord2f(1,0);
	        gl.glVertex3f (depth_2, -width_2, -height_2);
	        gl.glTexCoord2f(0,0);
	        gl.glVertex3f (depth_2, width_2, -height_2);
	        gl.glEnd ();
	        //Back
	        //gl.glColor3f(1.0f, 1.0f, 0.0f);
	        
	     
	        
	    gl.glBindTexture(GL2.GL_TEXTURE_2D, texture[0].getTextureObject());
	     gl.glBegin (GL2.GL_QUADS);
	        gl.glNormal3f(0.0f, -1.0f, 0.0f);
	        gl.glTexCoord2f(1,1);
	        gl.glVertex3f (depth_2, width_2, height_2);
	        gl.glTexCoord2f(1,0);
	        gl.glVertex3f (depth_2, width_2, -height_2);
	        gl.glTexCoord2f(0,0);
	        gl.glVertex3f (-depth_2, width_2, -height_2);
	        gl.glTexCoord2f(0,1);
	        gl.glVertex3f (-depth_2, width_2, height_2);
	      gl.glEnd ();
	      gl.glPopMatrix();
	    
	  }

	public Texture[] getTexture() {
		return texture;
	}

	public void setTexture(Texture[] texture) {
		this.texture = texture;
	}
}
