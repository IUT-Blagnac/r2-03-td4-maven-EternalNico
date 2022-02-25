package lesschtroumpfs;
import static java.lang.System.out;

/**
 * @author Nico
 *
 */
public class Schtroumpf {
	
	//Déclaration des variables 
	private String nom;
	private int age;
	private boolean estHappy;
	public Village village;
	
	//Constructeur sans paramêtres
	Schtroumpf(){
		this.nom = "Inconnue";
		this.age = 0;
		this.estHappy = true;
		this.village = null ;
	}
	
	//Constructeur avec paramêtres
	public Schtroumpf(String pfNom, int pfAge){
		this.nom = pfNom;
		this.age = pfAge;
		this.estHappy = true;
		this.village = null;
	}
	
	public Schtroumpf(String pfNom, int pfAge, Village pfNomVillageNaissance){
			this.nom = pfNom;
			this.age = pfAge;
			this.estHappy = true;
			this.village = pfNomVillageNaissance;
		}
		
		
	 //Méthodes 
	 /**
	 * Retourne le nom d'un Schtroumpf
	 * @return le nom du Schtroumpf
	 */
	public String getNom() {
		return this.nom;
	}
	 
	 /**
	 * Retourne l'age d'un Schtroumpf
	 * @return l'age du Schtroumpf
	 */
	 public int getAge() {	
		 return this.age;	 
	 }
	 
	 /**
	 * Permet de savoir l'etat du Schtroumpf
	 * @return true si il est content sinon false
	 */
	 public boolean estContent() {
		 return this.estHappy;
	 }
	
	
	/**
	 * Met sous forme de chaine de caractère un message contenant des informations correspondantes à un Schtroumpf
	 * @return un des messages en fonction de l'état de du Schtroumpf et de si il possède un village 
	 */
	public  String toString() {
		String chaine = "Je suis ";
		String chaine2 = " ans et je suis content, j'habite dans le village nommé : ";
		String chaine5 = " ans et je suis PAS content, j'habite dans le village nommé : ";
		String chaine3 = " ans et je suis Pas content, je suis ermite";
		String chaine6 = "ans et je suis content, je suis ermite";
		String chaine4 = ", j'ai ";
		if(this.estHappy == true && this.getVillage() != null) 
			return  chaine + this.nom + chaine4 + this.age + chaine2 + this.village.getNomV();
		
		else if(this.estHappy == false && this.getVillage() != null) {
			return  chaine + this.nom + chaine4 + this.age + chaine5 + this.village.getNomV(); 
			
		}else if (this.estHappy == true && this.getVillage() == null) {
			return chaine + this.nom + chaine4 + this.age + chaine6;
			
		}else {
			return	chaine + this.nom + chaine4 + this.age + chaine3;
		}	
	}
	
	
	/**
	 * Affiche à l'écran le résultat de la fonction toString
	 */
	public void sePresenter() {
		out.println(this.toString());
	}
	

	/**
	 * Met sous forme de chaine de caractère un message de chant 
	 * @return un des chants en fonction de l'état du Schtroumpf
	 */
	public String leChant() {
		String message1 = "la, la, la Schtroumpf la, la";
		String message2 = "gloups";
		
		if(this.estHappy == true ) 
			return message1;
		else 
			return message2;
	}
	
	/**
	 * Permet de faire chanter un Schtroumpf
	 * Affiche à l'écran le résultat de la fonction leChant
	 */
	public void chanter() {
		out.println(this.leChant());
	}
	
	
	 /**
	 * Ajoute un ans de plus à un Schtroumpf (c'est son anniversaire), la procédure affiche le nouvel âge du Schtroumpf
	 */
	public void anniversaire() {
		int ageSchtroumpf =  this.age + 1;
		 out.println("Le Schtroumpf à " + ageSchtroumpf + " ans.");
	 }
	
 
	/**
	 * Permet à un Schtroumpf de manger une quantité de salePareille renseignée en paramètre formel
	 * @param pfQte IN : Quantité de salePareille à manger
	 */
	public void manger (int pfQte) {
		 if (pfQte > 0 && this.estHappy == false) {
			 this.estHappy = true;
		 }
	 }
	
	/**
	 * Permet de ne pas faire manger un schtroumpf, il devient triste
	 */
	public void pasManger () {
			 this.estHappy = false;
	 }
	 
	 //Question 6 
	/**
	 * Permet de faire travailler un Schtroumpf,en contre partie, le Schtroumpf devient triste 
	 */
	public void allerTravailler() {
		 this.estHappy = false;
	 }
	
	
	
    /**
     * Accesseur : permet de retourner le village de l'objet
     * @return le village du Schtroumpf
     */
    public Village getVillage() {
    	return this.village;
    }
	
    /**
     * Setteur : permet de modifier le village de l'objet
     * @param pfVillage IN : le nouveau village 
     */
    public void setVillage(Village pfVillage) {
		this.village = pfVillage;
    }
    
    /**
     * Permet à un Schtroumpf de récolter des salePareille
     * En revanche, c'est comme pour le travail, le Schtroumpf devient triste du fait d'aller faire les provisions
     * @param pfNbSalePareille IN : quantité de salePareille à récolter
     */
    public void recolterSalsepareille(int pfNbSalePareille) {
    	this.village.setStockSalePareille(pfNbSalePareille);
    	this.estHappy = false;
    }
    
    /**
     * Permet de réunir les Schtroumpf d'un village autour d'un repas
     */
    public void dinerAuVillage() {
    	if (this.village != null) {
    		this.manger(3);
    		this.village.setStockSalePareille(-3);
    	} else {
    		this.manger(5);

    	}
    }
    
}
