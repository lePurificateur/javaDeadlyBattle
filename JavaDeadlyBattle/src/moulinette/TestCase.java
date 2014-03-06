package moulinette;

public interface TestCase<FactoryType>
{
	public double getDenominator();
	public String getName();
	public Note run(FactoryType factory);
}
