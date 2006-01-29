/**
 * 
 */
package seg.jUCMNav.editparts.treeEditparts;

import grl.IntentionalElementRef;
import grl.IntentionalElementType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPolicy;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.properties.IPropertySource;

import seg.jUCMNav.JUCMNavPlugin;
import seg.jUCMNav.editpolicies.element.GRLNodeComponentEditPolicy;
import seg.jUCMNav.views.property.IntentionalElementPropertySource;

/**
 * TreeEditPart for IntentionalElementRef
 * 
 * @author Jean-Fran�ois Roy
 *
 */
public class IntentionalElementRefTreeEditPart extends UrnModelElementTreeEditPart {

    /**
     * @param model
     *            the IntentionalElementRef
     */
    public IntentionalElementRefTreeEditPart(IntentionalElementRef model) {
        super(model);
    }

    /**
     * Listens to both reference and definition.
     */
    public void activate() {
        super.activate();
        if (getIntentionalElementRef().getDef() != null)
            getIntentionalElementRef().getDef().eAdapters().add(this);
    }

    /**
     * Stops listening to both reference and definition.
     */
    public void deactivate() {
        super.deactivate();
        if (getIntentionalElementRef().getDef() != null)
            getIntentionalElementRef().getDef().eAdapters().remove(this);
    }
    
    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     */
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new GRLNodeComponentEditPolicy());
    }

    /**
     * return the intentionalElementRef associate with this edit part
     */
    protected IntentionalElementRef getIntentionalElementRef() {
        return (IntentionalElementRef) getModel();
    }

    /**
     * Returns an image representing the Intentional element.
     */
    protected Image getImage() {

        IntentionalElementRef element = getIntentionalElementRef();

        if (super.getImage() == null && element.getDef() != null) {
            if (element.getDef().getType().getValue() == IntentionalElementType.GOAL)
                setImage((ImageDescriptor.createFromFile(JUCMNavPlugin.class, "icons/Goal16.gif")).createImage()); //$NON-NLS-1$
            else if (element.getDef().getType().getValue() == IntentionalElementType.SOFTGOAL)
                setImage((ImageDescriptor.createFromFile(JUCMNavPlugin.class, "icons/Softgoal16.gif")).createImage()); //$NON-NLS-1$
            else if (element.getDef().getType().getValue() == IntentionalElementType.TASK)
                setImage((ImageDescriptor.createFromFile(JUCMNavPlugin.class, "icons/Task16.gif")).createImage()); //$NON-NLS-1$
            else if (element.getDef().getType().getValue() == IntentionalElementType.RESSOURCE)
                setImage((ImageDescriptor.createFromFile(JUCMNavPlugin.class, "icons/Ressource16.gif")).createImage()); //$NON-NLS-1$
        } 

        return super.getImage();
    }

    /**
     * Change image if type changes.
     * 
     * @see seg.jUCMNav.editparts.treeEditparts.UrnModelElementTreeEditPart#notifyChanged(org.eclipse.emf.common.notify.Notification)
     */
    public void notifyChanged(Notification notification) {
        if (notification.getFeature() instanceof EStructuralFeature) {
            EStructuralFeature structuralFeature = (EStructuralFeature) notification.getFeature();
            if (structuralFeature.getEType().getInstanceClass() == IntentionalElementType.class) {
                // next getImage() will refresh it. (refreshVisuals() in parent will do it)
                if (getImage() != null) {
                    getImage().dispose();
                    setImage(null);
                }
            }
        }
        super.notifyChanged(notification);
    }
    
    /**
     * Returns a IntentionalElementPropertySource
     * 
     * @see seg.jUCMNav.editparts.treeEditparts.UrnModelElementTreeEditPart#getPropertySource()
     */
    protected IPropertySource getPropertySource() {
        if (propertySource == null)
            propertySource = new IntentionalElementPropertySource((IntentionalElementRef)getModel());

        return propertySource;
    }
}