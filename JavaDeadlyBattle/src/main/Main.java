package main;

import moulinette.Moulinette;

/**
 * Classe de test.
 * Pour lancer la moulinette, il vous suffit d'appeler la 
 * m&eacute;thode statique simpleMoulinette 
 * en lui passant votre factory en param&egrave;tre.
<PRE>
simpleMoulinette(new votrePackage.Factory());
</PRE><P>
 */

public class Main
{
	/**
	  * Lance la moulinette sur la factory pass&eacute;e 
	  * en param&egrave;tre.
	 */
	
	public static void simpleMoulinette(specifications.Factory factory)
	{
		Moulinette<specifications.Factory, moulinette.TestCase<specifications.Factory>> m = 
				new Moulinette<specifications.Factory, moulinette.TestCase<specifications.Factory>>();
		m.addFactory(factory);
		m.addTestCase(new TestNom());
		m.addTestCase(new TestArbre());
		m.addTestCase(new TestFile());
		m.run();
	}
	
	public static void main(String[] args)
	{
		Moulinette<specifications.Factory, moulinette.TestCase<specifications.Factory>> m = 
				new Moulinette<specifications.Factory, moulinette.TestCase<specifications.Factory>>();
		m.addTestCase(new TestNom());
		m.addTestCase(new TestArbre());
		m.addTestCase(new TestFile());
		
		m.addFactory(new Abbach.TheFactory());
		m.addFactory(new autiergabriel.TheFactory());
		m.addFactory(new javacodefight.Factoryperso());
		m.addFactory(new emmanuel.FactoryClass());
		m.addFactory(new javabattle.javabattle());
		m.addFactory(new CalbaBaptiste.Factory2());
		m.addFactory(new delespaul.Factoryclass());
		m.addFactory(new doan.Factory1());
		m.addFactory(new TomGermain.Factory1());
		m.addFactory(new Goldstein.FactoryAG());
		m.addFactory(new kadricArmin.MonFactory());
		m.addFactory(new phamv.Factory_());
		m.addFactory(new tp.TPFactory());
		m.addFactory(new Rossignol.Rossignolt());
		m.addFactory(new SANAA.FactoryClass());
		m.addFactory(new SanchezAnthony.TheFactory());
		m.addFactory(new YT.YTFactory());
		m.addFactory(new specifications.FactoryA());
		m.addFactory(new Wampe.FactoryPW());
		m.addFactory(new louzito.FactoryLou());
		m.addFactory(new corrige.Factory());
		m.run();
	}
	
}
