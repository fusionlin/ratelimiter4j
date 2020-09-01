package com.eudemon.ratelimiter.env.resolver;

import com.eudemon.ratelimiter.exception.ConfigurationResolveException;

import java.io.InputStream;
import java.util.Map;

/**
 * 配置文件解析接口
 */
public interface PropertySourceResolver {

  String[] getSupportedFileExtensions();

  boolean canResolvedExtension(String fileExtension);

  Map<String, Object> resolve(InputStream in) throws ConfigurationResolveException;

}
