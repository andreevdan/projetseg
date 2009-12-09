package seg.jUCMNav.importexport.z151.marshal;

//  <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
//  <!--  ComponentRef  -->
//  <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
//  <xsd:complexType name="ComponentRef">
//    <xsd:complexContent>
//      <xsd:extension base="UCMmodelElement">
//        <xsd:sequence>
//		<xsd:element maxOccurs="unbounded" minOccurs="0" name="parentBindings" type="xsd:IDREF"/> <!-- ComponentBinding -->
//          <xsd:element maxOccurs="unbounded" minOccurs="0" name="pluginBindings" type="xsd:IDREF"/>  <!-- ComponentBinding -->
//          <xsd:element name="compDef" type="xsd:IDREF"/>  <!-- Component -->
//          <xsd:element minOccurs="0" name="label" type="Label"/>
//          <xsd:element maxOccurs="unbounded" minOccurs="0" name="children" type="xsd:IDREF"/>  <!-- ComponentRef -->
//          <xsd:element minOccurs="0" name="parent" type="xsd:IDREF"/>  <!-- ComponentRef -->
//          <xsd:element maxOccurs="unbounded" minOccurs="0" name="nodes" type="xsd:IDREF"/>  <!-- PathNode -->
//          <xsd:element minOccurs="0" name="pos" type="Position"/>
//          <xsd:element minOccurs="0" name="size" type="Size"/>
//        </xsd:sequence>
//      </xsd:extension>
//    </xsd:complexContent>
//  </xsd:complexType>
//Z151 has size, but not from jUCMNav
import java.math.BigInteger;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import seg.jUCMNav.importexport.z151.generated.*;

public class ComponentRefMHandler extends UCMmodelElementMHandler {
	public Object handle(Object o, Object target, boolean isFullConstruction) {
		ucm.map.ComponentRef elem = (ucm.map.ComponentRef) o;
		String objId = elem.getId();
		ComponentRef elemZ = (ComponentRef) id2object.get(objId);
		if (null == elemZ) {
			if (null == target) {
				elemZ = of.createComponentRef();
			} else
				elemZ = (ComponentRef) target;
			id2object.put(objId, elemZ);
		}
		if (isFullConstruction) {
			elemZ = (ComponentRef) super.handle(elem, elemZ, true);
			// compDef
			elemZ.setCompDef(process(elem.getContDef(), null, false));
			Size sizeZ = of.createSize();
			sizeZ.setHeight(new BigInteger(Integer.toString(elem.getHeight())));
			sizeZ.setWidth(new BigInteger(Integer.toString(elem.getWidth())));
			elemZ.setSize(sizeZ);
			// parent
			elemZ.setParent(process((ucm.map.ComponentRef) elem.getParent(), null, false));

			// label
			if (elem.getLabel() != null) {
				Label labelZ = of.createLabel();
				labelZ.setDeltaX(new BigInteger(Integer.toString(elem.getLabel().getDeltaX())));
				labelZ.setDeltaY(new BigInteger(Integer.toString(elem.getLabel().getDeltaY())));
				elemZ.setLabel(labelZ);
			}
			// pos
			Position positionZ = of.createPosition();
			positionZ.setX(new BigInteger(Integer.toString(elem.getX())));
			positionZ.setY(new BigInteger(Integer.toString(elem.getY())));
			elemZ.setPos(positionZ);
			// elemZ.setId();
			// elemZ.setDesc();
			// elemZ.setConcern();
			// elemZ.setName();

			// nodes
			processList(elem.getNodes(), elemZ.getNodes(), "createComponentRefNodes", false);
			// parentBindings
			processList(elem.getParentBindings(), elemZ.getParentBindings(), "createComponentRefParentBindings", false);
			// pluginBindings
			processList(elem.getPluginBindings(), elemZ.getPluginBindings(), "createComponentRefPluginBindings", false);
			// elemZ.getCompDef();
			// elemZ.getParent();
			// TODO elemZ.getSize();
			// elemZ.getLabel();
			// children
			processList(elem.getChildren(), elemZ.getChildren(), "createComponentRefChildren", false);
			// elemZ.getPos();
			// elemZ.getMetadata();
			// elemZ.getToLinks();
			// elemZ.getFromLinks();
			// elemZ.getConcern();
			// elemZ.getName();
			// elemZ.getId();
			// elemZ.getDesc();
			// elemZ.getClass();

			List<Metadata> list = elemZ.getMetadata();
			int item = elem.getReplicationFactor();
			Metadata mdZ = of.createMetadata();
			mdZ.setName("jUCMNav ComponentRef replicationFactor");
			mdZ.setValue(Integer.toString(item));
			list.add(mdZ);

			String role = elem.getRole();
			if (role != null) {
				mdZ = of.createMetadata();
				mdZ.setName("jUCMNav ComponentRef role");
				mdZ.setValue(role);
				list.add(mdZ);
			}

			boolean anchored = elem.isAnchored();
			mdZ = of.createMetadata();
			mdZ.setName("jUCMNav ComponentRef anchored");
			mdZ.setValue(Boolean.toString(anchored));
			list.add(mdZ);
			
			boolean fixed = elem.isFixed();
			mdZ = of.createMetadata();
			mdZ.setName("jUCMNav ComponentRef fixed");
			mdZ.setValue(Boolean.toString(fixed));
			list.add(mdZ);
		}
		return elemZ;
	}
}
