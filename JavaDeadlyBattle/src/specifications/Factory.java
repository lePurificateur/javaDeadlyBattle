package specifications;

import moulinette.GeneralFactory;


/**
 * Cette classe est la racine &agrave; que la moulinette va utiliser.
 * Chacune de ces fonctions doit retourner une impl&eacute;mentation vous avez cr&eacute;&eacute;e pour
 * r&eacute;soudre les probl&egrave;mes de l'&eacute;nonc&eacute;.  
 *
 */

public interface Factory extends GeneralFactory 
{
	/**
	 * Retourne une instance de votre impl&eacute;mentation de Homme.
	 */
	
	public Homme getHomme();
	
	/**
	 * Retourne une instance de votre impl&eacute;mentation de Femme.
	 */
	
	public Femme getFemme();
	
	/**
	 * Retourne une instance de votre file d'attente.
	 */
	
	public <T> FileAttente<T> getFileAttente();
	
	/**
	 * Retourne une instance de votre file d'attente avec Priorit&eacute;s.
	 */
	
	public <T extends IPriorite> FileAttenteAvecPriorite<T> getFileAttenteAvecPriorite();
}
