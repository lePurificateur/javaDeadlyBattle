package emmanuel;
import java.util.ArrayList;
import specifications.FileAttente;


public class FileAttenteClass<T> implements FileAttente<T> {

	private ArrayList<T> list = new ArrayList<T>();

	
	public boolean estVide() 
	{	
		return list.isEmpty(); 
	}

	@Override
	public boolean enlevePremier() 
	{
		return list.remove(0) != null;
	}

	@Override
	public T premier() 
	{
		if (estVide())
			{
			  return null;
			}
		else
		{
		return list.get(0);
		}
	}

	public void ajoute(T item) 
	{
		list.add(item);	
	}

}