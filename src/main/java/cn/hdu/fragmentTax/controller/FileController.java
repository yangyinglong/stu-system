package cn.hdu.fragmentTax.controller;


import cn.hdu.fragmentTax.utils.PropertiesUtil;
import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
@Path("/file")
@CrossOrigin
public class FileController {
    private static final String IMAGE_PATH = PropertiesUtil.prop("img_path");

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/upload")
    public void upload(@FormDataParam("file") InputStream fileInputStream,
                       @FormDataParam("file") FormDataContentDisposition fileDisposition,
                       @FormDataParam("fileName") String fileName,
                       @FormDataParam("isFront") String isFront) throws IOException {

        fileName = fileName + "_" + isFront + ".pdf";

        //使用common io的文件写入操作
        FileUtils.copyInputStreamToFile(fileInputStream, new File(IMAGE_PATH + fileName));
    }

    /**
     * 前端请求图片，加随机数的原因是 修改开票人的时候，重新上传图片，如果是同样的请求参数，加载的是页面缓存，而不是重新请求服务器
     * @return
     */
    @GET
//    @Consumes(MediaType.APPLICATION_OCTETd_STREAM)
    @Path("/printImg")
    public Response printIC(@QueryParam("fileName") final String fileName) {
        StreamingOutput fileStream = new StreamingOutput() {
            @Override
            public void write(java.io.OutputStream output) throws WebApplicationException {
                try {
                    java.nio.file.Path path = Paths.get(IMAGE_PATH + fileName);
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                } catch (Exception e) {
                    throw new WebApplicationException("File Not Found !!");
                }
            }
        };
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename =" + fileName)
                .build();
    }
}
