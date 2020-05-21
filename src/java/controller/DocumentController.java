/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DocumentDao;
import dao.GorselIslem;
import entity.Document;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Barsan
 */
@Named
@SessionScoped
public class DocumentController implements Serializable{
    private Document document;
    private List<Document> documentList;
    private DocumentDao documentDao;
    
    private Part doc;
    
    private final String uploadTo ="/Users/Barsan/Desktop/Java/Upload/";
    
    public void upload(){
        try{
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo+doc.getSubmittedFileName());
            Files.copy(input, f.toPath());
            
            document = this.getDocument();
            document.setFilePath(f.getParent());
            document.setFileName(f.getName());
            document.setFileType(doc.getContentType());
            GorselIslem fi=new GorselIslem(uploadTo);
            fi.time(document);
            this.getDocumentDao().insert(document);
        }catch( IOException e){
            System.out.println(e.getMessage());
        }
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Document getDocument() {
        if(this.document == null)
            this.document = new Document();
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        this.documentList = this.getDocumentDao().findAll();
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public DocumentDao getDocumentDao() {
        if( this.documentDao == null){
            this.documentDao = new DocumentDao();
        }
        return documentDao;
    }

    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }
    
    
}
