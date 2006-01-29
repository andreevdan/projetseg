/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package grl.impl;

import grl.GRLGraph;
import grl.GrlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import urncore.IURNConnection;
import urncore.IURNContainerRef;
import urncore.IURNDiagram;
import urncore.IURNNode;
import urncore.URNdefinition;
import urncore.UrncorePackage;
import urncore.impl.GRLmodelElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>GRL Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link grl.impl.GRLGraphImpl#getUrndefinition <em>Urndefinition</em>}</li>
 *   <li>{@link grl.impl.GRLGraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link grl.impl.GRLGraphImpl#getContRefs <em>Cont Refs</em>}</li>
 *   <li>{@link grl.impl.GRLGraphImpl#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GRLGraphImpl extends GRLmodelElementImpl implements GRLGraph {
    /**
     * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNodes()
     * @generated
     * @ordered
     */
    protected EList nodes = null;

    /**
     * The cached value of the '{@link #getContRefs() <em>Cont Refs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContRefs()
     * @generated
     * @ordered
     */
    protected EList contRefs = null;

    /**
     * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnections()
     * @generated
     * @ordered
     */
    protected EList connections = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GRLGraphImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return GrlPackage.eINSTANCE.getGRLGraph();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public URNdefinition getUrndefinition() {
        if (eContainerFeatureID != GrlPackage.GRL_GRAPH__URNDEFINITION) return null;
        return (URNdefinition)eContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUrndefinition(URNdefinition newUrndefinition) {
        if (newUrndefinition != eContainer || (eContainerFeatureID != GrlPackage.GRL_GRAPH__URNDEFINITION && newUrndefinition != null)) {
            if (EcoreUtil.isAncestor(this, newUrndefinition))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eContainer != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newUrndefinition != null)
                msgs = ((InternalEObject)newUrndefinition).eInverseAdd(this, UrncorePackage.UR_NDEFINITION__SPEC_DIAGRAMS, URNdefinition.class, msgs);
            msgs = eBasicSetContainer((InternalEObject)newUrndefinition, GrlPackage.GRL_GRAPH__URNDEFINITION, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GrlPackage.GRL_GRAPH__URNDEFINITION, newUrndefinition, newUrndefinition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getNodes() {
        if (nodes == null) {
            nodes = new EObjectContainmentWithInverseEList(IURNNode.class, this, GrlPackage.GRL_GRAPH__NODES, UrncorePackage.IURN_NODE__DIAGRAM);
        }
        return nodes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getContRefs() {
        if (contRefs == null) {
            contRefs = new EObjectContainmentWithInverseEList(IURNContainerRef.class, this, GrlPackage.GRL_GRAPH__CONT_REFS, UrncorePackage.IURN_CONTAINER_REF__DIAGRAM);
        }
        return contRefs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getConnections() {
        if (connections == null) {
            connections = new EObjectContainmentWithInverseEList(IURNConnection.class, this, GrlPackage.GRL_GRAPH__CONNECTIONS, UrncorePackage.IURN_CONNECTION__DIAGRAM);
        }
        return connections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
        if (featureID >= 0) {
            switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
                case GrlPackage.GRL_GRAPH__FROM_LINKS:
                    return ((InternalEList)getFromLinks()).basicAdd(otherEnd, msgs);
                case GrlPackage.GRL_GRAPH__TO_LINKS:
                    return ((InternalEList)getToLinks()).basicAdd(otherEnd, msgs);
                case GrlPackage.GRL_GRAPH__URNDEFINITION:
                    if (eContainer != null)
                        msgs = eBasicRemoveFromContainer(msgs);
                    return eBasicSetContainer(otherEnd, GrlPackage.GRL_GRAPH__URNDEFINITION, msgs);
                case GrlPackage.GRL_GRAPH__NODES:
                    return ((InternalEList)getNodes()).basicAdd(otherEnd, msgs);
                case GrlPackage.GRL_GRAPH__CONT_REFS:
                    return ((InternalEList)getContRefs()).basicAdd(otherEnd, msgs);
                case GrlPackage.GRL_GRAPH__CONNECTIONS:
                    return ((InternalEList)getConnections()).basicAdd(otherEnd, msgs);
                default:
                    return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
            }
        }
        if (eContainer != null)
            msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
        if (featureID >= 0) {
            switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
                case GrlPackage.GRL_GRAPH__FROM_LINKS:
                    return ((InternalEList)getFromLinks()).basicRemove(otherEnd, msgs);
                case GrlPackage.GRL_GRAPH__TO_LINKS:
                    return ((InternalEList)getToLinks()).basicRemove(otherEnd, msgs);
                case GrlPackage.GRL_GRAPH__URNDEFINITION:
                    return eBasicSetContainer(null, GrlPackage.GRL_GRAPH__URNDEFINITION, msgs);
                case GrlPackage.GRL_GRAPH__NODES:
                    return ((InternalEList)getNodes()).basicRemove(otherEnd, msgs);
                case GrlPackage.GRL_GRAPH__CONT_REFS:
                    return ((InternalEList)getContRefs()).basicRemove(otherEnd, msgs);
                case GrlPackage.GRL_GRAPH__CONNECTIONS:
                    return ((InternalEList)getConnections()).basicRemove(otherEnd, msgs);
                default:
                    return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
            }
        }
        return eBasicSetContainer(null, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
        if (eContainerFeatureID >= 0) {
            switch (eContainerFeatureID) {
                case GrlPackage.GRL_GRAPH__URNDEFINITION:
                    return eContainer.eInverseRemove(this, UrncorePackage.UR_NDEFINITION__SPEC_DIAGRAMS, URNdefinition.class, msgs);
                default:
                    return eDynamicBasicRemoveFromContainer(msgs);
            }
        }
        return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
        switch (eDerivedStructuralFeatureID(eFeature)) {
            case GrlPackage.GRL_GRAPH__FROM_LINKS:
                return getFromLinks();
            case GrlPackage.GRL_GRAPH__TO_LINKS:
                return getToLinks();
            case GrlPackage.GRL_GRAPH__ID:
                return getId();
            case GrlPackage.GRL_GRAPH__NAME:
                return getName();
            case GrlPackage.GRL_GRAPH__DESCRIPTION:
                return getDescription();
            case GrlPackage.GRL_GRAPH__URNDEFINITION:
                return getUrndefinition();
            case GrlPackage.GRL_GRAPH__NODES:
                return getNodes();
            case GrlPackage.GRL_GRAPH__CONT_REFS:
                return getContRefs();
            case GrlPackage.GRL_GRAPH__CONNECTIONS:
                return getConnections();
        }
        return eDynamicGet(eFeature, resolve);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eSet(EStructuralFeature eFeature, Object newValue) {
        switch (eDerivedStructuralFeatureID(eFeature)) {
            case GrlPackage.GRL_GRAPH__FROM_LINKS:
                getFromLinks().clear();
                getFromLinks().addAll((Collection)newValue);
                return;
            case GrlPackage.GRL_GRAPH__TO_LINKS:
                getToLinks().clear();
                getToLinks().addAll((Collection)newValue);
                return;
            case GrlPackage.GRL_GRAPH__ID:
                setId((String)newValue);
                return;
            case GrlPackage.GRL_GRAPH__NAME:
                setName((String)newValue);
                return;
            case GrlPackage.GRL_GRAPH__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case GrlPackage.GRL_GRAPH__URNDEFINITION:
                setUrndefinition((URNdefinition)newValue);
                return;
            case GrlPackage.GRL_GRAPH__NODES:
                getNodes().clear();
                getNodes().addAll((Collection)newValue);
                return;
            case GrlPackage.GRL_GRAPH__CONT_REFS:
                getContRefs().clear();
                getContRefs().addAll((Collection)newValue);
                return;
            case GrlPackage.GRL_GRAPH__CONNECTIONS:
                getConnections().clear();
                getConnections().addAll((Collection)newValue);
                return;
        }
        eDynamicSet(eFeature, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eUnset(EStructuralFeature eFeature) {
        switch (eDerivedStructuralFeatureID(eFeature)) {
            case GrlPackage.GRL_GRAPH__FROM_LINKS:
                getFromLinks().clear();
                return;
            case GrlPackage.GRL_GRAPH__TO_LINKS:
                getToLinks().clear();
                return;
            case GrlPackage.GRL_GRAPH__ID:
                setId(ID_EDEFAULT);
                return;
            case GrlPackage.GRL_GRAPH__NAME:
                setName(NAME_EDEFAULT);
                return;
            case GrlPackage.GRL_GRAPH__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case GrlPackage.GRL_GRAPH__URNDEFINITION:
                setUrndefinition((URNdefinition)null);
                return;
            case GrlPackage.GRL_GRAPH__NODES:
                getNodes().clear();
                return;
            case GrlPackage.GRL_GRAPH__CONT_REFS:
                getContRefs().clear();
                return;
            case GrlPackage.GRL_GRAPH__CONNECTIONS:
                getConnections().clear();
                return;
        }
        eDynamicUnset(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean eIsSet(EStructuralFeature eFeature) {
        switch (eDerivedStructuralFeatureID(eFeature)) {
            case GrlPackage.GRL_GRAPH__FROM_LINKS:
                return fromLinks != null && !fromLinks.isEmpty();
            case GrlPackage.GRL_GRAPH__TO_LINKS:
                return toLinks != null && !toLinks.isEmpty();
            case GrlPackage.GRL_GRAPH__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case GrlPackage.GRL_GRAPH__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case GrlPackage.GRL_GRAPH__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case GrlPackage.GRL_GRAPH__URNDEFINITION:
                return getUrndefinition() != null;
            case GrlPackage.GRL_GRAPH__NODES:
                return nodes != null && !nodes.isEmpty();
            case GrlPackage.GRL_GRAPH__CONT_REFS:
                return contRefs != null && !contRefs.isEmpty();
            case GrlPackage.GRL_GRAPH__CONNECTIONS:
                return connections != null && !connections.isEmpty();
        }
        return eDynamicIsSet(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
        if (baseClass == IURNDiagram.class) {
            switch (derivedFeatureID) {
                case GrlPackage.GRL_GRAPH__URNDEFINITION: return UrncorePackage.IURN_DIAGRAM__URNDEFINITION;
                case GrlPackage.GRL_GRAPH__NODES: return UrncorePackage.IURN_DIAGRAM__NODES;
                case GrlPackage.GRL_GRAPH__CONT_REFS: return UrncorePackage.IURN_DIAGRAM__CONT_REFS;
                case GrlPackage.GRL_GRAPH__CONNECTIONS: return UrncorePackage.IURN_DIAGRAM__CONNECTIONS;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
        if (baseClass == IURNDiagram.class) {
            switch (baseFeatureID) {
                case UrncorePackage.IURN_DIAGRAM__URNDEFINITION: return GrlPackage.GRL_GRAPH__URNDEFINITION;
                case UrncorePackage.IURN_DIAGRAM__NODES: return GrlPackage.GRL_GRAPH__NODES;
                case UrncorePackage.IURN_DIAGRAM__CONT_REFS: return GrlPackage.GRL_GRAPH__CONT_REFS;
                case UrncorePackage.IURN_DIAGRAM__CONNECTIONS: return GrlPackage.GRL_GRAPH__CONNECTIONS;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //GRLGraphImpl