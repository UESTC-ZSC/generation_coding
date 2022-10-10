package com.monsters.generationcodingadmin.config;

import com.monsters.generationcodingadmin.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis 配置类
 *
 * @author Monsters
 * @date 2022/9/9 10:24 PM
 */
@EnableCaching
public class RedisConfig extends BaseRedisConfig {
}
