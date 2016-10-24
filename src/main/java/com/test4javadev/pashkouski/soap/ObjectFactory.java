
package com.test4javadev.pashkouski.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.test4javadev.pashkouski.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDate_QNAME = new QName("http://soap.pashkouski.test4javadev.com/", "getDate");
    private final static QName _GetDateResponse_QNAME = new QName("http://soap.pashkouski.test4javadev.com/", "getDateResponse");
    private final static QName _GetStringDate_QNAME = new QName("http://soap.pashkouski.test4javadev.com/", "getStringDate");
    private final static QName _GetStringDateResponse_QNAME = new QName("http://soap.pashkouski.test4javadev.com/", "getStringDateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.test4javadev.pashkouski.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDateResponse }
     * 
     */
    public GetDateResponse createGetDateResponse() {
        return new GetDateResponse();
    }

    /**
     * Create an instance of {@link GetStringDate }
     * 
     */
    public GetStringDate createGetStringDate() {
        return new GetStringDate();
    }

    /**
     * Create an instance of {@link GetStringDateResponse }
     * 
     */
    public GetStringDateResponse createGetStringDateResponse() {
        return new GetStringDateResponse();
    }

    /**
     * Create an instance of {@link GetDate }
     * 
     */
    public GetDate createGetDate() {
        return new GetDate();
    }

    /**
     * Create an instance of {@link LocalDateTime }
     * 
     */
    public LocalDateTime createLocalDateTime() {
        return new LocalDateTime();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.pashkouski.test4javadev.com/", name = "getDate")
    public JAXBElement<GetDate> createGetDate(GetDate value) {
        return new JAXBElement<GetDate>(_GetDate_QNAME, GetDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.pashkouski.test4javadev.com/", name = "getDateResponse")
    public JAXBElement<GetDateResponse> createGetDateResponse(GetDateResponse value) {
        return new JAXBElement<GetDateResponse>(_GetDateResponse_QNAME, GetDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStringDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.pashkouski.test4javadev.com/", name = "getStringDate")
    public JAXBElement<GetStringDate> createGetStringDate(GetStringDate value) {
        return new JAXBElement<GetStringDate>(_GetStringDate_QNAME, GetStringDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStringDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.pashkouski.test4javadev.com/", name = "getStringDateResponse")
    public JAXBElement<GetStringDateResponse> createGetStringDateResponse(GetStringDateResponse value) {
        return new JAXBElement<GetStringDateResponse>(_GetStringDateResponse_QNAME, GetStringDateResponse.class, null, value);
    }

}
