package emmanuel;
import java.util.List;
import specifications.Femme;
import specifications.Homme;
import specifications.Personne;


public class PersonneClass implements Personne {

	private String prenom;
	private String nom;
	private Homme pere;
	private Femme mere;
	private int NbEnfants = 1;
	
	public String getNom() 
	{
		return nom;
	}

	@Override
	public String getPrenom() 
	{
		return prenom;
	}

	@Override
	public Homme getPere() 
	{
		return pere;
	}

	@Override
	public Femme getMere() 
	{
		return mere;
	}

	@Override
	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	@Override
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}

	@Override
	public void setPere(Homme pere) 
	{
		this.pere = pere;
	}

	@Override
	public void setMere(Femme mere) 
	{
		this.mere = mere;
	}

	@Override
	public int getNbEnfants() 
	{
		return NbEnfants;	
	}

	@Override
	public Personne getEnfant(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEnfant(Personne enfant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Personne> getEnfants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> getParents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> getGrandParents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> getPetitsEnfants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> getFreresEtSoeurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> getCousins() {
		// TODO Auto-generated method stub
		return null;
	}

}