package org.centime.Assignment.Config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class Slf4jMDCFilter extends OncePerRequestFilter {

    private final String mdcTokenKey;
    public static final String DEFAULT_MDC_UUID_TOKEN_KEY = "Slf4jMDCFilter.UUID";
    private static final String CORRELATION_ID_HEADER_NAME = "X-Correlation-Id";


    public Slf4jMDCFilter() {
        this.mdcTokenKey = DEFAULT_MDC_UUID_TOKEN_KEY;
    }

    public Slf4jMDCFilter(String mdcTokenKey) {
        this.mdcTokenKey = mdcTokenKey;
    }

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain)
            throws java.io.IOException, ServletException {
        try {
            final String token = extractToken(request);
            MDC.put(mdcTokenKey, token);

            chain.doFilter(request, response);
        } finally {
            MDC.remove(mdcTokenKey);
        }
    }

    private String extractToken(final HttpServletRequest request) {
        final String token;
        if (request.getHeader(CORRELATION_ID_HEADER_NAME) != null) {
            token = request.getHeader(CORRELATION_ID_HEADER_NAME);
        } else {
            token = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        }
        return token;
    }
}