import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs

version = "2024.03"

project {
    buildType(NetologyBuild)
}

object NetologyBuild : BuildType({
    id = "NetologyBuild"
    name = "netology"
    description = "Build configuration for netology project"

    vcs {
        root(DslContext.settingsRoot)
        branchFilter = "+:*"
    }

    steps {
        maven {
            name = "Maven: clean deploy (non-master)"
            goals = "clean deploy"
            executionCondition = """
                teamcity.build.branch does not contain master
            """.trimIndent()
        }

        maven {
            name = "Maven: clean test (master)"
            goals = "clean test"
            executionCondition = """
                teamcity.build.branch contains master
            """.trimIndent()
        }
    }

    triggers {
        vcs {
            id = "VcsTrigger"
            name = "VCS Trigger"
            branchFilter = "+:*"
            quietPeriod = 60
        }
    }

    features {
        feature {
            id = "perfMonitor"
            type = "perfmon"
            param("collectCpu", "true")
            param("collectDisk", "true")
            param("collectMemory", "true")
        }
    }

    artifacts {
        add("target/*.jar", "artifacts")
    }
})