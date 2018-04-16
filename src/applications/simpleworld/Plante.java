package applications.simpleworld;

import com.jogamp.opengl.GL2;

import objects.UniqueDynamicObject;
import worlds.World;

public class Plante extends Vie{
	private double height;	
	
	public Plante(int __x, int __y, World __world) {
		super(__x, __y, __world);
		setHp(100);
		// TODO Auto-generated constructor stub
	}
	
	public double getHeight(){
		return height;
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void displayUniqueObject(World myWorld, GL2 gl, int offsetCA_x, int offsetCA_y, float offset, float stepX,
			float stepY, float lenX, float lenY, float normalizeHeight) {
		// TODO Auto-generated method stub
		
	}

	
}
