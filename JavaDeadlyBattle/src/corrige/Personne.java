package corrige;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import specifications.Femme;
import specifications.Homme;

public abstract class Personne implements specifications.Personne
{
	private String nom, prenom;
	private Homme pere;
	private Femme mere;
	private ArrayList<specifications.Personne> enfants = new ArrayList<specifications.Personne>();
	
	@Override
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
		if (pere != null)
			pere.addEnfant(this);
	}

	@Override
	public void setMere(Femme mere)
	{
		this.mere = mere;
		if (mere != null)
			mere.addEnfant(this);
	}

	@Override
	public int getNbEnfants()
	{
		return enfants.size();
	}

	@Override
	public void addEnfant(specifications.Personne enfant)
	{
		if (!enfants.contains(enfant))
			enfants.add(enfant);
	}

	@Override
	public specifications.Personne getEnfant(int index)
	{
		return enfants.get(index);
	}
	
	@Override
	public List<specifications.Personne> getEnfants()
	{
		return new ArrayList<specifications.Personne>(enfants);
	}
	
	@Override
	public List<specifications.Personne> getParents()
	{
		List<specifications.Personne> parents = new ArrayList<specifications.Personne>();
		if (getPere() != null)
			parents.add(getPere());
		if (getMere() != null)
			parents.add(getMere());
		return parents;
	}	
	
	@Override
	public List<specifications.Personne> getGrandParents()
	{
		List<specifications.Personne> gp = new ArrayList<specifications.Personne>(),
				parents = getParents();
		for(specifications.Personne parent : parents)
			gp.addAll(parent.getParents());
		return gp;
	}
	
	@Override
	public List<specifications.Personne> getPetitsEnfants()
	{
		List<specifications.Personne> pe = new ArrayList<specifications.Personne>();
		for (specifications.Personne enfant : enfants)
			pe.addAll(enfant.getEnfants());
		return pe;
	}
	
	@Override
	public List<specifications.Personne> getFreresEtSoeurs()
	{
		Set<specifications.Personne> freres = new HashSet<specifications.Personne>(),
				parents = new HashSet<specifications.Personne>(getParents());
		for (specifications.Personne parent : parents)
			freres.addAll(parent.getEnfants());
		Iterator<specifications.Personne> iterator = freres.iterator();
		while (iterator.hasNext())
		{
			specifications.Personne frere = iterator.next();
			if (frere == this || frere.getMere() != getMere() || frere.getPere() != getPere())
				iterator.remove();
		}
		return new ArrayList<specifications.Personne>(freres);
	}
	
	@Override
	public List<specifications.Personne> getCousins()
	{
		List<specifications.Personne> cousins = new ArrayList<specifications.Personne>(),
				oncles = new ArrayList<specifications.Personne>(),
				parents = getParents();
		for (specifications.Personne parent : parents)
			oncles.addAll(parent.getFreresEtSoeurs());
		for (specifications.Personne oncle : oncles)
			cousins.addAll(oncle.getEnfants());
		return cousins;
	}
	
	@Override
	public String toString()
	{
		return getPrenom() + " " + getNom();
	}
}
