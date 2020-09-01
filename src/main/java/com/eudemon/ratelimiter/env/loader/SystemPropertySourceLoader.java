package com.eudemon.ratelimiter.env.loader;

import com.eudemon.ratelimiter.env.PropertyConstants;
import com.eudemon.ratelimiter.env.PropertySource;
import com.eudemon.ratelimiter.extension.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * 从系统环境变量加载配置.
 */
@Order(Order.HIGHEST_PRECEDENCE + 20)
public class SystemPropertySourceLoader implements PropertySourceLoader {

  @Override
  public PropertySource load() {
    Map<String, String> envs = getEnv();
    Map<String, Object> ratelimiterProperties = new HashMap<String, Object>();
    for (Map.Entry<String, String> env : envs.entrySet()) {
      if (env.getKey().startsWith(PropertyConstants.PROPERTY_KEY_PREFIX)) {
        ratelimiterProperties.put(env.getKey(), env.getValue());
      }
    }
    PropertySource source = new PropertySource();
    source.addProperties(ratelimiterProperties);
    return source;
  }

  protected Map<String, String> getEnv() {
    return System.getenv();
  }

}
