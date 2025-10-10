package com.example.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.ExternalContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import java.io.IOException;
import java.io.InputStream;

@Named
@RequestScoped
public class ImageBean {

    // Método que será chamado pela tag p:graphicImage
    public StreamedContent getImagem() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        
        // Obtém o InputStream do recurso a partir do caminho do webapp
        // O caminho deve ser relativo à raiz do webapp, e a imagem está em 'resources/images'
        InputStream inputStream = externalContext.getResourceAsStream("/resources/images/logo_empresa.png");
        
        if (inputStream == null) {
            // Retorna null ou uma imagem de erro se o arquivo não for encontrado
            System.err.println("Recurso não encontrado: /resources/images/logo_empresa.png");
            return null;
        }

        // Constrói e retorna o objeto StreamedContent
        return DefaultStreamedContent.builder()
            .contentType("image/png")
            .stream(() -> inputStream)
            .name("logo_empresa.png")
            .build();
    }
}
