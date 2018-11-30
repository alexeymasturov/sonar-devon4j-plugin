package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureComponentCheck} verifying that the service layer does not depend on the service layer of
 * another {@link Component}.
 */
@Rule(key = "Devon4j:C3", name = "Devon Layer Service-Service Component Check", //
    description = "Verify that service layer does not depend service layer of another component.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureLayerService2Service4ComponentCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Component sourceComponent, Devon4jPackage target,
      String targetTypeSimpleName) {

    if (source.isLayerService() && target.isLayerService()) {
      return "Code from service layer ('" + source.toString()
          + "') shall not depend on service layer of a different component ('" + target.toString() + "').";
    }
    return null;
  }

}
