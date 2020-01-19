package com.luv2code.springdemo.mvc;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import sun.misc.BASE64Encoder;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;


public class ImageGetSet {
    public static String  setImageToRepo(CommonsMultipartFile file, HttpSession session) throws Exception{
        //String UPLOAD ="C:"+File.separator+"Users"+File.separator+"HARDIK"+File.separator+"IdeaProjects"+File.separator+"GlobalVoxFirst"+File.separator+"out"+File.separator+"artifacts"+File.separator+"web_war_exploded"+File.separator+"images";
        String UPLOAD = "/images";
        ServletContext context = session.getServletContext();
        String path1 = context.getRealPath(UPLOAD);
        System.out.println("**************"+path1 );

        //String filename = file.getOriginalFilename();

        System.out.println(path1);
        String filename = file.getOriginalFilename();
        String fileUploadedName = path1 + File.separator + filename;
        System.out.println(path1+" "+filename);
        System.out.println(fileUploadedName);
        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
        new File(fileUploadedName)));
        stream.write(bytes);
        stream.flush();
        stream.close();

       /* File dest = new File(UPLOAD+"//"+filename);
        file.transferTo(dest);

        System.out.println(dest);
*/
       /* fileUploadedName = "C:\\\\Users\\\\HARDIK\\\\IdeaProjects\\\\GlobalVoxFirst\\\\out\\\\artifacts\\\\web_war_exploded\\\\images\\\\"+filename;
        System.out.println("C:\\\\Users\\\\HARDIK\\\\IdeaProjects\\\\GlobalVoxFirst\\\\out\\\\artifacts\\\\web_war_exploded\\\\images\\\\"+filename);*/
        //return fileUploadedName;
        return filename;
    }

    public static String showImageBytes(String imagename,HttpSession session)throws Exception{
        String UPLOAD = "/images";
        ServletContext context = session.getServletContext();
        String path1 = context.getRealPath(UPLOAD);
        File fi = new File(path1+File.separator+imagename);
        byte[] fileContent = Files.readAllBytes(fi.toPath());
        BASE64Encoder encoder = new BASE64Encoder();
        StringBuilder imageString = new StringBuilder();
        imageString.append("data:image/png;base64,");
        imageString.append(encoder.encode(fileContent));
        return imageString+"";
    }
}
