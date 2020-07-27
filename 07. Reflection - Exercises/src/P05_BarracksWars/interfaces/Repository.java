package P05_BarracksWars.interfaces;

import javax.naming.OperationNotSupportedException;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType) throws OperationNotSupportedException;
}
