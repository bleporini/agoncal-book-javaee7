package org.agoncal.book.javaee7.chapter19;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCard {

    // ======================================
    // =             Attributes             =
    // ======================================

    @XmlAttribute
    private String number;
    @XmlAttribute(name = "expiry_date")
    private String expiryDate;
    @XmlAttribute(name = "control_number")
    private Integer controlNumber;
    @XmlAttribute
    private String type;

    // ======================================
    // =            Constructors            =
    // ======================================

    public CreditCard() {
    }

    public CreditCard(String number, String expiryDate, Integer controlNumber, String type) {
        this.number = number;
        this.expiryDate = expiryDate;
        this.controlNumber = controlNumber;
        this.type = type;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Integer controlNumber) {
        this.controlNumber = controlNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}