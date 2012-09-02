package seg.jUCMNav.actions;

import grl.IntentionalElementRef;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

import seg.jUCMNav.JUCMNavPlugin;
import seg.jUCMNav.actions.hyperlinks.HyperlinkUtils;
import seg.jUCMNav.model.commands.create.ShowLinkedElementCommand;
import urn.URNspec;
import urncore.URNmodelElement;

/**
 * Action for showing linked element(s).
 * 
 * @author rouzbahan
 * 
 */
public class ShowLinkedElementAction extends URNSelectionAction
{
    public static final String SHOWLINKEDELEMENT = "seg.jUCMNav.ShowLinkedElementAction"; //$NON-NLS-1$
  
    private URNmodelElement element;
    private IntentionalElementRef elementRef;
    private URNspec urnspec;
    
    public ShowLinkedElementAction(IWorkbenchPart part)
    {
        super(part);
        
        setId(SHOWLINKEDELEMENT);
        setImageDescriptor(JUCMNavPlugin.getImageDescriptor("icons/ShowLinkedElement.gif")); //$NON-NLS-1$
    }
    
    /**
     * True if we have selected a valid URNmodelElement.
     */
    @SuppressWarnings("static-access")
	protected boolean calculateEnabled() 
    {
        List objects = getSelectedObjects();

        if (objects.size() != 1)
            return false;

        SelectionHelper sel = new SelectionHelper(objects);
        urnspec = sel.getUrnspec();
        element = HyperlinkUtils.findURNmodelElement(sel);
        
        if (sel.getSelectionType() == sel.INTENTIONALELEMENTREF)
        {
            elementRef = sel.getIntentionalElementRef(); 
            return true;
        } 
        else
            return false;
    }
    
    /**
     * Trying to Add linked element to environment.
     * 
     */
    protected Command getCommand() 
    {
        return new ShowLinkedElementCommand(urnspec, element, elementRef);
    }
}
