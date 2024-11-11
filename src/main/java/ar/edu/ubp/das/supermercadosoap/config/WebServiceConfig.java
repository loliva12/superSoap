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

    // Configuración para "obtenerListaPrecios"
    @Bean(name = "listaPrecios")
    public DefaultWsdl11Definition listaPreciosWsdlDefinition(XsdSchema listaPreciosSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ListaPreciosWSPort");
        wsdl11Definition.setLocationUri("/services/listaPrecios");
        wsdl11Definition.setTargetNamespace("http://services.supermercadosoap.das.ubp.edu.ar/");
        wsdl11Definition.setSchema(listaPreciosSchema);
        wsdl11Definition.setCreateSoap12Binding(true);
        return wsdl11Definition;
    }


    // Configuración para "obtenerInfoSucursales"
    @Bean(name = "sucursales")
    public DefaultWsdl11Definition sucursalesWsdlDefinition(XsdSchema sucursalesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ListaPreciosWSPort");
        wsdl11Definition.setLocationUri("/services/sucursales");
        wsdl11Definition.setTargetNamespace("http://services.supermercadosoap.das.ubp.edu.ar/");
        wsdl11Definition.setSchema(sucursalesSchema);
        wsdl11Definition.setCreateSoap12Binding(true);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema sucursalesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("ListaPreciosWS_schema1.xsd"));
    }

    @Bean
    public SaajSoapMessageFactory messageFactory() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.setSoapVersion(SoapVersion.SOAP_11);
        return messageFactory;
    }
}
