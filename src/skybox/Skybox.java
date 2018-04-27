package skybox;
import static com.jogamp.opengl.GL.GL_TEXTURE_2D;
import static com.jogamp.opengl.GL.GL_TEXTURE_MAG_FILTER;
import static com.jogamp.opengl.GL.GL_TEXTURE_MIN_FILTER;

import java.io.File;
import java.io.IOException;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
public class Skybox {
	 private float depth_2 = 1.0f;
	  /** Half width (Y) */
	  private float width_2 = 1.0f;
	  /** Half height (Z) */
	  private float height_2 = 1.0f;
	  private Texture[][] texture;
	  String[][] texturepath;
	  private int texturestat;
	 
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
	    texture=new Texture[7][7];
	    texturestat=0;
	  }
	  
	  

	public int getTexturestat() {
		return texturestat;
	}

	public void setTexturestat(int texturestat) {
		this.texturestat = texturestat;
	}



	public Skybox(){
		  this(1000.0f,1000.0f,1000.0f);
	  }
	  
	  private void initTexture(){
		  texturepath=new String[7][7];
		 
			  texturepath[0][0]="skybox/stormydays/stormydays_bk.tga";
			  texturepath[0][1]="skybox/stormydays/stormydays_dn.tga";
			  texturepath[0][2]="skybox/stormydays/stormydays_ft.tga";
			  texturepath[0][3]="skybox/stormydays/stormydays_lf.tga";
			  texturepath[0][4]="skybox/stormydays/stormydays_rt.tga";
			  texturepath[0][5]="skybox/stormydays/stormydays_up.tga";
			  texturepath[0][6]="skybox/stormydays/stormydays_up.tga";//faut pas changer ici!!!! c'est bizzare mais ça fonctionne!!
		  
			  texturepath[1][0]="skybox/ame_ash/ashcanyon_bk.tga";
			  texturepath[1][1]="skybox/ame_ash/ashcanyon_dn.tga";
			  texturepath[1][2]="skybox/ame_ash/ashcanyon_ft.tga";
			  texturepath[1][3]="skybox/ame_ash/ashcanyon_lf.tga";
			  texturepath[1][4]="skybox/ame_ash/ashcanyon_rt.tga";
			  texturepath[1][5]="skybox/ame_ash/ashcanyon_up.tga";
			  texturepath[1][6]="skybox/ame_ash/ashcanyon_up.tga";//faut pas changer ici!!!! c'est bizzare mais ça fonctionne!!
		  
			  texturepath[2][0]="skybox/ame_nebula/purplenebula_bk.tga";
			  texturepath[2][1]="skybox/ame_nebula/purplenebula_dn.tga";
			  texturepath[2][2]="skybox/ame_nebula/purplenebula_ft.tga";
			  texturepath[2][3]="skybox/ame_nebula/purplenebula_lf.tga";
			  texturepath[2][4]="skybox/ame_nebula/purplenebula_rt.tga";
			  texturepath[2][5]="skybox/ame_nebula/purplenebula_up.tga";
			  texturepath[2][6]="skybox/ame_nebula/purplenebula_up.tga";//faut pas changer ici!!!! c'est bizzare mais ça fonctionne!!
			
			  texturepath[3][0]="skybox/violentdays/violentdays_bk.tga";
			  texturepath[3][1]="skybox/violentdays/violentdays_dn.tga";
			  texturepath[3][2]="skybox/violentdays/violentdays_ft.tga";
			  texturepath[3][3]="skybox/violentdays/violentdays_lf.tga";
			  texturepath[3][4]="skybox/violentdays/violentdays_rt.tga";
			  texturepath[3][5]="skybox/violentdays/violentdays_up.tga";
			  texturepath[3][6]="skybox/violentdays/violentdays_up.tga";//faut pas changer ici!!!! c'est bizzare mais ça fonctionne!!
			
			  texturepath[4][0]="skybox/ely_cloudtop/cloudtop_bk.tga";
			  texturepath[4][1]="skybox/ely_cloudtop/cloudtop_dn.tga";
			  texturepath[4][2]="skybox/ely_cloudtop/cloudtop_ft.tga";
			  texturepath[4][3]="skybox/ely_cloudtop/cloudtop_lf.tga";
			  texturepath[4][4]="skybox/ely_cloudtop/cloudtop_rt.tga";
			  texturepath[4][5]="skybox/ely_cloudtop/cloudtop_up.tga";
			  texturepath[4][6]="skybox/ely_cloudtop/cloudtop_up.tga";//faut pas changer ici!!!! c'est bizzare mais ça fonctionne!!
		  
			  texturepath[5][0]="skybox/sb_iceflow/iceflow_bk.tga";
			  texturepath[5][1]="skybox/sb_iceflow/iceflow_dn.tga";
			  texturepath[5][2]="skybox/sb_iceflow/iceflow_ft.tga";
			  texturepath[5][3]="skybox/sb_iceflow/iceflow_lf.tga";
			  texturepath[5][4]="skybox/sb_iceflow/iceflow_rt.tga";
			  texturepath[5][5]="skybox/sb_iceflow/iceflow_up.tga";
			  texturepath[5][6]="skybox/sb_iceflow/iceflow_up.tga";//faut pas changer ici!!!! c'est bizzare mais ça fonctionne!!
		  
		 
			  texturepath[6][0]="skybox/sb_strato/stratosphere_bk.tga";
			  texturepath[6][1]="skybox/sb_strato/stratosphere_dn.tga";
			  texturepath[6][2]="skybox/sb_strato/stratosphere_ft.tga";
			  texturepath[6][3]="skybox/sb_strato/stratosphere_lf.tga";
			  texturepath[6][4]="skybox/sb_strato/stratosphere_rt.tga";
			  texturepath[6][5]="skybox/sb_strato/stratosphere_up.tga";
			  texturepath[6][6]="skybox/sb_strato/stratosphere_up.tga";//faut pas changer ici!!!! c'est bizzare mais ça fonctionne!!
		  
	  }
	  
	  public void load(GL2 gl){
		  initTexture();
		  try {
			  
				// Create a OpenGL Texture object from (URL, mipmap, file suffix)
				// Use URL so that can read from JAR and disk file.
			  for(int i=0;i<7;i++){
				  for(int j=0;j<7;j++){
					texture[i][j] = TextureIO.newTexture(
							new File(texturepath[i][j]), // relative to project root 
							false);		
					System.out.println(i);
				}
			  }
			
			 /* U
				 * se linear filter for texture if image is larger than the original texture
				 */
				gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL2.GL_LINEAR);
				// Use linear filter for texture if image is smaller than the original texture
				gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL2.GL_LINEAR_MIPMAP_LINEAR);
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
	     gl.glColor3f(1.0f, 1.0f, 1.0f);//éviter les interéferences sur les couleurs 
		 gl.glTranslatef(0.0f, 0.0f, 70.0f);
		  gl.glBindTexture(GL2.GL_TEXTURE_2D, texture[texturestat][1].getTextureObject());
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
	      gl.glBindTexture(GL2.GL_TEXTURE_2D, texture[texturestat][3].getTextureObject());
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
	        
	    gl.glBindTexture(GL2.GL_TEXTURE_2D, texture[texturestat][2].getTextureObject());
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
	        
	       
	    gl.glBindTexture(GL2.GL_TEXTURE_2D, texture[texturestat][5].getTextureObject());
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
	        
	     gl.glBindTexture(GL2.GL_TEXTURE_2D, texture[texturestat][4].getTextureObject());
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
	        
	    gl.glBindTexture(GL2.GL_TEXTURE_2D, texture[texturestat][0].getTextureObject());
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



	public Texture[][] getTexture() {
		return texture;
	}



	public void setTexture(Texture[][] texture) {
		this.texture = texture;
	}

	

	
}
