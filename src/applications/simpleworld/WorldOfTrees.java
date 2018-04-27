// ### WORLD OF CELLS ### 
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package applications.simpleworld;

import java.util.Random;

import com.jogamp.opengl.GL2;

import lsystem.Tree;
import objects.*;
import worlds.World;

public class WorldOfTrees extends World {

    protected ForestCA cellularAutomata;

    public void init ( int __dxCA, int __dyCA, double[][] landscape )
    {
    	super.init(__dxCA, __dyCA, landscape);
    	
    	// add colors
    	
    	for ( int x = 0 ; x < __dxCA ; x++ )
    		for ( int y = 0 ; y < __dyCA ; y++ )
    		{
	        	float color[] = new float[3];

	        	float height = (float) this.getCellHeight(x, y);
		    	
		        if ( height >= 0.0&&height <0.10)
		        {
		        	// snowy mountains
		        	/*
		        	color[0] = height / (float)this.getMaxEverHeight();
					color[1] = height / (float)this.getMaxEverHeight();
					color[2] = height / (float)this.getMaxEverHeight();
					/**/
		        	
					// green mountains
		        	
		        	color[0] = height / ( (float)this.getMaxEverHeight() );
					color[1] = 0.9f + 0.1f * height / ( (float)this.getMaxEverHeight() );
					color[2] = height / ( (float)this.getMaxEverHeight() );
					/**/
		        }
		        
		        else if(height>0.10){
		        	color[0] = 0.90f + 0.1f * height / ( (float)this.getMaxEverHeight() );
					color[1] = 0.01f*(height / ( (float)this.getMaxEverHeight() ));
					color[2] = 0.01f*(height / ( (float)this.getMaxEverHeight() ));
		        	
		        }
		        else
		        {
		        	// water
					color[0] = -height;
					color[1] = -height;
					color[2] = 1.f;
		        }
		        this.cellsColorValues.setCellState(x, y, color);
    		}
    	
    	// add some objects
    	for ( int i = 0 ; i < 11 ; i++ )
    	{
    		if ( i%10 == 0 )
    			uniqueObjects.add(new Monolith(110,110+i,this));
    		else
    			uniqueObjects.add(new BridgeBlock(110,110+i,this));
    	}
    	
    	//predator.add(new Predator(100,100,this));
    	for(int i=0;i<5;i++){
    	predator.add(new Predator((int)(Math.random()*200),(int)(Math.random()*200),this));
    	
    	
    	proie.add(new Proie((int)(Math.random()*200),(int)(Math.random()*200),this));
    	}
    	/*predator.add(new Predator(10,10,this));
    	proie.add(new Proie(190,190,this));
    	proie.add(new Proie(40,40,this));*/
    	plante.add(new Plante(50,50,this));
    }
    
    protected void initCellularAutomata(int __dxCA, int __dyCA, double[][] landscape)
    {
    	cellularAutomata = new ForestCA(this,__dxCA,__dyCA,cellsHeightValuesCA);
    	cellularAutomata.init();
    }
    
    protected void stepCellularAutomata()
    {
    	if ( iteration%10 == 0 )
    		cellularAutomata.step();
    }
    
    protected void stepVie()
    {
    	// nothing to do.
    	int length=predator.size();
    	for ( int i = 0 ; i < length ; i++ )
    	{
    		if(predator.get(i).alive){
    		this.predator.get(i).step();
    		}
    		else{
    			predator.remove(i);
    			length=predator.size();
    		}
    	}
    	length= this.proie.size();
    	for ( int i = 0 ; i <length  ; i++ )
    	{
    		
        		if(proie.get(i).alive){
        		this.proie.get(i).step();
        		}
        		else{
        			proie.remove(i);
        			length=proie.size();
        		}
        	}
    	length= this.plante.size();
    	for ( int i = 0 ; i < this.plante.size();  i++ )
    	{   
    		if(plante.get(i).alive){
        		this.plante.get(i).step();
        		}
        		else{
        			plante.remove(i);
        			length=this.plante.size();
        		}
    	}
    }

    public int getCellValue(int x, int y) // used by the visualization code to call specific object display.
    {
    	return cellularAutomata.getCellState(x%dxCA,y%dyCA);
    }

    public void setCellValue(int x, int y, int state)
    {
    	cellularAutomata.setCellState( x%dxCA, y%dyCA, state);
    }
    
	public void displayObjectAt(World _myWorld, GL2 gl, int cellState, int x,
			int y, double height, float offset,
			float stepX, float stepY, float lenX, float lenY,
			float normalizeHeight)
	{
		switch ( cellState )
		{
		case 1: // trees: green, fire, burnt
		case 2:
		case 3:
			Tree.displayObjectAt(_myWorld,gl,cellState, x, y, height, offset, stepX, stepY, lenX, lenY, normalizeHeight);
		default:
			// nothing to display at this location.
		}
	}

	//public void displayObject(World _myWorld, GL2 gl, float offset,float stepX, float stepY, float lenX, float lenY, float heightFactor, double heightBooster) { ... } 
    
   
}
