package P05_BarracksWars.core.factories;

import P05_BarracksWars.interfaces.Unit;
import P05_BarracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"P05_BarracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws NoSuchMethodException,
			ClassNotFoundException, IllegalAccessException,
			InvocationTargetException, InstantiationException {

		Class<?> unit = Class.forName(UNITS_PACKAGE_NAME + unitType);
		Constructor<?> constructor = unit.getDeclaredConstructor();
		return (Unit) constructor.newInstance();
	}
}
