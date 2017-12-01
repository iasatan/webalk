
package hu.uni.miskolc.iit.webalk.library.controller.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BookRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BookRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isbn" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="publishDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="genre">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Scifi"/>
 *               &lt;enumeration value="Crimi"/>
 *               &lt;enumeration value="Holy"/>
 *               &lt;enumeration value="Other"/>
 *               &lt;enumeration value="Microsoft"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="loaned" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BookRequest", namespace = "http://services.memorynotfound.com/", propOrder = {
    "isbn",
    "title",
    "author",
    "publishDate",
    "genre",
    "loaned"
})
public class BookRequest {

    @XmlElement(namespace = "http://services.memorynotfound.com/")
    protected long isbn;
    @XmlElement(namespace = "http://services.memorynotfound.com/", required = true)
    protected String title;
    @XmlElement(namespace = "http://services.memorynotfound.com/", required = true)
    protected String author;
    @XmlElement(namespace = "http://services.memorynotfound.com/", required = true)
    protected String publishDate;
    @XmlElement(namespace = "http://services.memorynotfound.com/", required = true)
    protected String genre;
    @XmlElement(namespace = "http://services.memorynotfound.com/")
    protected boolean loaned;

    /**
     * Gets the value of the isbn property.
     * 
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     * Sets the value of the isbn property.
     * 
     */
    public void setIsbn(long value) {
        this.isbn = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the publishDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublishDate() {
        return publishDate;
    }

    /**
     * Sets the value of the publishDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublishDate(String value) {
        this.publishDate = value;
    }

    /**
     * Gets the value of the genre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the value of the genre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenre(String value) {
        this.genre = value;
    }

    /**
     * Gets the value of the loaned property.
     * 
     */
    public boolean isLoaned() {
        return loaned;
    }

    /**
     * Sets the value of the loaned property.
     * 
     */
    public void setLoaned(boolean value) {
        this.loaned = value;
    }

}
