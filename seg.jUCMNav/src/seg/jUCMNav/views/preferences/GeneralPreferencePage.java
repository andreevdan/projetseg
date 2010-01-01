package seg.jUCMNav.views.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import seg.jUCMNav.JUCMNavPlugin;
import seg.jUCMNav.Messages;
import seg.jUCMNav.figures.ColorManager;

/**
 * The root preference page for jUCMNav. Has preferences for label colors.
 * 
 * @author jkealey, jfroy, gunterm, pchen
 * 
 */
public class GeneralPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    public static final String PREF_AUTHOR = "PREF_AUTHOR"; //$NON-NLS-1$
    public static final String PREF_STRICTCODEEDITOR = "PREF_STRICTCODEEDITOR"; //$NON-NLS-1$
    public static final String PREF_METADATAINDVISIBLE = "PREF_METADATAINDVISIBLE"; //$NON-NLS-1$
    public static final String PREF_GRLTEXTVISIBLE = "PREF_GRLTEXTVISIBLE"; //$NON-NLS-1$
    public static final String PREF_GRLICONVISIBLE = "PREF_GRLICONVISIBLE"; //$NON-NLS-1$
    public static final String PREF_GRLAUTOADDLINKS = "PREF_GRLAUTOADDLINKS"; //$NON-NLS-1$

    // Preferences for new .jurn files
    public static final String PREF_NEWGRL = "PREF_NEWGRL"; //$NON-NLS-1$
    public static final String PREF_NEWUCM = "PREF_NEWUCM"; //$NON-NLS-1$

    public GeneralPreferencePage() {
        super(FieldEditorPreferencePage.GRID);

        // Set the preference store for the preference page.
        IPreferenceStore store = JUCMNavPlugin.getDefault().getPreferenceStore();
        setPreferenceStore(store);
    }

    /**
     * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
     */
    protected void createFieldEditors() {
        StringFieldEditor author = new StringFieldEditor(PREF_AUTHOR, Messages.getString("GeneralPreferencePage.author"), getFieldEditorParent()); //$NON-NLS-1$
        addField(author);

        BooleanFieldEditor strict_codeeditor = new BooleanFieldEditor(PREF_STRICTCODEEDITOR,
                Messages.getString("GeneralPreferencePage.StrictPseudoCodeEditor"), getFieldEditorParent()); //$NON-NLS-1$
        addField(strict_codeeditor);
        BooleanFieldEditor metadata_indicator = new BooleanFieldEditor(PREF_METADATAINDVISIBLE,
                Messages.getString("GeneralPreferencePage.ShowMetadataIndicator"), getFieldEditorParent()); //$NON-NLS-1$
        addField(metadata_indicator);
        BooleanFieldEditor grl_iconvisible = new BooleanFieldEditor(PREF_GRLICONVISIBLE,
                Messages.getString("GeneralPreferencePage.ShowGrlContribIcons"), getFieldEditorParent()); //$NON-NLS-1$
        addField(grl_iconvisible);
        BooleanFieldEditor grl_textvisible = new BooleanFieldEditor(PREF_GRLTEXTVISIBLE,
                Messages.getString("GeneralPreferencePage.ShowGrlContribText"), getFieldEditorParent()); //$NON-NLS-1$
        addField(grl_textvisible);
        BooleanFieldEditor grl_autoaddlinks = new BooleanFieldEditor(PREF_GRLAUTOADDLINKS,
                Messages.getString("GeneralPreferencePage.AutoAddLinks"), getFieldEditorParent()); //$NON-NLS-1$
        addField(grl_autoaddlinks);
        
        Group g = new Group(getFieldEditorParent(), SWT.SHADOW_ETCHED_IN);
        g.setText(Messages.getString("GeneralPreferencePage.AdvancedMode")); //$NON-NLS-1$
        
        GridLayout layout = new GridLayout();
        layout.numColumns = 1;
        
        g.setLayout(layout);
        
        GridData data = new GridData();
        
        g.setLayoutData(data);
        
        Composite c = new Composite(g, SWT.NONE);

        BooleanFieldEditor advanced_jucmnav = new BooleanFieldEditor(DisplayPreferences.PREF_ADVANCEDUCM, Messages.getString("GeneralPreferencePage.EnableTheFollowing"), c); //$NON-NLS-1$
        addField(advanced_jucmnav);
        
        c = new Composite(g, SWT.NONE);
        data = new GridData();
        data.grabExcessHorizontalSpace = true;
        data.horizontalIndent = 20;
        c.setLayoutData(data);
        
        BooleanFieldEditor advanced_KPI = new BooleanFieldEditor(DisplayPreferences.PREF_ADVANCEDUCMKPI, Messages.getString("GeneralPreferencePage.KPI"), c); //$NON-NLS-1$
        addField(advanced_KPI);
        
        BooleanFieldEditor advanced_Perf = new BooleanFieldEditor(DisplayPreferences.PREF_ADVANCEDUCMPERF, Messages.getString("GeneralPreferencePage.PerfAnalysis"), c); //$NON-NLS-1$
        addField(advanced_Perf);
        
        BooleanFieldEditor advanced_Aspects = new BooleanFieldEditor(DisplayPreferences.PREF_ADVANCEDUCMASPECTS, Messages.getString("GeneralPreferencePage.Aspects"), c); //$NON-NLS-1$
        addField(advanced_Aspects);
    }

    /**
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    public void init(IWorkbench workbench) {
        // nothing to do
    }

    /**
     * 
     * @return the Author
     */
    public static String getAuthor() {
        return JUCMNavPlugin.getDefault().getPreferenceStore().getString(PREF_AUTHOR);
    }

    /**
     * @return boolean TRUE if editor should be strict.
     */
    public static boolean getStrictCodeEditor() {
        return JUCMNavPlugin.getDefault().getPreferenceStore().getBoolean(PREF_STRICTCODEEDITOR);
    }

    /**
     * @return boolean TRUE if metadata indicator should be visible.
     */
    public static boolean getMetadataIndVisible() {
        return JUCMNavPlugin.getDefault().getPreferenceStore().getBoolean(PREF_METADATAINDVISIBLE);
    }

    /**
     * @return boolean TRUE if GRL contribution icons should be visible.
     */
    public static boolean getGrlIconVisible() {
        return JUCMNavPlugin.getDefault().getPreferenceStore().getBoolean(PREF_GRLICONVISIBLE);
    }

    /**
     * @return boolean TRUE if GRL contribution text should be visible.
     */
    public static boolean getGrlTextVisible() {
        return JUCMNavPlugin.getDefault().getPreferenceStore().getBoolean(PREF_GRLTEXTVISIBLE);
    }

    /**
     * @return boolean TRUE if GRL links should be added automatically when an intentional element is dragged from the Outline and dropped on a model.
     */
    public static boolean getGrlAutoAddLinks() {
        return JUCMNavPlugin.getDefault().getPreferenceStore().getBoolean(PREF_GRLAUTOADDLINKS);
    }

    /**
     * @return whether a new GRL diagram should be created in a new .jucm file
     */
    public static boolean getNewGRL() {
        return JUCMNavPlugin.getDefault().getPreferenceStore().getBoolean(PREF_NEWGRL);
    }

    /**
     * @return whether a new UCM diagram should be created in a new .jucm file
     */
    public static boolean getNewUCM() {
        return JUCMNavPlugin.getDefault().getPreferenceStore().getBoolean(PREF_NEWUCM);
    }

    /**
     * Set whether a new GRL diagram should be created in a new .jucm file
     */
    public static void setNewGRL(boolean value) {
        JUCMNavPlugin.getDefault().getPreferenceStore().setValue(PREF_NEWGRL, value);
    }

    /**
     * Set whether a new UCM diagram should be created in a new .jucm file
     */
    public static void setNewUCM(boolean value) {
        JUCMNavPlugin.getDefault().getPreferenceStore().setValue(PREF_NEWUCM, value);
    }

    public boolean performOk() {

        boolean b = super.performOk();
        ColorManager.refresh();
        return b;
    }
}
