package seg.jUCMNav.model.commands.changeConstraints;

import grl.GRLNode;

import java.util.Iterator;

import org.eclipse.gef.commands.CompoundCommand;

import ucm.map.Connect;
import ucm.map.NodeConnection;
import ucm.map.PathNode;
import urncore.IURNConnection;
import urncore.IURNNode;

/**
 * This command is used to resize/move Nodes. Is a compound command because might move connected elements.
 * 
 * @author jkealey
 *  
 */
public class SetConstraintCommand extends CompoundCommand {

    /**
     * 
     * @param node
     *            The SpecificationNode to move
     * @param x
     *            the new X
     * @param y
     *            the new Y
     */
    public SetConstraintCommand(IURNNode node, int x, int y) {
        add(new MoveNodeCommand(node, x, y));

        if (node.getPred().size() > 0) {
            for (Iterator iter = node.getPred().iterator(); iter.hasNext();) {
                IURNConnection nc = (IURNConnection) iter.next();
                if (nc.getSource() instanceof Connect) {
                    add(new MoveNodeCommand((PathNode)nc.getSource(), x, y));
                    add(new MoveNodeCommand((PathNode)((NodeConnection) nc.getSource().getPred().get(0)).getSource(), x, y));
                }
            }
        }
        if (node.getSucc().size() > 0) {
            for (Iterator iter = node.getSucc().iterator(); iter.hasNext();) {
                IURNConnection nc = (IURNConnection) iter.next();
                if (nc.getTarget() instanceof Connect) {
                    add(new MoveNodeCommand((PathNode)nc.getTarget(), x, y));
                    add(new MoveNodeCommand((PathNode)((NodeConnection) nc.getTarget().getSucc().get(0)).getTarget(), x, y));
                }
            }
        }
    }

    /**
     * 
     * @param node
     *            The SpecificationNode to move
     * @param x
     *            the new X
     * @param y
     *            the new Y
     * @param width
     *            the new width
     * @param height
     *            the new height           
     */
    public SetConstraintCommand(GRLNode node, int x, int y) {
        add(new MoveResizeGrlNodeCommand(node, x, y));

        if (node.getPred().size() > 0) {
            for (Iterator iter = node.getPred().iterator(); iter.hasNext();) {
                IURNConnection nc = (IURNConnection) iter.next();
                if (nc.getSource() instanceof Connect) {
                    add(new MoveNodeCommand((PathNode)nc.getSource(), x, y));
                    add(new MoveNodeCommand((PathNode)((NodeConnection) nc.getSource().getPred().get(0)).getSource(), x, y));
                }
            }
        }
        if (node.getSucc().size() > 0) {
            for (Iterator iter = node.getSucc().iterator(); iter.hasNext();) {
                IURNConnection nc = (IURNConnection) iter.next();
                if (nc.getTarget() instanceof Connect) {
                    add(new MoveNodeCommand((PathNode)nc.getTarget(), x, y));
                    add(new MoveNodeCommand((PathNode)((NodeConnection) nc.getTarget().getSucc().get(0)).getTarget(), x, y));
                }
            }
        }
    }
}