package fr.polytech.projectjava.company.departments;

import fr.polytech.projectjava.company.Company;
import fr.polytech.projectjava.company.staff.Boss;
import fr.polytech.projectjava.company.staff.Manager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 23/03/2017.
 *
 * @author Thomas Couchoud
 * @since 2017-03-23
 */
public class ManagementDepartmentTest
{
	private Boss boss;
	private ManagementDepartment department;
	private Company company;
	
	@Before
	public void setUp()
	{
		boss = new Boss("A", "B");
		company = new Company("A", boss);
		
		department = new ManagementDepartment(company, boss);
	}

	@Test
	public void getManager() throws Exception
	{
		assertEquals(boss, department.getManager());
	}
	
	@Test
	public void autoAddManagers() throws Exception
	{
		Manager manager1 = new Manager("A", "B");
		Manager manager2 = new Manager("A", "B");
		
		StandardDepartment department = new StandardDepartment(company, "A", manager1);
		manager2.setWorkingDepartment(department);
		
		assertTrue(company.getManagementDepartment().hasEmployee(manager1));
		assertFalse(company.getManagementDepartment().hasEmployee(manager2));
		
		department.setManager(manager2);
		
		assertFalse(company.getManagementDepartment().hasEmployee(manager1));
		assertTrue(company.getManagementDepartment().hasEmployee(manager2));
	}
}