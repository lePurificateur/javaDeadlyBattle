package main;

import specifications.IPriorite;

public class MockPriorite implements IPriorite, Comparable<MockPriorite>
{
	private int priorite;
	private int id;
	
	public MockPriorite(int priorite, int id)
	{
		this.priorite = priorite;
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
	
	@Override
	public int getPriorite()
	{
		return priorite;
	}

	@Override
	public int compareTo(MockPriorite mp)
	{
		if (getPriorite() == mp.getPriorite())
		{
			if (getId() == mp.getId())
				return 0;
			if (getId() <  mp.getId())
				return -1;
			else
				return 1;
		}
		if (getPriorite() < mp.getPriorite())
			return 1;
		else
			return -1;
	}
	
	@Override
	public String toString()
	{
		return "(id = " + id + ", pr = " + priorite + ")";
	}
}
