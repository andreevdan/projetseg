/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ucm.performance.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import ucm.map.PathNode;

import ucm.performance.*;

import urncore.UCMmodelElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see ucm.performance.PerformancePackage
 * @generated
 */
public class PerformanceSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PerformancePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerformanceSwitch() {
		if (modelPackage == null) {
			modelPackage = PerformancePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case PerformancePackage.TIMESTAMP: {
				Timestamp timestamp = (Timestamp)theEObject;
				Object result = caseTimestamp(timestamp);
				if (result == null) result = casePathNode(timestamp);
				if (result == null) result = caseUCMmodelElement(timestamp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.RESPONSE_TIME_REQ: {
				ResponseTimeReq responseTimeReq = (ResponseTimeReq)theEObject;
				Object result = caseResponseTimeReq(responseTimeReq);
				if (result == null) result = caseUCMmodelElement(responseTimeReq);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.OPEN_WORKLOAD: {
				OpenWorkload openWorkload = (OpenWorkload)theEObject;
				Object result = caseOpenWorkload(openWorkload);
				if (result == null) result = caseWorkload(openWorkload);
				if (result == null) result = caseUCMmodelElement(openWorkload);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.CLOSED_WORKLOAD: {
				ClosedWorkload closedWorkload = (ClosedWorkload)theEObject;
				Object result = caseClosedWorkload(closedWorkload);
				if (result == null) result = caseWorkload(closedWorkload);
				if (result == null) result = caseUCMmodelElement(closedWorkload);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.GENERAL_RESOURCE: {
				GeneralResource generalResource = (GeneralResource)theEObject;
				Object result = caseGeneralResource(generalResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.PERF_MEASURE: {
				PerfMeasure perfMeasure = (PerfMeasure)theEObject;
				Object result = casePerfMeasure(perfMeasure);
				if (result == null) result = caseUCMmodelElement(perfMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.PERF_VALUE: {
				PerfValue perfValue = (PerfValue)theEObject;
				Object result = casePerfValue(perfValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.ACTIVE_RESOURCE: {
				ActiveResource activeResource = (ActiveResource)theEObject;
				Object result = caseActiveResource(activeResource);
				if (result == null) result = caseGeneralResource(activeResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.PASSIVE_RESOURCE: {
				PassiveResource passiveResource = (PassiveResource)theEObject;
				Object result = casePassiveResource(passiveResource);
				if (result == null) result = caseGeneralResource(passiveResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.EXTERNAL_OPERATION: {
				ExternalOperation externalOperation = (ExternalOperation)theEObject;
				Object result = caseExternalOperation(externalOperation);
				if (result == null) result = caseActiveResource(externalOperation);
				if (result == null) result = caseGeneralResource(externalOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.PROCESSING_RESOURCE: {
				ProcessingResource processingResource = (ProcessingResource)theEObject;
				Object result = caseProcessingResource(processingResource);
				if (result == null) result = caseActiveResource(processingResource);
				if (result == null) result = caseGeneralResource(processingResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.DEMAND: {
				Demand demand = (Demand)theEObject;
				Object result = caseDemand(demand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Timestamp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Timestamp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTimestamp(Timestamp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Response Time Req</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Response Time Req</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResponseTimeReq(ResponseTimeReq object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Workload</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Workload</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWorkload(Workload object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Open Workload</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Open Workload</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOpenWorkload(OpenWorkload object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Closed Workload</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Closed Workload</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClosedWorkload(ClosedWorkload object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>General Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>General Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGeneralResource(GeneralResource object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Perf Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Perf Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePerfMeasure(PerfMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Perf Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Perf Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePerfValue(PerfValue object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Active Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Active Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseActiveResource(ActiveResource object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Passive Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Passive Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePassiveResource(PassiveResource object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>External Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>External Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExternalOperation(ExternalOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Processing Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Processing Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProcessingResource(ProcessingResource object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Demand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Demand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDemand(Demand object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>UC Mmodel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>UC Mmodel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUCMmodelElement(UCMmodelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Path Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Path Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePathNode(PathNode object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //PerformanceSwitch
