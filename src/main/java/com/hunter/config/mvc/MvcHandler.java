package com.hunter.config.mvc;

import com.hunter.propertis.ApplicaitonProperties;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lixiang on 2018/3/17.
 */
public class MvcHandler extends HandlerInterceptorAdapter {

        private ApplicaitonProperties applicaitonProperties;

        private Long fileSize;

        public MvcHandler(ApplicaitonProperties applicaitonProperties) {
                Assert.notNull(applicaitonProperties, "数据不能为空");
                this.applicaitonProperties = applicaitonProperties;
        }

        public long getFileSize() {
                if (fileSize == null) {
                        fileSize = applicaitonProperties.getUploadSize() * 1024 * 1024L;
                }
                return fileSize;
        }

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if (request != null && ServletFileUpload.isMultipartContent(request)) {
                        ServletRequestContext ctx = new ServletRequestContext(request);
                        long requestSize = ctx.contentLength();
                        if (requestSize > getFileSize()) {
                                throw new MaxUploadSizeExceededException(getFileSize());
                        }
                }
                return super.preHandle(request, response, handler);
        }
}
