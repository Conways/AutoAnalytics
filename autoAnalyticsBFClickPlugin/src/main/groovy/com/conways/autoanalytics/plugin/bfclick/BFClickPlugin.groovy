package com.conways.autoanalytics.plugin.bfclick;

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class BFClickPlugin implements Plugin<Project> {

    @Override
    void apply(Project o) {
//        def config=o.getExtensions().create("testConfig",AutoAnalyticsConfig)
//        o.afterEvaluate {
//            AutoAnalyticsConfig.config=config
//        }
        AppExtension appExtension = o.getExtensions().findByType(AppExtension.class);
        appExtension.registerTransform(new BFClickTransform())
    }
}

