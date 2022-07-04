
package servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;


public class NoteServlet extends HttpServlet {


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         // connecting the note.txt
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        // reading the file
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        // starts the values
        String title = request.getParameter("t_title");
        String contents = request.getParameter("c_contents");
        
        // reading the file to populate the fields
        title = br.readLine();
        contents = br.readLine();
        

         //creating object
        Note noteObject = new Note(title,contents);
        // setting noteObject as an attribute in the request object
        request.setAttribute("note", noteObject);
        
        //closing buffered reader
        br.close();
        
        // creating parameter to switch to edit page
        String edit = request.getParameter("edit");
        
        // creating a way to connect JSP
        if ( edit == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }else {
            
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);}
    
        // Loading the editnote JSP
        
      return;
    }

   

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // connecting the note.txt
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
       // to write to a file
PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));   

// getting parameters from the JSP
String title = request.getParameter("t_title");
String contents = request.getParameter("c_contents");

// printing inputs to text file
pw.println(title);
pw.println(contents);

// closing printwriter
pw.close();
  
       String save = request.getParameter("s_save");
       
       if (save != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
       }

        //loading the viewnote JSP
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        return;
    }

    

}
