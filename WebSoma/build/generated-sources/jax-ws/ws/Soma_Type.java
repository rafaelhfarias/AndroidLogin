
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Soma complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Soma"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="primeiroValor" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="segundoValor" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Soma", propOrder = {
    "primeiroValor",
    "segundoValor"
})
public class Soma_Type {

    protected int primeiroValor;
    protected int segundoValor;

    /**
     * Obtém o valor da propriedade primeiroValor.
     * 
     */
    public int getPrimeiroValor() {
        return primeiroValor;
    }

    /**
     * Define o valor da propriedade primeiroValor.
     * 
     */
    public void setPrimeiroValor(int value) {
        this.primeiroValor = value;
    }

    /**
     * Obtém o valor da propriedade segundoValor.
     * 
     */
    public int getSegundoValor() {
        return segundoValor;
    }

    /**
     * Define o valor da propriedade segundoValor.
     * 
     */
    public void setSegundoValor(int value) {
        this.segundoValor = value;
    }

}
