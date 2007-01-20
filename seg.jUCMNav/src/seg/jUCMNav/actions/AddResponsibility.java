package seg.jUCMNav.actions;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import seg.jUCMNav.JUCMNavPlugin;
import seg.jUCMNav.model.ModelCreationFactory;
import seg.jUCMNav.model.commands.transformations.ReplaceEmptyPointCommand;
import seg.jUCMNav.model.commands.transformations.SplitLinkCommand;
import ucm.map.PathNode;
import ucm.map.RespRef;
import urn.URNspec;

/**
 * Adds a label to a PathNode or ComponentRef.
 * 
 * @author Ali
 */
public class AddResponsibility extends URNSelectionAction {
    public static final String ADDRESPONSIBILITY= "seg.jUCMNav.AddResponsibility"; //$NON-NLS-1$
    

    /**
     * @param part
     */
    public AddResponsibility(IWorkbenchPart part) {
        super(part);
        setId(ADDRESPONSIBILITY);
        setImageDescriptor(ImageDescriptor.createFromFile(JUCMNavPlugin.class, "icons/Resp16.gif")); //$NON-NLS-1$
    }

    /**
     * True if we select a direction arrow, node connection or an empty point .
     */
    protected boolean calculateEnabled() {
        SelectionHelper sel = new SelectionHelper(getSelectedObjects());
        switch (sel.getSelectionType()) {
        case SelectionHelper.DIRECTIONARROW:
              return true;
        case SelectionHelper.NODECONNECTION:
            return true;
        case SelectionHelper.EMPTYPOINT:
            return true;
            
        }
        return false;
    }
    
    /**
     * Returns the appropriate responsibility creation command, given the current selection.
     */
    
    protected Command getCommand() {
        SelectionHelper sel = new SelectionHelper(getSelectedObjects());
        PathNode newResponsibility = getNewResponsibility(sel.getUrnspec());
        Command comm;
        
        
        switch (sel.getSelectionType()) {

        case SelectionHelper.EMPTYPOINT:
            comm = new ReplaceEmptyPointCommand(sel.getEmptypoint(),newResponsibility);         
             return comm;
        
        case SelectionHelper.DIRECTIONARROW:
           comm = new ReplaceEmptyPointCommand(sel.getDirectionarrow(),newResponsibility);         
            return comm;

        case SelectionHelper.NODECONNECTION:
            comm = new SplitLinkCommand(sel.getMap(), newResponsibility, sel.getNodeconnection(), sel.getNodeconnectionMiddle().x, sel.getNodeconnectionMiddle().y ) ;         
             return comm;
             
        default:
            return null;
        }

    }
    
    /**
     * @param urn
     * @return a Responsibility
     */
    protected PathNode getNewResponsibility(URNspec urn) {
        return (RespRef) ModelCreationFactory.getNewObject(urn, RespRef.class);
    }

}