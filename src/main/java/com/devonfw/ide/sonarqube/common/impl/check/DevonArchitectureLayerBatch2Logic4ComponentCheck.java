package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureComponentCheck} verifying that the batch layer does not depend on the logic layer of another
 * {@link Component}.
 */
@Rule(key = "Devon4j:C7", name = "Devon Layer Batch-Logic Component Check", //
    description = "Verify that batch layer does not depend on logic layer of another component.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureLayerBatch2Logic4ComponentCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Component sourceComponent, Devon4jPackage target,
      String targetTypeSimpleName) {

    if (source.isLayerBatch() && target.isLayerLogic()) {
      return "Code from batch layer ('" + source.toString()
          + "') shall not depend on logic layer of a different component ('" + target.toString() + "').";
    }
    return null;
  }

}
