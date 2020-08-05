package com.github.charlotte.fdfs;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * https://github.com/tobato/FastDFS_Client
 *
 * @author Daniel
 */
@Controller
public class ApiController {

//    https://github.com/tobato/FastDFS_Client
    @Autowired
    private FastFileStorageClient fc;

    @RequestMapping("/down")
    @ResponseBody
    public ResponseEntity<byte[]> down(HttpServletResponse resp) {

        DownloadByteArray cb = new DownloadByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "aaa.xx");
        byte[] bs = fc.downloadFile("group1", "M00/00/00/Cs4ADF8pEvWAGuuBACtFrCPd_jM.tar.gz", cb);


        return new ResponseEntity<>(bs,headers, HttpStatus.OK);
    }


}
