package com.exercicio;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.exercicio.PesquisaMatriz;

public class MatrizServlet extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(MatrizServlet.class.getName()); 
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String UPLOAD_DIRECTORY = "";
		File file = null;
		//process only if its multipart content
        if(ServletFileUpload.isMultipartContent(req)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()
                                         ).parseRequest(req);
               
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        file = new File(item.getName());
                        System.out.println(">>>>> "+item.getName());
                    	String name = file.getName();
                    	System.out.println(">>>>> "+name);
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
            
               //File uploaded successfully
                req.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
            	req.setAttribute("message", "File Upload Failed due to " + ex);
            }         
          
        }else{
        	req.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }

		FileReader fileReader = new FileReader(file);
		String arquivo = req.getParameter("arquivo");
		
		PesquisaMatriz pesquisaMatriz = new PesquisaMatriz();
		pesquisaMatriz.pesquisarMatriz(fileReader);
		
		String parametro = "";
		resp.sendRedirect("/matriz.jsp"+parametro);
	}
}
