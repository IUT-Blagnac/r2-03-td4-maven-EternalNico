package lesschtroumpfs;
import static java.lang.System.out;

import java.util.ArrayList;


/**
 * @author Nico
 *
 */
public class Village {
	
	//Declaration des variables 
	private String nomV;
	private int StockSalsepareille;
	private ArrayList<Schtroumpf> schtroumpfs;
	private int nombreSchtroumpfs;
	
	//Constructeur 
	public Village (String nom, int qteSalsepareille, String[] nomsDesSchtroumpfs) {
	    this.nomV = nom;
	    this.schtroumpfs = new ArrayList <Schtroumpf>(100);
	    this.StockSalsepareille = qteSalsepareille;
	    this.nombreSchtroumpfs = nomsDesSchtroumpfs.length;
	     
	        
	    /*Cree et ajoute les Schtroumpfs*/
	    for (int i=0; i<this.nombreSchtroumpfs; i++) {
	        this.schtroumpfs.add(i, (new Schtroumpf(nomsDesSchtroumpfs[i],(int)(Math.random()*150),this)));
	    }
	} 
	
	    
        /**
         * Accesseur : accede au nom de l'objet
         * @return le nom du Schtroumpf
         */
        public String getNomV () {
		return this.nomV;
	    }
	    
	    
	     /**
	     * Permet d'obtenir le nombre de Schtroumpf au sein d'une liste  
	     * @return le nombre de Schtroumpf 
	     */
	    int getNbSchtroumpf() {
	    	 return this.nombreSchtroumpfs;
	     }
	    
	    
	     /**
	     * Permet d'ontenir le nombre de salslePareille au sein du village
	     * @return le nombre de salsePareille
	     */
	    int getStockSalepareille() {
	    	 return this.StockSalsepareille;
	     }
	     
	     
	     /**
	     * Permet de faire une presentation de chaque Schtroumpf au sein d'une liste 
	     * Permet egalement de faire chanter les Schtroumpf
	     * Cette procedure affiche a l'ecran les deux elements cites au dessus.
	     */
	    public void solstice_d_ete() {
	    	 int NbSchtHeureux = 0 ;
	    	 for (int i=0; i<this.nombreSchtroumpfs; i++) {
	    		 this.schtroumpfs.get(i).sePresenter();
	    		 this.schtroumpfs.get(i).chanter();
	    		 if (schtroumpfs.get(i).estContent() == true ) {
	    			 NbSchtHeureux += 1 ;
	    		 }
	 	   }
	    	 out.println(this.nomV);//Nom du village
	    	 out.println("Nombre de schtroumpfs dans le village : " + this.nombreSchtroumpfs);//Nombre de Schtroumpfs dans le village 
	    	 out.println("Le nombre de schtroumpfs content est : " + NbSchtHeureux);
	     }
	     
	     
	    /**
	     * Determine le chef du village ( le plus age ) 
	     * @return le Schtroumpf le plus age 
	     */
	    public Schtroumpf chefDuVillage() {
	    	 Schtroumpf AgeSchtMax = this.schtroumpfs.get(0) ;
	    	 for (int i=0; i<this.nombreSchtroumpfs; i++) {
	    		  if (this.schtroumpfs.get(i).getAge() > AgeSchtMax.getAge()) {
	    			  AgeSchtMax = this.schtroumpfs.get(i);
	    			  
	    		  }
	    	 }
	    	 return AgeSchtMax; 
	     }
	     
	    
	    /**
	     * Envoie au travail un Schtroumpf content sur deux uniquement, cette fonction rend malheureux la moitie des Schtroumpf heureux
	     */
	    public void envoyerAuTravail () {
	    	int compteLeNbDeSchtHeureux = 1;
    	 	for(int i = 0 ; i< this.nombreSchtroumpfs; i += 1) {
    	 		if(this.schtroumpfs.get(i).estContent() == true) {
    	 			compteLeNbDeSchtHeureux ++;
    	 		
    	 		    if (compteLeNbDeSchtHeureux % 2 == 0) {
    	 		        this.schtroumpfs.get(i).allerTravailler();
    	 		        compteLeNbDeSchtHeureux = 0;
    	 		        
    	 		     } 
    	 		}
    	 	}
	     }
	     
	     
	     /**
	     * Determine les Schtroumpf heureux
	     */
	    public void schtroumpsfHeureux () {
	    	 for (int i=0; i<this.nombreSchtroumpfs; i++) {
	    		  if (this.schtroumpfs.get(i).estContent() == true ) {
	    			  this.schtroumpfs.get(i).sePresenter();
	    			  this.schtroumpfs.get(i).chanter();
	    		  }
	         }
	      
	     }
	     
	     /**
	     * Permet d'aggrandir le stock de salePareille du village 
	     * @param pfSalePareilleEnPlus : le nombre de salePareille a ajouter
	     */
	    public void setStockSalePareille(int pfSalePareilleEnPlus) {
	    	 this.StockSalsepareille +=  pfSalePareilleEnPlus;
	     }
	     
	     /**
	     * Organise un repas commun
	     * Ou ne fait pas manger les ermites
	     */
	    public void dinerTousEnsemble() {
	    	 for (int i=0; i<this.nombreSchtroumpfs; i++) {
				 if (this.schtroumpfs.get(i).village != null)
	    		     this.schtroumpfs.get(i).dinerAuVillage();
				  else 
						this.schtroumpfs.get(i).pasManger();
	    		 }
	     }
	    
	    
	     /**
	     * Envoie cueillir un Schtroumpf content sur deux uniquement, cette fonction rend malheureux la moitie des Schtroumpf heureux
	     */
	    public void envoyerCueillirSalsepareille() {
	    	 int compteLeNbDeSchtHeureux = 1;
	    	 	for(int i = 0 ; i< this.nombreSchtroumpfs; i += 1) {
	    	 		if(this.schtroumpfs.get(i).estContent() == true) {
	    	 			compteLeNbDeSchtHeureux ++;
	    	 		
	    	 		    if (compteLeNbDeSchtHeureux % 2 == 0) {
	    	 		        this.schtroumpfs.get(i).recolterSalsepareille(5);
	    	 		        compteLeNbDeSchtHeureux = 0;
	    	 		        
	    	 		     } 
	    	 		}
	    	 	}
	     }
	     	    
}
