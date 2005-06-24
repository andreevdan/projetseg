package seg.jUCMNav.editparts.treeEditparts;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import seg.jUCMNav.JUCMNavPlugin;
import ucm.map.RespRef;

/**
 * Created 2005-05-17
 * 
 * @author Etienne Tremblay
 */
public class RespRefTreeEditPart extends PathNodeTreeEditPart {

    /**
     * @param model
     */
    public RespRefTreeEditPart(Object model) {
        super(model);
    }

    public void activate() {
        super.activate();
        if (getRespRef().getRespDef() != null)
            getRespRef().getRespDef().eAdapters().add(this);
    }

    public void deactivate() {
        super.deactivate();
        if (getRespRef().getRespDef() != null)
            getRespRef().getRespDef().eAdapters().remove(this);
    }

    private RespRef getRespRef() {
        return (RespRef) getModel();
    }

    protected Image getImage() {
        if (super.getImage() == null)
            setImage((ImageDescriptor.createFromFile(JUCMNavPlugin.class, "icons/Resp16.gif")).createImage()); //$NON-NLS-1$
        return super.getImage();
    }
}