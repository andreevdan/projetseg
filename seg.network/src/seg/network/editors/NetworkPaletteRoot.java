/*
 * Created on 2005-01-30
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package seg.network.editors;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;

import seg.network.NetworkPlugin;
import seg.network.model.ModelCreationFactory;
import seg.network.model.network.Component;
import seg.network.model.network.EndPoint;
import seg.network.model.network.Link;
import seg.network.model.network.Node;
import seg.network.model.network.Responsibility;
import seg.network.model.network.StartPoint;


public class NetworkPaletteRoot extends PaletteRoot
{
	
	/** Default palette size. */
	private static final int DEFAULT_PALETTE_SIZE = 125;

	/** Preference ID used to persist the palette location. */
	private static final String PALETTE_DOCK_LOCATION = "ShapesEditorPaletteFactory.Location";
	/** Preference ID used to persist the palette size. */
	private static final String PALETTE_SIZE = "ShapesEditorPaletteFactory.Size";
	/** Preference ID used to persist the flyout palette's state. */
	private static final String PALETTE_STATE = "ShapesEditorPaletteFactory.State";

    /**
     * Creates a new NetworkPaletteRoot instance.
     * 
     */
    public NetworkPaletteRoot()
    {
        // create root
        super();

        // a group of default control tools
        PaletteGroup controls = new PaletteGroup("Controls");
        add(controls);

        // the selection tool
        ToolEntry tool = new SelectionToolEntry();
        controls.add(tool);

        // use selection tool as default entry
        setDefaultEntry(tool);

        // the marquee selection tool
        controls.add(new MarqueeToolEntry());


        CreationToolEntry entry;
        
        PaletteDrawer componentsDrawer = new PaletteDrawer("Components");
        
        entry = new CombinedTemplateCreationEntry("Team", "Create a team", Component.class, new ModelCreationFactory(Component.class), ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Component16.gif"), null);
		componentsDrawer.add(entry);
        entry = new CombinedTemplateCreationEntry("Object", "Create an object", null, null, ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Object16.gif"), null);
		componentsDrawer.add(entry);
        entry = new CombinedTemplateCreationEntry("Process", "Create a process", null, null, ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Process16.gif"), null);
		componentsDrawer.add(entry);
        entry = new CombinedTemplateCreationEntry("ISR", "Create an ISR", null, null, ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/ISR16.gif"), null);
		componentsDrawer.add(entry);
        entry = new CombinedTemplateCreationEntry("Pool", "Create a pool", null, null, ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Pool16.gif"), null);
		componentsDrawer.add(entry);
        entry = new CombinedTemplateCreationEntry("Agent", "Create an agent", null, null, ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Agent16.gif"), null);
		componentsDrawer.add(entry);
        entry = new CombinedTemplateCreationEntry("Other", "Create an other component", Component.class, new ModelCreationFactory(Component.class), ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Component16.gif"), null);
		componentsDrawer.add(entry);
		
		add(componentsDrawer);
		
		componentsDrawer = new PaletteDrawer("Path");
		entry =
			new ConnectionCreationToolEntry(
				"Link",
				"Creates a link",
				new ModelCreationFactory(Link.class),
				ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/connection_s16.gif"), 
				ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/connection_s24.gif"));
		componentsDrawer.add(entry);
		
		entry =
            new CombinedTemplateCreationEntry(
                "Node",
                "Creates a node",
                Node.class,
                new ModelCreationFactory(Node.class),
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Node16.gif"), 
				ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/ellipse24.gif"));
        componentsDrawer.add(entry);
        
        entry =
            new CombinedTemplateCreationEntry(
                "Start Point",
                "Creates a Start Point",
                StartPoint.class,
                new ModelCreationFactory(StartPoint.class),
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Start16.gif"), 
				ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/ellipse24.gif"));
        componentsDrawer.add(entry);
        
        entry =
            new CombinedTemplateCreationEntry(
                "End Point",
                "Creates a End Point",
                EndPoint.class,
                new ModelCreationFactory(EndPoint.class),
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/End16.gif"), 
				ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/ellipse24.gif"));
        componentsDrawer.add(entry);
        
        entry =
            new CombinedTemplateCreationEntry(
                "Responsibility",
                "Creates a Responsibility",
                Responsibility.class,
                new ModelCreationFactory(Responsibility.class),
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Resp16.gif"), 
				ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/ellipse24.gif"));
        componentsDrawer.add(entry);
        
        entry =
            new CombinedTemplateCreationEntry(
                "Stub",
                "Creates a stub",
                null,
                null,
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Stub16.gif"), 
				null);
        componentsDrawer.add(entry);
        
        entry =
            new CombinedTemplateCreationEntry(
                "Loop",
                "Creates a loop",
                null,
                null,
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Loop16.gif"), 
				null);
        componentsDrawer.add(entry);
		
        entry =
            new CombinedTemplateCreationEntry(
                "Goal Tag",
                "Creates a goal tag",
                null,
                null,
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/GoalTag16.gif"), 
				null);
        componentsDrawer.add(entry);
        
        entry =
            new CombinedTemplateCreationEntry(
                "Failure Point",
                "Creates a failure point",
                null,
                null,
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/FailurePoint16.gif"), 
				null);
        componentsDrawer.add(entry);
        
		add(componentsDrawer);
        
        componentsDrawer = new PaletteDrawer("Fork");
        
        entry =
            new CombinedTemplateCreationEntry(
                "Or Fork",
                "Creates an or fork",
                null,
                null,
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/OrFork16.gif"), 
				null);
        componentsDrawer.add(entry);
        
        entry =
            new CombinedTemplateCreationEntry(
                "And Fork",
                "Creates an and fork",
                null,
                null,
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/AndFork16.gif"), 
				null);
        componentsDrawer.add(entry);
        
        entry =
            new CombinedTemplateCreationEntry(
                "Or Join",
                "Creates an or join",
                null,
                null,
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/OrJoin16.gif"), 
				null);
        componentsDrawer.add(entry);
        
        entry =
            new CombinedTemplateCreationEntry(
                "And Join",
                "Creates a and join",
                null,
                null,
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/AndJoin16.gif"), 
				null);
        componentsDrawer.add(entry);
        
        add(componentsDrawer);
        
        componentsDrawer = new PaletteDrawer("Timing");
        
        entry =
            new CombinedTemplateCreationEntry(
                "Timer",
                "Creates a timer",
                null,
                null,
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Timer16.gif"), 
				null);
        componentsDrawer.add(entry);
        
        entry =
            new CombinedTemplateCreationEntry(
                "Wait",
                "Creates a wait",
                null,
                null,
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/Wait16.gif"), 
				null);
        componentsDrawer.add(entry);
        
        entry =
            new CombinedTemplateCreationEntry(
                "Timestamp",
                "Creates a timestamp",
                null,
                null,
                ImageDescriptor.createFromFile(NetworkPlugin.class, "icons/TimestampPoint16.gif"), 
				null);
        componentsDrawer.add(entry);
        
        add(componentsDrawer);
    }
    
    /** 
     * Returns the preference store for the ShapesPlugin.
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#getPreferenceStore() 
     */
    private static IPreferenceStore getPreferenceStore() {
    	return NetworkPlugin.getDefault().getPreferenceStore();
    }
    
    /**
     * Return a FlyoutPreferences instance used to save/load the preferences of a flyout palette.
     */
    public static FlyoutPreferences createPalettePreferences() {
    	// set default flyout palette preference values, in case the preference store
    	// does not hold stored values for the given preferences
        getPreferenceStore().setDefault(PALETTE_DOCK_LOCATION, -1);
    	getPreferenceStore().setDefault(PALETTE_STATE, -1);
    	getPreferenceStore().setDefault(PALETTE_SIZE, DEFAULT_PALETTE_SIZE);
    	
    	return new FlyoutPreferences() {
    		public int getDockLocation() {
    			return getPreferenceStore().getInt(PALETTE_DOCK_LOCATION);
    		}
    		public int getPaletteState() {
    			return getPreferenceStore().getInt(PALETTE_STATE);
    		}
    		public int getPaletteWidth() {
    			return getPreferenceStore().getInt(PALETTE_SIZE);
    		}
    		public void setDockLocation(int location) {
    			getPreferenceStore().setValue(PALETTE_DOCK_LOCATION, location);
    		}
    		public void setPaletteState(int state) {
    			getPreferenceStore().setValue(PALETTE_STATE, state);
    		}
    		public void setPaletteWidth(int width) {
    			getPreferenceStore().setValue(PALETTE_SIZE, width);
    		}
    	};
    }
}
