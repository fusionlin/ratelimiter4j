package com.eudemon.ratelimiter.env.loader;

import com.eudemon.ratelimiter.env.PropertySource;

/**
 * 配置加载接口
 */
public interface PropertySourceLoader {

	PropertySource load();

}
