package fr.polytech.projectjava.mainapp.jfx.dialogs.createcheck;

import fr.polytech.projectjava.mainapp.company.staff.checking.CheckInOut;
import fr.polytech.projectjava.mainapp.company.staff.checking.EmployeeCheck;
import fr.polytech.projectjava.utils.Log;
import javafx.event.ActionEvent;
import static fr.polytech.projectjava.mainapp.company.staff.checking.CheckInOut.CheckType.IN;
import static fr.polytech.projectjava.mainapp.company.staff.checking.CheckInOut.CheckType.OUT;

/**
 * Controller for the check dialog.
 * <p>
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 27/04/2017.
 *
 * @author Thomas Couchoud
 * @since 2017-04-27
 */
public class CheckCreateDialogController
{
	private final CheckCreateDialog view;
	
	/**
	 * Constructor.
	 *
	 * @param view The parent view.
	 */
	public CheckCreateDialogController(CheckCreateDialog view)
	{
		this.view = view;
	}
	
	/**
	 * Verify if the check is a valid one.
	 * If it is the case, it builds it and closes the popup.
	 *
	 * @param actionEvent The click event.
	 */
	public void valid(ActionEvent actionEvent)
	{
		if(view.getEmployee() != null && view.getDate() != null && (view.getInTime() != null || view.getOutTime() != null))
		{
			try
			{
				EmployeeCheck check = new EmployeeCheck(view.getEmployee(), view.getDate());
				if(view.getInTime() != null)
					check.setIn(new CheckInOut(IN, view.getDate(), view.getInTime()));
				if(view.getOutTime() != null)
					check.setIn(new CheckInOut(OUT, view.getDate(), view.getOutTime()));
				view.setResult(check);
				view.close();
			}
			catch(IllegalArgumentException e)
			{
				Log.warning("Error creating the check", e);
			}
		}
	}
}
