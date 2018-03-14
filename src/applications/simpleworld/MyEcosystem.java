// ### WORLD OF CELLS ### 
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package applications.simpleworld;

import graphics.Landscape;

public class MyEcosystem {
    
	public static void main(String[] args) {

		WorldOfTrees myWorld = new WorldOfTrees();
		
		// param�tres:
		// 1: le "monde" (ou sont d�finis vos automates cellulaires et agents
		// 2: (ca d�pend de la m�thode : g�n�ration al�atoire ou chargement d'image)
		// 3: l'amplitude de l'altitude (plus la valeur est �lev�e, plus haute sont les montagnes)
		// 4: la quantit� d'eau
		//Landscape myLandscape = new Landscape(myWorld, 128, 128, 0.1, 0.7);
		Landscape myLandscape = new Landscape(myWorld, "landscape_paris-200.png", 0.2, 0.42);
		Landscape.run(myLandscape);
    }

}
