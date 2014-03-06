package corrige;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class FileAttenteAvecPriorite<T 
	extends specifications.IPriorite>
	implements specifications.FileAttenteAvecPriorite<T>
{
	private SortedMap<Integer, FileAttente<T>> files = new TreeMap<Integer, FileAttente<T>>(new Comparator<Integer>()
	{
		@Override
		public int compare(Integer o1, Integer o2)
		{
			return -o1.compareTo(o2);
		}
	}); 
	
	@Override
	public boolean estVide()
	{
		for (SortedMap.Entry<Integer, FileAttente<T>> fileEntry : files.entrySet())
			if (!fileEntry.getValue().estVide())
				return false;
		return true;
	}

	@Override
	public boolean enlevePremier()
	{
		for (SortedMap.Entry<Integer, FileAttente<T>> fileEntry : files.entrySet())
			if (fileEntry.getValue().enlevePremier())
				return true;
		return false;
	}

	@Override
	public T premier()
	{
		for (SortedMap.Entry<Integer, FileAttente<T>> fileEntry : files.entrySet())
		{
			FileAttente<T> file = fileEntry.getValue(); 
			if (!file.estVide())
				return file.premier();
		}
		return null;
	}

	@Override
	public void ajoute(T item)
	{
		FileAttente<T> file = files.get(item.getPriorite());
		if (file == null)
		{
			file = new FileAttente<T>();
			files.put(item.getPriorite(), file);
		}
		file.ajoute(item);
	}
}
