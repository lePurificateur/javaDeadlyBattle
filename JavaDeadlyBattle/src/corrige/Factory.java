package corrige;

import specifications.FileAttente;
import specifications.FileAttenteAvecPriorite;
import specifications.IPriorite;

public class Factory implements specifications.Factory
{

	@Override
	public String getNom()
	{
		return "le Purificateur";
	}

	@Override
	public specifications.Homme getHomme()
	{
		return new Homme();
	}

	@Override
	public specifications.Femme getFemme()
	{
		return new Femme();
	}

	@Override
	public <T> FileAttente<T> getFileAttente()
	{
		return new corrige.FileAttente<T>();
	}

	@Override
	public <T extends IPriorite> FileAttenteAvecPriorite<T> getFileAttenteAvecPriorite()
	{
		return new corrige.FileAttenteAvecPriorite<T>();
	}
	
	public static void main(String[] args)
	{
		main.Main.simpleMoulinette(new corrige.Factory());
	}
}
