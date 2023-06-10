package it.unicam.cs.ids.shoppingsite.menu;

import java.lang.Class;

import it.unicam.cs.ids.shoppingsite.ShoppingsiteApplication;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link ShoppingsiteApplication}.
 */
public class ShoppingsiteApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'shoppingsiteApplication'.
   */
  public static BeanDefinition getShoppingsiteApplicationBeanDefinition() {
    Class<?> beanType = ShoppingsiteApplication.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    ConfigurationClassUtils.initializeConfigurationClass(ShoppingsiteApplication.class);
    beanDefinition.setInstanceSupplier(ShoppingsiteApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
