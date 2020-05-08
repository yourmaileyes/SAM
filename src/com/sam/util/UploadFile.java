package com.sam.util;

import com.sam.entity.Activity;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadFile {
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "images";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 500; // 500MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 500; // 500MB
    /**
     * 方法uploadFile(HttpServletRequest)
     * @param request
     * @return
     * @return
     */
    public static Object uploadFile(HttpServletRequest request) throws ParseException {
			/*//程序状态
			boolean isok = true;*/
        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            System.err.println("Error: 表单必须包含 enctype=multipart/form-data");
	          /*  PrintWriter writer = response.getWriter();
	            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
	            writer.flush();*/
            return null;
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;


        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        Map<String,String> pmap = new HashMap<>();
        Activity activity = new Activity();

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理在表单中的字段
                    if(item.isFormField()) {
                        pmap.put(item.getFieldName(), item.getString("utf-8"));
                    }

                }
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        pmap.put("filename",fileName);
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        System.out.println("文件上传成功!");
	                        /*request.setAttribute("message",
	                            "文件上传成功!");*/
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println( "错误信息: " + ex.getMessage());
	           /* request.setAttribute("message",
	                    "错误信息: " + ex.getMessage());*/
        }
        if(pmap.get("id")!=null&&!pmap.get("id").equals("")) {
            activity.setId(Integer.parseInt(pmap.get("id")));
        }
        if(pmap.get("filename")!=null&&!pmap.get("filename").equals("")) {
            activity.setImgurl(pmap.get("filename"));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        activity.setName(pmap.get("name"));
        activity.setContext(pmap.get("context"));
        activity.setResult(pmap.get("result"));
        activity.setStarttime(sdf.parse(pmap.get("starttime")));
        activity.setEndtime(sdf.parse(pmap.get("endtime")));
        activity.setStatus(1);
        return activity;
    }
}
