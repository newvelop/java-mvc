package com.interface21.webmvc.servlet.mvc.tobe;

import com.interface21.web.bind.annotation.RequestMethod;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Objects;

public class HandlerKey {

    private final String url;
    private final RequestMethod requestMethod;

    public HandlerKey(final String url, final RequestMethod requestMethod) {
        this.url = url;
        this.requestMethod = requestMethod;
    }

    public static HandlerKey from(final HttpServletRequest request) {
        return new HandlerKey(request.getRequestURI(), RequestMethod.valueOf(request.getMethod()));
    }

    @Override
    public String toString() {
        return "HandlerKey{" +
                "url='" + url + '\'' +
                ", requestMethod=" + requestMethod +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final HandlerKey that)) return false;
        return Objects.equals(url, that.url) && requestMethod == that.requestMethod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, requestMethod);
    }
}
