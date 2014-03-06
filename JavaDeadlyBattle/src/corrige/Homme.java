package corrige;

public class Homme extends Personne implements specifications.Homme
{
	@Override
	public void addEnfant(specifications.Personne enfant)
	{
		super.addEnfant(enfant);
		if (enfant.getPere() != this)
			enfant.setPere(this);
	}
}
