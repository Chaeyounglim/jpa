package me.chaeyoung.jpa.my;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class MyRepositoryRegistrar implements ImportBeanDefinitionRegistrar {
    // ImportBeanDefinitionRegistrar 는 프로그래밍을 통해 빈을 주입한다.

    @Override
    public void registerBeanDefinitions(
            AnnotationMetadata importingClassMetadata,
            BeanDefinitionRegistry registry) {

        // 주입할 빈에 대해 프로그래밍 하는 부분!!
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        // 빈으로 등록할 클래스
        beanDefinition.setBeanClass(MyRepository.class);
        beanDefinition.getPropertyValues().add("dataTable", Map.of(1L, "data"));
        // 여기까지!

        // 빈 이름을 myRepository 으로 빈 생성
        registry.registerBeanDefinition("myRepository", beanDefinition);
    }
}
