package specifications;

import java.util.List;

/**
 * Repr&eacute;sente un arbre g&eacute;n&eacute;alogique.
 */

public interface Personne
{
	/**
	 * Retourne le nom de la personne.
	 */

	public String getNom();

	/**
	 * Retourne le pr&eacute;nom de la personne.
	 */

	public String getPrenom();

	/**
	 * Retourne le p&egrave;re de la personne.
	 */

	public Homme getPere();

	/**
	 * Retourne la m&egrave;re de la personne.
	 */

	public Femme getMere();

	/**
	 * Change le nom de la personne.
	 */

	public void setNom(String nom);

	/**
	 * Change le pr&eacute;nom de la personne.
	 */

	public void setPrenom(String prenom);

	/**
	 * D&eacute;termine le p&egrave;re de la personne.
	 */

	public void setPere(Homme pere);

	/**
	 * D&eacute;termine la m&egrave;re de la personne.
	 */

	public void setMere(Femme mere);

	/**
	 * Retourne le nombre d'enfant de la personne.
	 */

	public int getNbEnfants();

	/**
	 * Retourne l'enfant d'indice i de la personne.
	 */

	public Personne getEnfant(int index);

	/**
	 * Ajoute un enfant.
	 */

	public void addEnfant(Personne enfant);

	/**
	 * Retourne les enfants.
	 */

	public List<Personne> getEnfants();

	/**
	 * Retourne les parents.
	 */

	public List<Personne> getParents();

	/**
	 * Retourne les grands-parents.
	 */

	public List<Personne> getGrandParents();

	/**
	 * Retourne les petits-enfants.
	 */

	public List<Personne> getPetitsEnfants();

	/**
	 * Retourne les fr&egrave;res et soeurs.
	 */

	public List<Personne> getFreresEtSoeurs();

	/**
	 * Retourne les cousins (et cousines).
	 */

	public List<Personne> getCousins();
}