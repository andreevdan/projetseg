package seg.jUCMNav.editparts.strategyTreeEditparts;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.properties.IPropertySource;

import seg.jUCMNav.model.util.EObjectClassNameComparator;
import seg.jUCMNav.views.property.URNElementPropertySource;
import seg.jUCMNav.views.property.VariablePropertySource;
import ucm.scenario.Variable;

/**
 * TreeEditPart for all UrnModelElements. Baseclass for most other TreeEditParts.
 * 
 * Handles disposal of image.
 * 
 * @author Jean-Fran�ois Roy
 */
public class StrategyUrnModelElementTreeEditPart extends AbstractTreeEditPart implements Adapter {


	public final Color GRAY = new Color(null, 150, 150, 150);
	public final Color BLACK = new Color(null, 0, 0, 0);
	public final Color LIGHTGRAY = new Color(null, 200, 200, 200);
	public final Color WHITE = new Color(null, 255, 255, 255);
	
    // The property source associated with this model element.
    protected IPropertySource propertySource = null;

    // for impleneting Adapter
    private Notifier target;

    // the image associated with this TreeEditPart.
    protected Image image;

    /**
     * @param model
     *            the model element being edited.
     */
    public StrategyUrnModelElementTreeEditPart(Object model) {
        super(model);
    }

    /**
     * Listens to the model element.
     * 
     * @see org.eclipse.gef.EditPart#activate()
     */
    public void activate() {
        if (!isActive())
            ((EObject) getModel()).eAdapters().add(this);
        super.activate();
    }

    /**
     * 
     * Stops listening to the model element and destroys image.
     * 
     * @see org.eclipse.gef.EditPart#deactivate()
     */
    public void deactivate() {
        if (isActive()) {
            ((EObject) getModel()).eAdapters().remove(this);
            if (image != null) {
                image.dispose();
                image = null;
            }
        }
        super.deactivate();
    }

    /**
     * @see org.eclipse.gef.EditPart#getRoot()
     */
    public RootEditPart getRoot() {
    	if (getParent()==null)
    		return null;
    	else
    		return getParent().getRoot();
    }
    
    /**
     * Undoes any registration performed by {@link #register()}. The provided base classes
     * will correctly unregister their visuals.
     */
    protected void unregister() {
    	unregisterAccessibility();
    	unregisterVisuals();
    	if (getRoot()!=null)
    		unregisterModel();
    }
    
    /**
     * When something is changed, refresh. We are also refreshing the parent so that elements can be reordered if renamed
     *  
     */
    public void notifyChanged(Notification notification) {
        if (notification.getEventType() != Notification.REMOVING_ADAPTER && getRoot()!=null) {

            refreshChildren();
            refreshVisuals();
            
            // get rid of elements that were deleted. 
            if (getModel() instanceof EObject && ((EObject)getModel()).eContainer()==null)
            	getParent().refresh();
            
            // refresh parent to reorder children if name changes.
            if (notification.getFeature() instanceof EAttributeImpl && ((EAttributeImpl) notification.getFeature()).getName().equals("name")) { //$NON-NLS-1$
                getParent().refresh();
            }

        }
    }


    /**
     * Returns the textual string associated with this element.
     * 
     * @see seg.jUCMNav.model.util.EObjectClassNameComparator
     */
    protected String getText() {
        return EObjectClassNameComparator.getSortableElementName((EObject) getModel());
    }

    /**
     * 
     * @return the property source associated with this element.
     */
    protected IPropertySource getPropertySource() {
        if (propertySource == null) {
        	if (getModel() instanceof Variable)
        		propertySource = new VariablePropertySource((EObject) getModel());
        	else
        		propertySource = new URNElementPropertySource((EObject) getModel());
        }
        return propertySource;

    }

    /**
     * 
     * @see org.eclipse.emf.common.notify.Adapter#getTarget()
     */
    public Notifier getTarget() {
        return target;
    }

    /**
     * 
     * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
     */
    public void setTarget(Notifier newTarget) {
        target = newTarget;
    }

    /**
     * 
     * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
     */
    public boolean isAdapterForType(Object type) {
        return type.equals(getModel().getClass());
    }

    /**
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    public Object getAdapter(Class key) {
        /*
         * override the default behavior defined in AbstractEditPart which would expect the model to be a property sourced. instead the editpart can provide a
         * property source
         */
        if (IPropertySource.class == key) {
            return getPropertySource();
        }
        return super.getAdapter(key);
    }

    /**
     * @return The icon associated with this model element. 
     */
    protected Image getImage() {
        return image;
    }

    /**
     * @param image the icon associated with this model element. 
     */
    public void setImage(Image image) {
        this.image = image;
    }
}