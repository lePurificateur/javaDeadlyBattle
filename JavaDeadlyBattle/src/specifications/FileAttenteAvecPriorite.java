package specifications;

/**
 * Repr&eacute;sente une file d'attente dans laquelle les &eacute;l&eacute;ments de plus grande
 * priorit&eacute; sortiront les premiers. 
 */

public interface FileAttenteAvecPriorite<T extends IPriorite>
	extends FileAttente<T>
{
}
