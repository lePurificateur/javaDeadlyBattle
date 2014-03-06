package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Random;

import specifications.*;
import moulinette.Note;
import moulinette.TestCase;

public class TestFile implements TestCase<specifications.Factory>
{
	private Note note;
	private Factory factory;
	
	@Override
	public double getDenominator()
	{
		return 8;
	}

	@Override
	public String getName()
	{
		return "File";
	}

	private void testFile1a5()
	{
		specifications.FileAttente<MockPriorite> file  = null;
		try
		{
			file = factory.getFileAttente();
			note.stepNote(file != null, "Factory has return null file.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		testFileGeneral(0, file);
	}
	
	private void testFilePriorites1a5()
	{
		specifications.FileAttenteAvecPriorite<MockPriorite> file  = null;
		try
		{
			file = factory.getFileAttenteAvecPriorite();
		}
		catch(Exception e)
		{
		}
		testFileGeneral(0, file);
	}

	private void testFileGeneral(int priorite, FileAttente<MockPriorite> file)
	{
		try
		{
			note.stepNote(file != null, "Factory has return null file.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(file.estVide(), "The file should be empty.");
			for (int i = 0 ; i < 5  ; i++)
				file.ajoute(new MockPriorite(priorite, i));
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(!file.estVide(), "The file should not be empty.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			boolean res = true;
			for (int i = 0 ; i < 5  ; i++)
			{
				MockPriorite mp = file.premier();
				file.enlevePremier();
				res = res && mp.getId() == i;
			}
			note.stepNote(res, "premier() should have return 1, 2, 3, 4 and 5.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(file.estVide(), "The file should be empty.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}		
	}

	
	private void testFileTorduGeneral(specifications.FileAttente<MockPriorite> file, List<MockPriorite> before)
	{
		List<MockPriorite> after = new LinkedList<MockPriorite>(), 
				expected = new LinkedList<MockPriorite>();
		TreeSet<MockPriorite> inside = new TreeSet<MockPriorite>();
		int nbTests = before.size();
		Random r = new Random();
		try	
		{
			int i = 0;
			while (i < nbTests || after.size() < nbTests)
			{
				if (inside.size() == 0 || i < nbTests && r.nextBoolean())
				{
					file.ajoute(before.get(i));
					inside.add(before.get(i));
					i++;
				}
				else
				{
					MockPriorite premier = file.premier();
					after.add(premier);
					file.enlevePremier();
					expected.add(inside.first());
					inside.remove(inside.first());
				}
			}
			note.stepNote(expected.equals(after), "The " + nbTests + " random values returned mismatch.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(file.estVide(), "The file should be empty.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
	}

	private void testFileTordu()
	{
		specifications.FileAttente<MockPriorite> file  = null;
		List<MockPriorite> before = new ArrayList<MockPriorite>();
		int nbTests = 500;
		for (int i = 0 ; i < nbTests ; i++)
			before.add(new MockPriorite(0, i));
		try
		{
			file = factory.getFileAttente();
		}
		catch(Exception e)
		{
		}
		testFileTorduGeneral(file, before);
	}
	
	private void testFilePrioritesAleatoires()
	{
		specifications.FileAttenteAvecPriorite<MockPriorite> file = null;
		List<MockPriorite> before = new ArrayList<MockPriorite>();
		Random r = new Random();
		int nbTests = 500;
		int nbPriorites = 100; 
		int i = 0;
		while (i < nbTests)
		{
			MockPriorite mp = new MockPriorite(r.nextInt()%nbPriorites, i);
			before.add(mp);
			i++;
		}
		try
		{
			file = factory.getFileAttenteAvecPriorite();
		}
		catch(Exception e)
		{
		}
		testFileTorduGeneral(file, before);
	}

	@Override
	public Note run(Factory factory)
	{
		note = new Note();
		this.factory = factory;
		testFile1a5();
		testFileTordu();
		testFilePriorites1a5();
		testFilePrioritesAleatoires();
		return note;
	}
}
