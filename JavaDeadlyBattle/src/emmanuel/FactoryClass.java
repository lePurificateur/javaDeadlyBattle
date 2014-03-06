package emmanuel;

import specifications.*;


public class FactoryClass implements Factory {

	public String getNom() 
	{
		return "BISCHOFF Emmanuel";
	}

	@Override
	public Homme getHomme() 
	{
        return new HommeClass();
	}

	@Override
	public Femme getFemme() 
	{	
		return new FemmeClass();
	}

	@Override
	public <T>FileAttente<T> getFileAttente() 
	{
		return new FileAttenteClass<T>();
	}

	@Override
	public <T extends IPriorite> FileAttenteAvecPriorite<T> getFileAttenteAvecPriorite() { 
		return new FileAttenteAvecPrioriteClass<T>();
	}
	public static void main(String[] args) {
		main.Main.simpleMoulinette(new FactoryClass());
	}
}