package moulinette;

public class Note
{
	private double note, denominateur;

	public Note()
	{
		note = 0;
		denominateur = 0;
	}
	
	public double getNote()
	{
		return note;
	}

	public void stepNote(boolean success)
	{
		denominateur ++;
		note += (success)? 1 : 0;
	}

	public void stepNote(double note)
	{
		this.note += note;
		denominateur++;
	}
	
	public double get()
	{
		return note/denominateur;
	}
	
	public void stepNote(boolean success, String message)
	{
		stepNote(success);
		if (success)
			System.out.println("-> test has succeeded");
		else
			System.out.println("-> test has failed : " + message);
	}

	public void stepNote(Exception e)
	{
		stepNote(false, e.getMessage());
		e.printStackTrace();
	}
	public double getDenominateur()
	{
		return denominateur;
	}

	private Note(double note, double denominateur)
	{
		this.note = note;
		this.denominateur = denominateur;
	}
	
	public Note add(Note n)
	{
		return new Note(note + n.getNote(), denominateur + n.getDenominateur());
	}
	
	@Override
	public String toString()
	{
		return "" + String.format("%.2f", note) + "/" + String.format("%.2f", getDenominateur()) + ((note == getDenominateur()) ? " AWESOME ! " : "");
	}
	
	public void rescale(double denominateur)
	{
		this.note = get() * denominateur;
		this.denominateur = denominateur;
	}
}
