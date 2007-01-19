package seg.jUCMNav.editors.resourceManagement;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * This class is used to load and save the model from the file system.
 * 
 * This class is inspired from the IBM RedBook Eclipse Development using the Graphical Editing Framework and the Eclipse Modeling Framework
 * 
 * @author Etienne Tremblay
 */
public abstract class EmfModelManager {

	/**
	 * For the purpose of the simple editor, a file can only contain a UCM. In EMF, a resource provides the way to have access to the model content.
	 */
	protected Resource resource = null;
	/**
	 * Gives access to the top level model element contained in the resource.
	 */
	protected EObject model = null;
	
	
	

	/**
	 * Returns the resource containing the UCM. Uses lazy initialization.
	 * 
	 * @param path
	 * @return resource containing the UCM
	 */
	public Resource getResource(IPath path) {
	    if (resource == null) {
	
	        ResourceSet resSet = getResourceSet();
	        resource = resSet.getResource(URI.createPlatformResourceURI(path.toString()), true);
	    }
	    return resource;
	}

	/**
	 * Returns the resource containing the UCM. Uses lazy initialization.
	 * 
	 * @param path
	 * @return resource containing the UCM
	 */
	public Resource getResource(File path) {
	    if (resource == null) {
	
	        ResourceSet resSet = getResourceSet();
	        resource = resSet.getResource(URI.createFileURI(path.toString()), true);
	    }
	    return resource;
	}

	/**
	 * Creates a resource to contain the UCM. The resource file does not exist yet.
	 * 
	 * @param path
	 * @return resource to contain the UCM
	 */
	protected Resource createResource(IPath path) {
	    ResourceSet resSet = getResourceSet();
	    resource = resSet.createResource(URI.createPlatformResourceURI(path.toString()));
	    return resource;
	}

	/**
	 * Creates a resource to contain the UCM. The resource file does not exist yet.
	 * 
	 * @param path
	 * @return resource to contain the UCM
	 */
	protected Resource createResource(File path) {
	    ResourceSet resSet = getResourceSet();
	    resource = resSet.createResource(URI.createFileURI(path.toString()));
	    return resource;
	}

	/**
	 * Returns the resource set.
	 * 
	 * @return the resource set
	 */
	protected ResourceSet getResourceSet() {
		init();
	    // Register the XMI resource factory for the .ucm extension
	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map m = reg.getExtensionToFactoryMap();
	    m.put(getFileExtension(), new XMIResourceFactoryImpl());
	    // Obtain a new resource set
	    return new ResourceSetImpl();
	}

	protected abstract void init();
	protected abstract String getFileExtension();
	
	/**
	 * Loads the content of the model from the file.
	 * 
	 * @param path
	 */
	public void load(IPath path) throws IOException {
	    getResource(path);
	    Map options = new HashMap();
	    
	    options.put(XMIResource.OPTION_DECLARE_XML, Boolean.TRUE);
	    resource.load(options);
	}

	/**
	 * Loads the content of the model from the file.
	 * 
	 * @param path
	 */
	public void load(File path) throws IOException {
	    getResource(path);
	    Map options = new HashMap();
	    
	    options.put(XMIResource.OPTION_DECLARE_XML, Boolean.TRUE);
	    resource.load(options);
	}

	/**
	 * reloads the content of the model from the file.
	 * 
	 * @param path
	 */
	public void reload(IPath path) throws IOException {
	    getResource(path).unload();
	    load(path);
	}

	/**
	 * reloads the content of the model from the file.
	 * 
	 * @param path
	 */
	public void reload(File path) throws IOException {
	    getResource(path).unload();
	    load(path);
	}

	/**
	 * Saves the content of the model to the file.
	 * 
	 * @param path
	 */
	public void save(IPath path) throws IOException {
	    getResource(path);
	    Map options = new HashMap();
	    options.put(XMIResource.OPTION_DECLARE_XML, Boolean.TRUE);
	    // latin 1
	    options.put(XMIResource.OPTION_ENCODING, "ISO-8859-1"); //$NON-NLS-1$
	            
	    resource.save(options);
	}

	/**
	 * Saves the content of the model to the file.
	 * 
	 * @param path
	 */
	public void save(File path) throws IOException {
	    getResource(path);
	    Map options = new HashMap();
	    options.put(XMIResource.OPTION_DECLARE_XML, Boolean.TRUE);
	    // latin 1
	    options.put(XMIResource.OPTION_ENCODING, "ISO-8859-1"); //$NON-NLS-1$
	            
	    resource.save(options);
	}

}
