// ### WORLD OF CELLS ### 
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package worlds;

import java.util.ArrayList;
import com.jogamp.opengl.GL2;

import applications.simpleworld.*;
import cellularautomata.*;

import objects.*;

public abstract class World {
	
	protected int iteration = 0;

	protected ArrayList<Predator> predator = new ArrayList<Predator>();
	protected ArrayList<Proie> proie = new ArrayList<Proie>();
	protected ArrayList<Plante> plante = new ArrayList<Plante>();
	protected ArrayList<UniqueObject> uniqueObjects = new ArrayList<UniqueObject>();
    
	protected int dxCA;
	protected int dyCA;

	protected int indexCA;

	//protected CellularAutomataInteger cellularAutomata; // TO BE DEFINED IN CHILDREN CLASSES
    
	protected CellularAutomataDouble cellsHeightValuesCA;
	protected CellularAutomataDouble cellsHeightAmplitudeCA;
	
	public CellularAutomataColor cellsColorValues;

	private double maxEverHeightValue = Double.NEGATIVE_INFINITY;
	private double minEverHeightValue = Double.POSITIVE_INFINITY;

    public World( )
    {
    	// ... cf. init() for initialization
    }
    
    public void init( int __dxCA, int __dyCA, double[][] landscape )
    {
    	dxCA = __dxCA;
    	dyCA = __dyCA;
    	
    	iteration = 0;

    	this.cellsHeightValuesCA = new CellularAutomataDouble (__dxCA,__dyCA,false);
    	this.cellsHeightAmplitudeCA = new CellularAutomataDouble (__dxCA,__dyCA,false);
    	
    	this.cellsColorValues = new CellularAutomataColor(__dxCA,__dyCA,false);
    	
    	// init altitude and color related information
    	for ( int x = 0 ; x != dxCA ; x++ )
    		for ( int y = 0 ; y != dyCA ; y++ )
    		{
    			// compute height values (and amplitude) from the landscape for this CA cell 
    			double minHeightValue = Math.min(Math.min(landscape[x][y],landscape[x+1][y]),Math.min(landscape[x][y+1],landscape[x+1][y+1]));
    			double maxHeightValue = Math.max(Math.max(landscape[x][y],landscape[x+1][y]),Math.max(landscape[x][y+1],landscape[x+1][y+1])); 
    			
    			if ( this.maxEverHeightValue < maxHeightValue )
    				this.maxEverHeightValue = maxHeightValue;
    			if ( this.minEverHeightValue > minHeightValue )
    				this.minEverHeightValue = minHeightValue;
    			
    			cellsHeightAmplitudeCA.setCellState(x,y,maxHeightValue-minHeightValue);
    			cellsHeightValuesCA.setCellState(x,y,(minHeightValue+maxHeightValue)/2.0);

    			 //TODO! Default coloring
    	    	// init color information
    	        /*if ( this.cellsHeightAmplitudeCA.getCellState(x,y) >= 0.0 )
    	        {
    				float color[] = { (float)getHeight()*4.0f, 1.0f-(float)getHeight()*0.3f, (float)getHeight()*2.0f };
    				this.cellsColorValues.setCellState(x,y,color);
    	        }
    	        else
    	        {
    	        	// water
    				float color[] = { (float)(-getHeight()), 1.0f-(float)(-getHeight())*0.3f, (float)1.0f };
    				this.cellsColorValues.setCellState(x,y,color);
    	        }
    	        */
    		}
    	
    	initCellularAutomata(__dxCA,__dyCA,landscape);

    }
    
    
    public void step()
    {
    	stepCellularAutomata();
    	stepVie();
    	iteration++;
    }
    
    public int getIteration()
    {
    	return this.iteration;
    }
    
    abstract protected void stepVie();
    
    // ----

    protected abstract void initCellularAutomata(int __dxCA, int __dyCA, double[][] landscape);
    
    protected abstract void stepCellularAutomata();
    
    // ---
    
    abstract public int getCellValue(int x, int y); // used by the visualization code to call specific object display.

    abstract public void setCellValue(int x, int y, int state);
    
    // ---- 
    
    public double getCellHeight(int x, int y) // used by the visualization code to set correct height values
    {
    	return cellsHeightValuesCA.getCellState(x%dxCA,y%dyCA);
    }
    
    // ---- 
    
    public float[] getCellColorValue(int x, int y) // used to display cell color
    {
    	float[] cellColor = this.cellsColorValues.getCellState( x%this.dxCA , y%this.dyCA );

    	float[] color  = {cellColor[0],cellColor[1],cellColor[2],1.0f};
        
        return color;
    }

	abstract public void displayObjectAt(World _myWorld, GL2 gl, int cellState, int x,
			int y, double height, float offset,
			float stepX, float stepY, float lenX, float lenY,
			float normalizeHeight); 

	public void displayUniqueObjects(World _myWorld, GL2 gl, int offsetCA_x, int offsetCA_y, float offset,
			float stepX, float stepY, float lenX, float lenY, float normalizeHeight) 
	{
    	for ( int i = 0 ; i < uniqueObjects.size(); i++ ){
    		
    		uniqueObjects.get(i).displayUniqueObject(_myWorld,gl,offsetCA_x,offsetCA_y,offset,stepX,stepY,lenX,lenY,normalizeHeight);
    	}
    	for ( int i = 0 ; i < predator.size(); i++ ){
    		predator.get(i).displayUniqueObject(_myWorld,gl,offsetCA_x,offsetCA_y,offset,stepX,stepY,lenX,lenY,normalizeHeight);
    	}
    	for ( int i = 0 ; i < plante.size(); i++ ){
    		plante.get(i).displayUniqueObject(_myWorld,gl,offsetCA_x,offsetCA_y,offset,stepX,stepY,lenX,lenY,normalizeHeight);
    	}
    	for ( int i = 0 ; i < proie.size(); i++ ){
    		proie.get(i).displayUniqueObject(_myWorld,gl,offsetCA_x,offsetCA_y,offset,stepX,stepY,lenX,lenY,normalizeHeight);
    	}
	}
    
	public int getWidth() { return dxCA; }
	public int getHeight() { return dxCA; }
	public ArrayList<Predator> getPredator(){
		return predator;
	}
	public ArrayList<Proie> getProie(){
		return proie;
	}
	public ArrayList<Plante> getPlante(){
		return plante;
	}

	public double getMaxEverHeight() { return this.maxEverHeightValue; }
	public double getMinEverHeight() { return this.minEverHeightValue; }
	

}
