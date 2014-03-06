package moulinette;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**<P>
 * Classe de test automatique de une ou plusieurs impl&eacute;mentations d'une factory.
 * </P>
 */

public class Moulinette<FactoryType extends GeneralFactory, TestCaseType extends TestCase<FactoryType>>
{
	private List<FactoryType> factories;
	private List<TestCaseType> testCases;
	private Map<FactoryType, Note> notes;
	
	public Moulinette()
	{
		testCases = new ArrayList<TestCaseType>();
		factories = new ArrayList<FactoryType>();
		notes = new HashMap<FactoryType, Note>();
	}
	
	public void addFactory(FactoryType factory)
	{
		factories.add(factory);
	}
	
	public void addTestCase(TestCaseType testCase)
	{
		testCases.add(testCase);
	}
	
	private Note run(FactoryType factory, TestCaseType testCase)
	{
		System.out.print("testing " + testCase.getName() + " :\n");
		Note note = testCase.run(factory);
		note.rescale(testCase.getDenominator());
		System.out.println("" + note);
		return note;
		
	}
	
	private void run(FactoryType factory)
	{
		System.out.println("************************************************\nNom = " 
				+ factory.getNom() + " : ");
		Note note = new Note();
		for (TestCaseType testCase : testCases)
			note = note.add(run(factory, testCase));
		note.rescale(20);
		System.out.println("Tests finished, total = " + note);
		notes.put(factory, note);
	}
	
	
	public void run()
	{
		for (FactoryType factory : factories)
			run(factory);
		System.out.println("******************************************\nResults : ");
		for (FactoryType factory: factories)
			System.out.println("* " + factory.getNom() + " : " + notes.get(factory).getNote());
	}
}
