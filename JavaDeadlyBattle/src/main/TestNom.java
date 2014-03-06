package main;

import specifications.Factory;
import moulinette.Note;
import moulinette.TestCase;

public class TestNom implements TestCase<specifications.Factory>
{

	@Override
	public Note run(Factory factory)
	{
		Note note = new Note();
		String nom = factory.getNom();
		note.stepNote(nom != null && !nom.equals(""));
		return note;
	}

	@Override
	public double getDenominator()
	{
		return 2;
	}

	@Override
	public String getName()
	{
		return "getName()";
	}
}

