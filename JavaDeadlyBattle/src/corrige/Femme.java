package corrige;

public class Femme extends Personne implements specifications.Femme
{
	@Override
	public void addEnfant(specifications.Personne enfant)
	{
		super.addEnfant(enfant);
		if (enfant.getMere() != this)
			enfant.setMere(this);
	}
}
