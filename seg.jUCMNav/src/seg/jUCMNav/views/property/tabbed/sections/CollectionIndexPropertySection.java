package seg.jUCMNav.views.property.tabbed.sections;

import grl.GRLGraph;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import seg.jUCMNav.Messages;
import seg.jUCMNav.editors.UCMNavMultiPageEditor;
import seg.jUCMNav.model.commands.transformations.ChangeUCMDiagramOrder;
import seg.jUCMNav.views.wizards.URNDiagramIndexDialog;
import ucm.map.UCMmap;
import urncore.IURNDiagram;
import urncore.URNdefinition;

public class CollectionIndexPropertySection extends AbstractDialogPropertySection {
    protected URNdefinition spec;
    protected IURNDiagram current;
    
    @Override
    protected String getText() {
        return (new Integer(spec.getSpecDiagrams().indexOf(current))).toString();
    }

    @Override
    protected void openDialog() {
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        
        ILabelProvider labelP = new ILabelProvider() {

            public Image getImage(Object element) {
                // TODO Auto-generated method stub
                return null;
            }

            public String getText(Object element) {
                if(element instanceof UCMmap)
                    return ((UCMmap) element).getName();
                else if (element instanceof GRLGraph)
                    return ((GRLGraph) element).getName();
                
                return null;
            }

            public void addListener(ILabelProviderListener listener) {
                // TODO Auto-generated method stub
                
            }

            public void dispose() {
                // TODO Auto-generated method stub
                
            }

            public boolean isLabelProperty(Object element, String property) {
                // TODO Auto-generated method stub
                return false;
            }

            public void removeListener(ILabelProviderListener listener) {
                // TODO Auto-generated method stub
                
            }
        };
        
        URNDiagramIndexDialog dialog = new URNDiagramIndexDialog(shell, labelP);
        dialog.setElements(spec.getSpecDiagrams().toArray());
        dialog.open();
        
        Object[] result = dialog.getResult();
        
        if(result != null) {
            IURNDiagram d = (IURNDiagram)result[0];
            
            int from = spec.getSpecDiagrams().indexOf(current);
            int to = spec.getSpecDiagrams().indexOf(d);
            boolean after = ((Boolean)result[1]).booleanValue();
            
            if (from < to && !after)
                to--;
            else if (from > to && after)
                to++;
            
            ChangeUCMDiagramOrder cmd = new ChangeUCMDiagramOrder(current.getUrndefinition(), from, to);
            UCMNavMultiPageEditor editor = (UCMNavMultiPageEditor)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
            editor.getDelegatingCommandStack().execute(cmd);
        }
    }

    @Override
    protected Object resolve(Object obj) {
        
        current = (IURNDiagram)obj;
        spec = ((IURNDiagram)obj).getUrndefinition();
        
        return spec;
    }

    @Override
    public String getLabelText() {
        return Messages.getString("CollectionIndexPropertySection_Index"); //$NON-NLS-1$
    }

}