package seg.jUCMNav.importexport.z151.marshal;

import seg.jUCMNav.importexport.z151.generated.*;
//<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
//<!--  Dependency  -->
//<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
//<xsd:complexType name="Dependency">
//  <xsd:complexContent>
//    <xsd:extension base="ElementLink"/>
//  </xsd:complexContent>
//</xsd:complexType>

public class DependencyMHandler extends ElementLinkMHandler {
	public Object handle(Object obj, Object target, boolean isFullConstruction) {
		grl.Dependency elem = (grl.Dependency) obj;
		String objId = elem.getId();
		Dependency elemZ = (Dependency) getObject(objId, target, "createDependency");
		if (isFullConstruction) {
			super.handle(elem, elemZ, true);
		}
		return elemZ;
	}
}
