/**
 * 
 */
package seg.jUCMNav.figures;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * This is a figure representing a GRL node. Extend this class to create GrlNode
 * @author Jean-Fran�ois Roy
 *
 */
public abstract class GrlNodeFigure extends Shape implements LabelElementFigure{

    //for grl multiline label, space between start of the figure and start of the label
    protected static final int LABEL_PADDING_X = 20;
    protected static final int LABEL_PADDING_Y = 10;

    // default sizes
    protected static int DEFAULT_HEIGHT = 50;
    protected static int DEFAULT_WIDTH = 100;

    /** The inner TextFlow **/
    protected TextFlow textFlow;
    protected FlowPage flowPage;

    protected ConnectionAnchor anchor;
    
    /**
     * Override this method if your figure is not of the default size.
     * 
     * @return Returns the default dimension.
     * @see seg.jUCMNav.figures.util.JUCMNavFigure
     */
    public static Dimension getDefaultDimension() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    // is the figure in hover state
    protected boolean hover;
    
    // is the figure in selected state
    protected boolean selected;
    
    protected XYLayout xylayout;
    
    /**
     * Constructor of the node figure. Set the layout manager and the line width
     */
    public GrlNodeFigure() {
        super();
        xylayout = new XYLayout();
        this.setLayoutManager(xylayout);
        setLineWidth(3);
        
        initAnchor();
        
        flowPage = new FlowPage();

        textFlow = new TextFlow();
        
        textFlow.setLayoutManager(new ParagraphTextLayout(textFlow,
                ParagraphTextLayout.WORD_WRAP_HARD));

        flowPage.add(textFlow);
        add(flowPage);
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
     */
    protected abstract void outlineShape(Graphics graphics);

    /* (non-Javadoc)
     * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
     */
    protected abstract void fillShape(Graphics graphics);

    /**
     * This return the connection anchor.
     * 
     * @return The connecction anchor
     */
    public ConnectionAnchor getConnectionAnchor() {
        return anchor;
    }
    
    /**
     * @return this figure
     */
    public Figure getNodeFigure() {
        return this;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.draw2d.IFigure#getPreferredSize(int, int)
     */
    public Dimension getPreferredSize(int wHint, int hHint) {
        return textFlow.getPreferredSize().getCopy();
    }

    /* (non-Javadoc)
     * @see seg.jUCMNav.figures.LabelElementFigure#getText()
     */
    public String getText() {
        return textFlow.getText();
    }
    
    /**
     * @see seg.jUCMNav.figures.PathNodeFigure#initAnchor()
     */
    protected void initAnchor() {
        anchor = new ChopboxAnchor(this);
    }
    
    /**
     * Sets the figure's colors. The default line color is black, the default fill color is white.
     * 
     * @param lineColor
     *            outline color
     * @param fillColor
     *            inside color
     * @param filled
     *            should it be filled?
     */
    public void setColors(String lineColor, String fillColor, boolean filled) {
        RGB color;
        setFill(filled);

        if (fillColor == null || fillColor.length() == 0) {
            fillColor = StringConverter.asString(new RGB(255, 255, 255));
        }
        color = StringConverter.asRGB(fillColor);
        setBackgroundColor(new Color(Display.getCurrent(), color));

        if (lineColor == null || lineColor.length() == 0) {
            lineColor = StringConverter.asString(new RGB(0, 0, 0));
        }

        color = StringConverter.asRGB(lineColor);
        setForegroundColor(new Color(Display.getCurrent(), color));
    }
    
    /**
     * Sets the text of the TextFlow to the given value and set the size of the label.
     * 
     * @param newText the new text value.
     */
    public void setText(String newText) {
        textFlow.setText(newText);
        
        //Calculate the size of the label and of the figure
        //Max size available for the label
        int width = getDefaultDimension().width - 2*LABEL_PADDING_X;
        int height = getDefaultDimension().height - 2*LABEL_PADDING_Y;
        
        Dimension dimEditableLabel = flowPage.getPreferredSize().getCopy();
        
        int minWidth = flowPage.getPreferredSize(width,1).width;
        
        //Loop until we have good dimension for the labels to fit in the node
        while ((dimEditableLabel.width > (width* Math.floor(height/dimEditableLabel.height)))
                || width < minWidth){
            height = height + 13;
            width = width + 20;
        }
        
        Rectangle r = new Rectangle();
        r.x = LABEL_PADDING_X;
        r.y = LABEL_PADDING_Y;
        r.width = width;
        r.height = height;
        setConstraint(flowPage,r);
        
        setSize(width + 2*LABEL_PADDING_X, height + 2*LABEL_PADDING_Y);

    }    
}
