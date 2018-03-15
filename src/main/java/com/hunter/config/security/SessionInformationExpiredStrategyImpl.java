package com.hunter.config.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 * Created by lixiang on 2018/3/15.
 */
public class SessionInformationExpiredStrategyImpl implements SessionInformationExpiredStrategy {

        private final Log logger = LogFactory.getLog(getClass());
        private final String destinationUrl;
        private final RedirectStrategy redirectStrategy;
        private final RequestCache cacheRequest;

        public SessionInformationExpiredStrategyImpl(String invalidSessionUrl) {
                this(invalidSessionUrl, new DefaultRedirectStrategy(), new HttpSessionRequestCache());
        }

        public SessionInformationExpiredStrategyImpl(String invalidSessionUrl, RedirectStrategy redirectStrategy, RequestCache cacheRequest) {
                Assert.isTrue(UrlUtils.isValidRedirectUrl(invalidSessionUrl),
                        "url must start with '/' or with 'http(s)'");
                this.destinationUrl = invalidSessionUrl;
                this.redirectStrategy = redirectStrategy;
                this.cacheRequest = cacheRequest;
        }

        public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException {
                logger.debug("Redirecting to '" + destinationUrl + "'");
                cacheRequest.saveRequest(event.getRequest(), event.getResponse());
                redirectStrategy.sendRedirect(event.getRequest(), event.getResponse(), destinationUrl);
        }
}
