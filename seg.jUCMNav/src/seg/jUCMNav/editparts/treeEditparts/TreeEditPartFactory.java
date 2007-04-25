package seg.jUCMNav.editparts.treeEditparts;

import grl.Actor;
import grl.ActorRef;
import grl.Belief;
import grl.ElementLink;
import grl.GRLGraph;
import grl.IntentionalElement;
import grl.IntentionalElementRef;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import seg.jUCMNav.editors.UCMNavMultiPageEditor;
import seg.jUCMNav.model.wrappers.ComponentTreeWrapper;
import ucm.map.ComponentRef;
import ucm.map.PathNode;
import ucm.map.RespRef;
import ucm.map.Stub;
import ucm.map.UCMmap;
import ucm.performance.Demand;
import ucm.performance.GeneralResource;
import urn.URNspec;
import urncore.ComponentElement;
import urncore.Concern;
import urncore.Responsibility;

/**
 * The EditPartFactory associated with the outline treeview.
 * 
 * @author TremblaE, gunterm
 *  
 */
public class TreeEditPartFactory implements EditPartFactory {

    // the urn spec being edited.
    protected URNspec urn;

    /**
     * @param urn
     *            the urnspec to display
     */
    public TreeEditPartFactory(URNspec urn) {
        this.urn = urn;
    }

    /**
     * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
     */
    public EditPart createEditPart(EditPart context, Object model) {
        if (model instanceof UCMNavMultiPageEditor)
            return new OutlineRootEditPart((UCMNavMultiPageEditor) model);
        else if (model instanceof URNspec)
            return new URNspecTreeEditPart((URNspec)model);
        else if (model instanceof UCMmap)
            return new MapTreeEditPart((UCMmap) model);
        else if (model instanceof ComponentRef)
            return new ComponentRefTreeEditPart((ComponentRef) model);
        else if (model instanceof RespRef)
            return new RespRefTreeEditPart((RespRef) model);
        else if (model instanceof Stub)
            return new StubTreeEditPart((Stub) model);
        else if (model instanceof PathNode)
            return new PathNodeTreeEditPart((PathNode) model);
        else if (model instanceof String)
            return new LabelTreeEditPart(model, urn);
        else if (model instanceof ComponentElement)
            return new ComponentTreeEditPart((ComponentElement) model);
        else if (model instanceof ComponentTreeWrapper) 
            return new ComponentTreeEditPart((ComponentTreeWrapper) model);
        else if (model instanceof Responsibility)
            return new ResponsibilityTreeEditPart((Responsibility) model);
        else if (model instanceof GRLGraph)
            return new GrlGraphTreeEditPart((GRLGraph)model);
        else if (model instanceof IntentionalElementRef)
            return new IntentionalElementRefTreeEditPart((IntentionalElementRef) model);
        else if (model instanceof IntentionalElement)
            return new IntentionalElementTreeEditPart(model);
        else if (model instanceof Belief)
            return new BeliefTreeEditPart((Belief) model);
        else if (model instanceof ActorRef)
            return new ActorRefTreeEditPart((ActorRef)model);
        else if (model instanceof Actor)
            return new ActorTreeEditPart((Actor)model);
        else if (model instanceof ElementLink)
            return new ElementLinkTreeEditPart(model);
        else if (model instanceof GeneralResource) 
            return new GeneralResourceTreeEditPart((GeneralResource)model);
        else if (model instanceof Demand)
            return new DemandTreeEditPart((Demand)model);
        else if (model instanceof Concern)
            return new ConcernTreeEditPart((Concern) model);
        else
            return null;
    }

}