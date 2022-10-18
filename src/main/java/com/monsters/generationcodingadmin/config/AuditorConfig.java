package com.monsters.generationcodingadmin.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Jpa 配置 createdBy 和 updatedBy 字段自动填充
 * @author Monsters
 * @date 2022/10/17 5:09 PM
 */
@Component
public class AuditorConfig implements AuditorAware<String> {

    /** 获取当前登陆人 */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("admin");
    }
}
