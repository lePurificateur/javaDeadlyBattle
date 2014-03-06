package corrige;

import java.util.LinkedList;

public class FileAttente<T> implements specifications.FileAttente<T>
{
	private LinkedList<T> file = new LinkedList<T>();

	@Override
	public boolean estVide()
	{
		return file.size() == 0;
	}

	@Override
	public boolean enlevePremier()
	{
		if (estVide())
			return false;
		file.poll();
		return true;
	}

	@Override
	public T premier()
	{
		return file.peekFirst();
	}

	@Override
	public void ajoute(T item)
	{
		file.add(item);
	}
}
