package main;

import java.util.List;

import specifications.*;
import moulinette.Note;
import moulinette.TestCase;

public class TestArbre implements TestCase<specifications.Factory>
{
	private Factory factory;
	private Note note;
	private Homme tywin, jaime, robert, joffrey, gendry;
	private Femme cersei, shireen;
	
	private static void initPersonne(Personne p, String prenom, String nom, Homme pere, Femme mere)
	{
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setPere(pere);
		p.setMere(mere);
	}

	private Homme getHomme(String prenom, String nom, Homme pere, Femme mere)
	{
		Homme res = factory.getHomme();
		initPersonne(res, prenom, nom, pere, mere);
		return res;
	}
	
	private Femme getFemme(String prenom, String nom, Homme pere, Femme mere)
	{
		Femme res = factory.getFemme();
		initPersonne(res, prenom, nom, pere, mere);
		return res;
	}

	private void testTywin()
	{
		tywin = null;
		try
		{
			tywin = factory.getHomme();
			tywin.setNom("Lannister");
			tywin.setPrenom("Tywin");
			note.stepNote(tywin.getNom().equals("Lannister") && tywin.getPrenom().equals("Tywin"), 
				"Tywin Lannister should be named Tywin Lannister.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
	}

	private void testCersei()
	{
		cersei = null;
		try
		{
			cersei = getFemme("Cersei", "Lannister", tywin, null);
			note.stepNote(cersei.getPere() == tywin,
					"The father of Cersei should be Tywin.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(tywin.getNbEnfants() == 1, 
					"Tywin should have only Cersei as a child.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(tywin.getEnfant(0) == cersei,
					"The index 0 daughter of Tywin should be Cersei.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
	}

	private void testJaime()
	{
		jaime = null;
		try
		{
			jaime = getHomme("Jaime", "Lannister", tywin, null);
			note.stepNote(jaime.getPere() == tywin,
					"The father of Jaime should be Tywin.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(tywin.getNbEnfants() == 2, 
					"Tywin should have Cersei and Jaime as children.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(tywin.getEnfant(1) == jaime,
					"The index 1 child of Tywin should be Jaime.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		List<Personne> jaimesSister = null;
		try
		{
			jaimesSister = jaime.getFreresEtSoeurs(); 
			note.stepNote(jaimesSister.size() == 1,
					"Jaime should have only one sister.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(jaimesSister.get(0) == cersei,
					"Jaime's sister should be Cersei.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
	}

	private void testRobert()
	{
		robert = null;
		try
		{
			robert = getHomme("Robert", "Baratheon", null, null);
			note.stepNote(robert.getFreresEtSoeurs().size() == 0, 
					"Robert has no brother.");
		}
		catch(Exception e)
		{
		}
	}
	
	private void testJoffrey()
	{
		joffrey = null;
		try
		{
			joffrey = getHomme("Joffrey", "Baratheon", robert, cersei);
			note.stepNote(joffrey.getPere() == robert,
					"Joffrey's father should be Robert.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(joffrey.getMere() == cersei,
					"Joffrey's mother should be Cersei.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		List<Personne> grandPa = null;
		try
		{
			grandPa = joffrey.getGrandParents();
			note.stepNote(grandPa.size() == 1,
					"Joffrey should have only one grandfather.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(grandPa.get(0) == tywin,
					"Joffrey's grandfather should be Tywin.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		List<Personne> grandSon = null;
		try
		{
			grandSon = tywin.getPetitsEnfants();
			note.stepNote(grandSon.size() == 1,
					"Tywin should have only one grand son.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(grandSon.get(0) == joffrey,
					"Tywin's grandson should be Joffrey.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
	}
	
	private void testGendry()
	{
		gendry= null;
		List<Personne> vide = null;
		try
		{
			gendry = getHomme("Gendry", "", robert, null);
			vide = gendry.getFreresEtSoeurs();
			note.stepNote(vide.size() == 0, 
				"Gendry and Joffrey don't have te same mother.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
	}

	private void testShireen()
	{
		List<Personne> couz = null; 
		Femme myrcella = null;
		try
		{
			Homme steffon = getHomme("Steffon", "Baratheon", null, null), 
					stannis = getHomme("Stannis", "Baratheon", steffon, null);
			myrcella = getFemme("Myrcella", "Baratheon", robert, cersei);
			steffon.addEnfant(robert);
			shireen = getFemme("Shireen", "Baratheon", stannis, null);
			couz = shireen.getCousins();
			note.stepNote(couz.size() == 3,
					"Shireen should have three cousins instead of " + couz + ".");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(couz.contains(joffrey),
					"Shireen should have Joffrey as a cousin.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(couz.contains(myrcella),
					"Shireen should have Myrcella as a cousin.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
		try
		{
			note.stepNote(couz.contains(gendry),
					"Shireen should have Gendry as a cousin.");
		}
		catch(Exception e)
		{
			note.stepNote(e);
		}
	}

	
	@Override
	public Note run(Factory factory)
	{
		note = new Note();
		this.factory = factory;
		testTywin();
		testCersei();
		testJaime();
		testRobert();
		testJoffrey();
		testGendry();
		testShireen();
		return note;
	}

	@Override
	public double getDenominator()
	{
		return 10;
	}

	@Override
	public String getName()
	{
		return "Arbre";
	}

}
