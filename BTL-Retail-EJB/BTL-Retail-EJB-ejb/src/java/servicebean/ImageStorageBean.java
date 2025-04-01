/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicebean;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Base64;
import javax.ejb.Stateless;

/**
 *
 * @author ADMIN
 */
@Stateless
public class ImageStorageBean {
     private final String UPLOAD_DIR = new File(getProjectRootPath(), "images").getAbsolutePath();
     private final String IMAGE_PNG = ".png";
      private final String IMAGE_JPG = ".JPG";
     
    public boolean saveImage(String fileName, InputStream fileContent) {
//        String basePath = getProjectRootPath();
//        String uploadPath = new File(basePath, UPLOAD_DIR).getAbsolutePath();
        File uploadDir = new File(UPLOAD_DIR);

        // Tạo thư mục nếu chưa có
        if (!uploadDir.exists() && !uploadDir.mkdirs()) 
            System.err.println("Không thể tạo thư mục lưu ảnh: " + UPLOAD_DIR);
        
        File file = new File(uploadDir, fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Ảnh đã lưu tại: " + file.getAbsolutePath());
            return true;
        } catch (IOException e) {
            System.err.println("Lỗi lưu ảnh" + e.getMessage());
            return false;
        }
    }
     
    public InputStream getImage(String fileName){
        File file = new File(UPLOAD_DIR, fileName + IMAGE_PNG);
        if(!file.exists())  file = new File(UPLOAD_DIR, fileName + IMAGE_JPG);
        if(!file.exists()) return null;
        
        try{
            return new FileInputStream(file);
        }catch (IOException e){
            System.err.println("Lỗi lấy ảnh: " +e.getMessage());
            return null;
        }
    }
    
    public String convertToBase64(InputStream inputStream) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = outputStream.toByteArray();
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            System.err.println("Lỗi chuyển đổi file sang Base 64: "+ e);
            return null;
        }
    }
    
    private String getProjectRootPath() {
        try {
            String path = getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            File file = new File(path);
             return file.getParentFile().getParentFile().getParentFile().getParentFile().getAbsolutePath(); // Lấy thư mục gốc của dự án
        } catch (URISyntaxException e) {
            throw new RuntimeException("Không thể xác định thư mục gốc của project!", e);
        }
    }
}
