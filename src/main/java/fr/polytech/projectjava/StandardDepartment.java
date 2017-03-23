package fr.polytech.projectjava;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 23/03/2017.
 *
 * @author Thomas Couchoud
 * @since 2017-03-23
 */
public class StandardDepartment extends Department
{
	private final Manager manager;

	public StandardDepartment(String name, Manager manager)
	{
		super(name);
		this.manager = manager;
	}

	public Manager getManager()
	{
		return manager;
	}

	@Override
	public String toString()
	{
		return super.toString() + "\nManager: \t" + getManager();
	}
}
