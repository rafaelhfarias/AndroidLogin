
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Login complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Login">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="primeiroValor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segundoValor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Login", propOrder = {
    "primeiroValor",
    "segundoValor"
})
public class Login_Type {

    protected String primeiroValor;
    protected String segundoValor;

    /**
     * Obtém o valor da propriedade primeiroValor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimeiroValor() {
        return primeiroValor;
    }

    /**
     * Define o valor da propriedade primeiroValor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimeiroValor(String value) {
        this.primeiroValor = value;
    }

    /**
     * Obtém o valor da propriedade segundoValor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegundoValor() {
        return segundoValor;
    }

    /**
     * Define o valor da propriedade segundoValor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegundoValor(String value) {
        this.segundoValor = value;
    }

}
