package seg.jUCMNav.figures.anchors;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

import seg.jUCMNav.figures.Polygon;
import seg.jUCMNav.model.util.PathNodeDistanceComparator;
import ucm.map.AndFork;
import ucm.map.AndJoin;
import ucm.map.NodeConnection;
import ucm.map.PathNode;

/**
 * Connection anchor for AndForks and AndJoins. Positions themselves on the rotated line.
 * 
 * This class is a performance nightmare. See getLocation.
 * 
 * @author jkealey
 *  
 */
public class AndForkJoinConnectionAnchor extends AbstractConnectionAnchor {

    private NodeConnection nc;
    private PathNode pn;

    /**
     * 
     * @param owner
     *            the AndFork/AndJoin figure.
     * @param nc
     *            the node connection for which this is an anchor.
     * @param pn
     *            the AndFork/AndJoin itself.
     */
    public AndForkJoinConnectionAnchor(IFigure owner, NodeConnection nc, PathNode pn) {
        super(owner);
        this.nc = nc;
        this.pn = pn;
    }

    /**
     * This function is a horrible performance nightmare. Given the currently implemented algorithm, the connection anchor positions are allocated one by one to
     * the pathnodes closest to the current andfork/join. Therefore, every call to this function imply recalculating the location for at most all
     * outgoing/incoming connections.
     * 
     * We do this to have better movement feedback than static assignments. (Similar to UCMNav)
     */
    public Point getLocation(Point reference) {
        IFigure figure = (IFigure) getOwner();
        // the rotated line.
        Polygon subfig = ((Polygon) figure.getChildren().get(0));
        int minPoint = -1;
        PointList list = subfig.getPoints().getCopy();
        Vector v = new Vector();

        if (pn instanceof AndFork) {
            if (subfig.getPoints().size() - 2 >= pn.getSucc().size()) {

                // put all target nodes into vector.
                for (Iterator iter = pn.getSucc().iterator(); iter.hasNext();) {
                    NodeConnection element = (NodeConnection) iter.next();
                    v.add(element.getTarget());
                }
                // put closest first
                Collections.sort(v, new PathNodeDistanceComparator(new Point(pn.getX(), pn.getY())));

                // assign positions to closest until target
                for (int i = 0; i <= v.indexOf(nc.getTarget()); i++) {
                    PathNode element = (PathNode) v.get(i);
                    minPoint = getClosestPoint(list, new Point(element.getX(), element.getY()));
                    if (i != v.indexOf(nc.getTarget()))
                        list.removePoint(minPoint);
                }

            }
        } else if (pn instanceof AndJoin) { // ugly almost duplicated code.

            if (subfig.getPoints().size() >= pn.getPred().size()) {

                // put all source nodes into vector
                for (Iterator iter = pn.getPred().iterator(); iter.hasNext();) {
                    NodeConnection element = (NodeConnection) iter.next();
                    v.add(element.getSource());

                }

                // put furthest first
                Collections.sort(v, new PathNodeDistanceComparator(new Point(pn.getX(), pn.getY())));

                // assign positions to closests until source
                for (int i = 0; i <= v.indexOf(nc.getSource()); i++) {
                    PathNode element = (PathNode) v.get(i);
                    minPoint = getClosestPoint(list, new Point(element.getX(), element.getY()));
                    if (i != v.indexOf(nc.getSource()))
                        list.removePoint(minPoint);
                }

            }
        }

        // return the point associated with the found index.
        if (minPoint != -1)
            return getGlobalPoint(list, figure, minPoint);

        return new Point(pn.getX(), pn.getY());
    }

    /**
     * Note that this method does not look at the first or last point in the pointlist.
     * 
     * @param list
     * @param fromPoint
     * @return the point in the list that is closest to fromPoint
     */
    private int getClosestPoint(PointList list, Point fromPoint) {
        IFigure figure = (IFigure) getOwner();

        double minDist = Double.MAX_VALUE;
        int minPoint = -1;

        for (int index = 1; index < list.size() - 1; index++) {
            Point global = getGlobalPoint(list, figure, index);
            double dist = global.getDistance(new Point(fromPoint.x, fromPoint.y));
            if (dist < minDist) {
                minDist = dist;
                minPoint = index;
            }
        }

        assert minPoint != -1 : "problem finding closest point";

        return minPoint;
    }

    /**
     * @param list
     * @param figure
     *            the figure containing the list
     * @param index
     *            of point in list
     * @return converts the relative point to a global one.
     */
    private Point getGlobalPoint(PointList list, IFigure figure, int index) {
        Point local = list.getPoint(index);
        Point global = local.getCopy().translate(pn.getX(), pn.getY()).translate(-figure.getPreferredSize().width / 2, -figure.getPreferredSize().height / 2);
        return global;
    }

}