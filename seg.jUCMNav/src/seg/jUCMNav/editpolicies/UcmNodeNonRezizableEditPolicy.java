/*
 * Created on 2005-03-04
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package seg.jUCMNav.editpolicies;

import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.swt.graphics.Color;

import seg.jUCMNav.editparts.UcmNodeEditPart;
import seg.jUCMNav.figures.NodeFigure;

/**
 * Created 2005-03-04
 * 
 * @author Etienne Tremblay
 */
public class UcmNodeNonRezizableEditPolicy extends SelectionEditPolicy {

	/**
	 * 
	 */
	public UcmNodeNonRezizableEditPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private NodeFigure getFigure(){
		return (NodeFigure)((UcmNodeEditPart)this.getHost()).getFigure();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.SelectionEditPolicy#hideSelection()
	 */
	protected void hideSelection() {
		getFigure().setBackgroundColor(new Color(null, 255, 255, 255));
		getFigure().setSelected(false);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.SelectionEditPolicy#showSelection()
	 */
	protected void showSelection() {
		getFigure().setBackgroundColor(new Color(null, 0, 102, 204));
		getFigure().setSelected(true);
	}
}
