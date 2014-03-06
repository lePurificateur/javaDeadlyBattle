package specifications;

/**
 * Repr&eacute;sente une file d'attente.
 * Une file d'attente (FIFO) est une collection dans laquelle le premier 
 * &eacute;l&eacute;ment ins&eacute;r&eacute; est le premier &agrave; 
 * sortir. 
 */

public interface FileAttente<T>
{
	
	/**
	 * Retourne vrai ssi la file ne contient aucun &eacute;l&eacute;ment.
	 */
	
	public boolean estVide();

	/**
	 * Enl&egrave;ve l'&eacute;l&eacute;ment qui est depuis le 
	 * plus longtemps dans la file. 
	 **/
	
	public boolean enlevePremier();
	
	/**
	 * Retourne l'&eacute;l&eacute;ment qui est depuis le plus 
	 * longtemps dans la file. Retourne null si la file est vide.
	 */
	
	public T premier();
	
	/**
	 * Ajoute l'&eacute;l&eacute;ment item dans la file.
	 */

	public void ajoute(T item);
}
