package implicit;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import javax.rmi.CORBA.Stub;

import sun.rmi.transport.Endpoint;
import ucm.map.ComponentRef;
import ucm.map.PathNode;
import ucm.map.RespRef;
import urncore.Component;

/**
 * <!-- begin-user-doc --> Inserts Resource Release objects in duplicate map <!-- end-user-doc -->
 * 
 * @see implicit
 * @generated
 */
public class ResourceRelease extends ResourceUtil {

    // RR and Empty Point IDs
    static int rr_id = 3000; // limitation.  js
    static int seq_id = 4000; // limitation.  js
    PrintStream ps;

    // constructor
    public ResourceRelease(PrintStream ps) {
        this.ps = ps;
    }

    // adds all hyperedge parent components to stack
    public void findParentsRR(ComponentRef compRef, Stack edge_stack) {
        // The top of the stack is the outermost component
        ComponentRef parent_compRef = (ComponentRef) compRef.getParent();
        if (parent_compRef != null) {
            findParentsRR(parent_compRef, edge_stack);
            edge_stack.push(parent_compRef);
        }
    }

    // Resource Release algorithm
    public int releaseResource(PathNode curr_edge, CSMDupNodeList dup_map, CSMDupConnectionList dup_map_conn) {

        // list that will store edges to be parsed (will contain pathnodes only)
        int nodes_inserted = 0; // total nodes inserted since last run
        // Compute resources to be acquired
        ArrayList usedResources = null; // requested resources + containing components
        ArrayList resToRelease = new ArrayList(); // resPreviouslyNeeded - usedResources 
        ArrayList resNeededNext; // resources used by previous node
        CSMDupNode curr_edge_dupNode = dup_map.get(dup_map.getNodeIndex(curr_edge));
        CSMDupNode nextDupNode = null;
        PathNode next_pathnode = null;
        // EndPoint releases all containing components
        if (curr_edge_dupNode.getType() == CSMDupNode.END) {
            usedResources = curr_edge_dupNode.getUsedResources();
            copyArray(usedResources, resToRelease);
        // ResponsibilityRef/Stub release what is no longer required
        } else if ( (curr_edge_dupNode.getType() == CSMDupNode.RESPREF) || (curr_edge_dupNode.getType() == CSMDupNode.STUB) ) {
            usedResources = curr_edge_dupNode.getUsedResources();
            nextDupNode = dup_map_conn.getTargetForSource(curr_edge);
            resNeededNext = nextDupNode.getUsedResources();
            copyArray(firstMinusSecond(usedResources, resNeededNext),resToRelease);
            next_pathnode = nextDupNode.getNode();
        } else {
            for (int i = 0; i < dup_map_conn.size(); i++) {
		CSMDupConnection conn = dup_map_conn.get(i);
		if (conn.getSource() == curr_edge) {
		    nextDupNode = conn.getCSMTarget();
		    if ((nextDupNode.getType() == CSMDupNode.RR) || (nextDupNode.getType() == CSMDupNode.RA) || (nextDupNode.getType() == CSMDupNode.RESPREF)  || (nextDupNode.getType() == CSMDupNode.STUB)) {
	        	usedResources = curr_edge_dupNode.getUsedResources();
	        	resNeededNext = nextDupNode.getUsedResources();
	        	copyArray(firstMinusSecond(usedResources, resNeededNext),resToRelease);
	                next_pathnode = nextDupNode.getNode();
	                while (resToRelease.size() != 0) {
	                    if (next_pathnode != null) {
	                	nodes_inserted = addRR(resToRelease, usedResources, dup_map, dup_map_conn, curr_edge, nodes_inserted, next_pathnode);
	                    } else {
	                	// TODO:  endpoint: insert *BEFORE* js
	                	resToRelease.remove(0);
	                    }
	                }
	            }
		}
		
	    }
            
        }

        while (resToRelease.size() != 0) {
            if (next_pathnode != null) {
        	nodes_inserted = addRR(resToRelease, usedResources, dup_map, dup_map_conn, curr_edge, nodes_inserted, next_pathnode);
            } else {
        	// TODO:  endpoint: insert *BEFORE* js
        	resToRelease.remove(0);
            }
        }
                return nodes_inserted;
    } // function

    // prints XML representation of Resource Release element
    public void releaseComp(Component comp, CSMDupNode node, CSMDupConnectionList list) {

        // initializing attributes
        String successor = list.getTargetForSource(node.getId());
        String predecessor = list.getSourceForTarget(node.getId());

        // object attributes
        String rr_attributes = "<ResourceRelease id=\"" + node.getId() + "\"" + " release=\"" + "c" + comp.getId() + "\"";

        String rr_predecessor = " predecessor=\"" + "h" + predecessor + "\"";
        String rr_successor = " successor=\"" + "h" + successor + "\"";
        String end_rr = "/>";

        // special naming convention for RR/RA objects
        if (predecessor.startsWith("G")) {
            rr_predecessor = " predecessor=\"" + predecessor + "\"";
        }
        if (successor.startsWith("G")) {
            rr_successor = " successor=\"" + successor + "\"";
        }

        // printing attributes
        ps.print("            " + rr_attributes);
        ps.print(" " + rr_predecessor);
        ps.print(" " + rr_successor);
        ps.print(" " + end_rr);
        ps.println("");
    }

    public void releaseComp(String res, CSMDupNode node, CSMDupConnectionList list) {

        // initializing attributes
        String successor = list.getTargetForSource(node.getId());
        String predecessor = list.getSourceForTarget(node.getId());

        // object attributes
        String rr_attributes = "<ResourceRelease id=\"" + node.getId() + "\"" + " release=\"" + "c" + res + "\"";

        String rr_predecessor = " predecessor=\"" + "h" + predecessor + "\"";
        String rr_successor = " successor=\"" + "h" + successor + "\"";
        String end_rr = "/>";

        // special naming convention for RR/RA objects
        if (predecessor.startsWith("G")) {
            rr_predecessor = " predecessor=\"" + predecessor + "\"";
        }
        if (successor.startsWith("G")) {
            rr_successor = " successor=\"" + successor + "\"";
        }

        // printing attributes
        ps.print("            " + rr_attributes);
        ps.print(" " + rr_predecessor);
        ps.print(" " + rr_successor);
        ps.print(" " + end_rr);
        ps.println("");
    }

    // prints XML representation of Dummy EmptyPoint element
    public void acquireEmptyPoint(CSMDupNode node, CSMDupConnectionList list) {

        // initializing attributes
        String target = list.getTargetForSource(node.getId());
        String source = list.getSourceForTarget(node.getId());

        // object attributes
        String epoint_attributes = "<Sequence id=\"" + node.getId() + "\"" + " ";
        String epoint_target = "target= \"h" + target + "\"" + " ";
        String epoint_source = "source= \"h" + source + "\"";
        String epoint_end = "/>";

        // special naming convention for RR/RA objects
        if (source.startsWith("G")) {
            epoint_source = " source=\"" + source + "\"";
        }
        if (target.startsWith("G")) {
            epoint_target = " target=\"" + target + "\"";
        }

        // output to file
        ps.print("            " + epoint_attributes);
        ps.print(" " + epoint_source);
        ps.print(" " + epoint_target);
        ps.print(" " + epoint_end);
        ps.println("");
        ps.flush();
    }

    // inserts RR and Empty Points where necessary in the duplicate map
    public int addRR(ArrayList resToRelease, ArrayList usedResources, CSMDupNodeList map, CSMDupConnectionList conn_map, PathNode curr_edge, int ins_nodes, PathNode next_edge) {

        // create resource release component and insert it in duplicate map
        CSMDupNode rr_node = new CSMDupNode(++rr_id);
        rr_node.setUsedResources(usedResources); // to compute release/acquire sets
        map.add(rr_node);
        ins_nodes++;
        // create empty point and insert it in duplicate map
        CSMDupNode e_node = new CSMDupNode(++seq_id);
        e_node.setUsedResources(usedResources); // to compute release/acquire sets
        map.add(e_node);
        ins_nodes++;
        // create new links
        CSMDupNode target = conn_map.getTargetForSourceTowardNode(curr_edge.getId(), next_edge);
        conn_map.add(new CSMDupConnection(curr_edge, e_node));
        conn_map.add(new CSMDupConnection(e_node, rr_node));
        // add an empty point if immediatly followed by RR/RA/RESPREF node
        if ((target.getType() == CSMDupNode.RR) || (target.getType() == CSMDupNode.RA) || (target.getType() == CSMDupNode.RESPREF)  || (target.getType() == CSMDupNode.STUB)) { //js
            // create empty point and insert it in duplicate map
            CSMDupNode e2_node = new CSMDupNode(++seq_id);
            e2_node.setUsedResources(usedResources);
            map.add(e2_node);
            ins_nodes++;
            conn_map.add(new CSMDupConnection(rr_node, e2_node));
            conn_map.add(new CSMDupConnection(e2_node, target));
        } else {
            conn_map.add(new CSMDupConnection(rr_node, target));	
        }
        
        conn_map.remove(curr_edge, target);
        
/*
        if ((curr_edge instanceof EmptyPoint)) { // leave it alone.  NEEDS TESTING... js
            conn_map.add(new CSMDupConnection(ra_node, curr_edge));
        } else {
            // create empty point and insert it in duplicate map
            CSMDupNode e_node = new CSMDupNode(++seq_id);
            e_node.setUsedResources(usedResources); // to compute the release set
            map.add(e_node);
            ins_nodes++;
            conn_map.add(new CSMDupConnection(ra_node, e_node));
            conn_map.add(new CSMDupConnection(e_node, curr_edge));
        }

 */        

        // if (releaseList.size != 0){ take one out of list  } js
        // but first, convert to component use
        if (resToRelease.size() != 0) {
            Component comp = (Component) resToRelease.get(0);
            resToRelease.remove(0);
            rr_node.setCompToRelease(comp); // for when source wants to get ready to compute release set
        }
        return ins_nodes;
    }

    // methods to manipulate RR and Dummy Sequence IDs
    public int getRrSeqId() {
        return seq_id;
    }

    public int getRrId() {
        return rr_id;
    }

    public void setRrSeqId(int id) {
        seq_id = id;
    }

    public void setRrId(int id) {
        rr_id = id;
    }
}
