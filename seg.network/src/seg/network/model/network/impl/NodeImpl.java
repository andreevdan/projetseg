/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package seg.network.model.network.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import seg.network.model.network.Link;
import seg.network.model.network.Network;
import seg.network.model.network.NetworkPackage;
import seg.network.model.network.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link seg.network.model.network.impl.NodeImpl#getUpstreamLinks <em>Upstream Links</em>}</li>
 *   <li>{@link seg.network.model.network.impl.NodeImpl#getDownstreamLinks <em>Downstream Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends ModelElementImpl implements Node {
	/**
	 * The cached value of the '{@link #getUpstreamLinks() <em>Upstream Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpstreamLinks()
	 * @generated
	 * @ordered
	 */
	protected EList upstreamLinks = null;

	/**
	 * The cached value of the '{@link #getDownstreamLinks() <em>Downstream Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDownstreamLinks()
	 * @generated
	 * @ordered
	 */
	protected EList downstreamLinks = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return NetworkPackage.eINSTANCE.getNode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getUpstreamLinks() {
		if (upstreamLinks == null) {
			upstreamLinks = new EObjectWithInverseResolvingEList(Link.class, this, NetworkPackage.NODE__UPSTREAM_LINKS, NetworkPackage.LINK__TARGET);
		}
		return upstreamLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDownstreamLinks() {
		if (downstreamLinks == null) {
			downstreamLinks = new EObjectWithInverseResolvingEList(Link.class, this, NetworkPackage.NODE__DOWNSTREAM_LINKS, NetworkPackage.LINK__SOURCE);
		}
		return downstreamLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case NetworkPackage.NODE__NETWORK:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, NetworkPackage.NODE__NETWORK, msgs);
				case NetworkPackage.NODE__UPSTREAM_LINKS:
					return ((InternalEList)getUpstreamLinks()).basicAdd(otherEnd, msgs);
				case NetworkPackage.NODE__DOWNSTREAM_LINKS:
					return ((InternalEList)getDownstreamLinks()).basicAdd(otherEnd, msgs);
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
				case NetworkPackage.NODE__NETWORK:
					return eBasicSetContainer(null, NetworkPackage.NODE__NETWORK, msgs);
				case NetworkPackage.NODE__UPSTREAM_LINKS:
					return ((InternalEList)getUpstreamLinks()).basicRemove(otherEnd, msgs);
				case NetworkPackage.NODE__DOWNSTREAM_LINKS:
					return ((InternalEList)getDownstreamLinks()).basicRemove(otherEnd, msgs);
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
				case NetworkPackage.NODE__NETWORK:
					return ((InternalEObject)eContainer).eInverseRemove(this, NetworkPackage.NETWORK__NODES, Network.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return ((InternalEObject)eContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case NetworkPackage.NODE__X:
				return new Integer(getX());
			case NetworkPackage.NODE__Y:
				return new Integer(getY());
			case NetworkPackage.NODE__WIDTH:
				return new Integer(getWidth());
			case NetworkPackage.NODE__HEIGHT:
				return new Integer(getHeight());
			case NetworkPackage.NODE__ID:
				return getId();
			case NetworkPackage.NODE__NETWORK:
				return getNetwork();
			case NetworkPackage.NODE__UPSTREAM_LINKS:
				return getUpstreamLinks();
			case NetworkPackage.NODE__DOWNSTREAM_LINKS:
				return getDownstreamLinks();
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
			case NetworkPackage.NODE__X:
				setX(((Integer)newValue).intValue());
				return;
			case NetworkPackage.NODE__Y:
				setY(((Integer)newValue).intValue());
				return;
			case NetworkPackage.NODE__WIDTH:
				setWidth(((Integer)newValue).intValue());
				return;
			case NetworkPackage.NODE__HEIGHT:
				setHeight(((Integer)newValue).intValue());
				return;
			case NetworkPackage.NODE__ID:
				setId((String)newValue);
				return;
			case NetworkPackage.NODE__NETWORK:
				setNetwork((Network)newValue);
				return;
			case NetworkPackage.NODE__UPSTREAM_LINKS:
				getUpstreamLinks().clear();
				getUpstreamLinks().addAll((Collection)newValue);
				return;
			case NetworkPackage.NODE__DOWNSTREAM_LINKS:
				getDownstreamLinks().clear();
				getDownstreamLinks().addAll((Collection)newValue);
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
			case NetworkPackage.NODE__X:
				setX(X_EDEFAULT);
				return;
			case NetworkPackage.NODE__Y:
				setY(Y_EDEFAULT);
				return;
			case NetworkPackage.NODE__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case NetworkPackage.NODE__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case NetworkPackage.NODE__ID:
				setId(ID_EDEFAULT);
				return;
			case NetworkPackage.NODE__NETWORK:
				setNetwork((Network)null);
				return;
			case NetworkPackage.NODE__UPSTREAM_LINKS:
				getUpstreamLinks().clear();
				return;
			case NetworkPackage.NODE__DOWNSTREAM_LINKS:
				getDownstreamLinks().clear();
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
			case NetworkPackage.NODE__X:
				return x != X_EDEFAULT;
			case NetworkPackage.NODE__Y:
				return y != Y_EDEFAULT;
			case NetworkPackage.NODE__WIDTH:
				return width != WIDTH_EDEFAULT;
			case NetworkPackage.NODE__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case NetworkPackage.NODE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case NetworkPackage.NODE__NETWORK:
				return getNetwork() != null;
			case NetworkPackage.NODE__UPSTREAM_LINKS:
				return upstreamLinks != null && !upstreamLinks.isEmpty();
			case NetworkPackage.NODE__DOWNSTREAM_LINKS:
				return downstreamLinks != null && !downstreamLinks.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //NodeImpl
