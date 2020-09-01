package com.eudemon.ratelimiter.env.loader;

import com.eudemon.ratelimiter.env.io.ResourceLoader;
import com.eudemon.ratelimiter.extension.Order;

/**
 * 从文件系统加载配置文件
 * TODO(zheng): support user specified file path.
 */
@Order(Order.HIGHEST_PRECEDENCE + 30)
public class FileSystemPropertySourceLoader extends AbstractFilePropertySourceLoader
    implements PropertySourceLoader {

  private static final String[] DEFAULT_CONFIG_FILES = new String[] {
      "file:ratelimiter-env.yaml",
      "file:ratelimiter-env.yml",
      "file:ratelimiter-env.properties"
  };

  public FileSystemPropertySourceLoader() {
    this(null);
  }

  public FileSystemPropertySourceLoader(ResourceLoader resourceLoader) {
    super(resourceLoader);
  }

  @Override
  public String[] getAllMatchedConfigFiles() {
    return DEFAULT_CONFIG_FILES;
  }

}
