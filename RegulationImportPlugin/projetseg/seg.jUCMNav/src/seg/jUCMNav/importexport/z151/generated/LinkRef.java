//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.9-03/31/2009 04:14 PM(snajper)-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.07.19 at 07:21:12 PM EDT 
//


package seg.jUCMNav.importexport.z151.generated;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LinkRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LinkRef">
 *   &lt;complexContent>
 *     &lt;extension base="{}GRLmodelElement">
 *       &lt;sequence>
 *         &lt;element name="curve" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="link" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *         &lt;element name="bendpoints" type="{}LinkRefBendpoint" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="label" type="{}Label" minOccurs="0"/>
 *         &lt;element name="target" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkRef", propOrder = {
    "curve",
    "link",
    "bendpoints",
    "label",
    "target",
    "source"
})
public class LinkRef
    extends GRLmodelElement
{

    protected boolean curve;
    @XmlElement(required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object link;
    protected List<LinkRefBendpoint> bendpoints;
    protected Label label;
    @XmlElement(required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object target;
    @XmlElement(required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object source;

    /**
     * Gets the value of the curve property.
     * 
     */
    public boolean isCurve() {
        return curve;
    }

    /**
     * Sets the value of the curve property.
     * 
     */
    public void setCurve(boolean value) {
        this.curve = value;
    }

    /**
     * Gets the value of the link property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setLink(Object value) {
        this.link = value;
    }

    /**
     * Gets the value of the bendpoints property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bendpoints property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBendpoints().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinkRefBendpoint }
     * 
     * 
     */
    public List<LinkRefBendpoint> getBendpoints() {
        if (bendpoints == null) {
            bendpoints = new ArrayList<LinkRefBendpoint>();
        }
        return this.bendpoints;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link Label }
     *     
     */
    public Label getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link Label }
     *     
     */
    public void setLabel(Label value) {
        this.label = value;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTarget(Object value) {
        this.target = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSource(Object value) {
        this.source = value;
    }

}
