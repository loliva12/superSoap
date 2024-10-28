package ar.edu.ubp.das.supermercadosoap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/services/*");
    }

    @Bean(name = "sucursales")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema sucursalesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SucursalesInfoWSPort");
        wsdl11Definition.setLocationUri("/services");
        wsdl11Definition.setTargetNamespace("http://services.supermercadosoap.das.ubp.edu.ar/");
        wsdl11Definition.setSchema(sucursalesSchema);
        wsdl11Definition.setCreateSoap12Binding(true);
        return wsdl11Definition;
    }

    @Bean
    public SaajSoapMessageFactory messageFactory() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.setSoapVersion(SoapVersion.SOAP_12);
        return messageFactory;
    }

    @Bean
    public XsdSchema sucursalesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("SucursalesInfoWSService_schema1.xsd"));
    }
    @Bean(name = "listaPrecios")
    public DefaultWsdl11Definition listaPreciosWsdlDefinition(XsdSchema sucursalesPreciosSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SucursalesPreciosWSPort");
        wsdl11Definition.setLocationUri("/services/sucursalesPrecios");
        wsdl11Definition.setTargetNamespace("http://services.supermercadosoap.das.ubp.edu.ar/sucursalesPrecios");
        wsdl11Definition.setSchema(sucursalesPreciosSchema);
        wsdl11Definition.setCreateSoap12Binding(true);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema sucursalesPreciosSchema() {
        return new SimpleXsdSchema(new ClassPathResource("SucursalesPreciosWSService_schema1.xsd"));
    }
}
