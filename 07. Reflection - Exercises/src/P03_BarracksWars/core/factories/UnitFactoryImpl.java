package P03_BarracksWars.core.factories;

import P03_BarracksWars.interfaces.Unit;
import P03_BarracksWars.interfaces.UnitFactory;
import P03_BarracksWars.models.units.AbstractUnit;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"P03_BarracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws NoSuchMethodException,
			ClassNotFoundException, IllegalAccessException,
			InvocationTargetException, InstantiationException {

		Class<?> unit = Class.forName(UNITS_PACKAGE_NAME + unitType);
		Constructor<?> constructor = unit.getDeclaredConstructor();
		return (Unit) constructor.newInstance();
	}
}
