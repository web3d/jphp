package org.develnext.jphp.net;

import org.develnext.jphp.net.classes.*;
import php.runtime.env.CompileScope;
import php.runtime.env.Environment;
import php.runtime.ext.core.classes.stream.Stream;
import php.runtime.ext.support.Extension;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class NetExtension extends Extension {
    public final static String NAMESPACE = "php\\net\\";

    @Override
    public String getVersion() {
        return "~";
    }

    @Override
    public void onRegister(CompileScope scope) {
        registerClass(scope, WrapNetStream.class);

        registerWrapperClass(scope, Proxy.class, WrapProxy.class);
        registerWrapperClass(scope, URLConnection.class, WrapURLConnection.class);
        registerWrapperClass(scope, URL.class, WrapURL.class);
    }

    @Override
    public void onLoad(Environment env) {
        Stream.registerProtocol(env, "http", WrapNetStream.class);
        Stream.registerProtocol(env, "https", WrapNetStream.class);
        Stream.registerProtocol(env, "ftp", WrapNetStream.class);
    }
}
