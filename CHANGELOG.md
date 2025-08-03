# Changelog

## [Unreleased]

### Added

### Changed
- Update org.jlleitschuh.gradle.ktlint to version 13.0.0
- Update org.jetbrains.intellij.platform to version 2.7.0
- Update org.jetbrains.changelog to version 2.3.0
- Update org.jetbrains.kotlin.jvm to version 2.2.0
- Update io.gitlab.arturbosch.detekt:detekt-formatting to version 1.23.8
- Update org.gradle.toolchains.foojay-resolver-convention to version 1.0.0

### Deprecated

### Removed

### Fixed

### Security

## [1.0.1] - 2024-12-12

### Fixed

- Linting broken when OAuth token usage is enabled

## [1.0.0] - 2024-12-12

Upgrade of plugin dependency versions and add new features of initial [Jenkins Linter IDEA Plugin](https://github.com/MikeSafonov/jenkins-linter-idea-plugin) fork.

### Added

- OAuth2 authentication option
- Jenkinsfile validation without saving

### Changed

- Update GitHub workflows to latest versions of used actions

### Security

- Update org.jetbrains.changelog Gradle plugin
- Update org.jetbrains.intellij.platform Gradle plugin
- Update org.jetbrains.kotlin.jvm Gradle plugin
- Update org.jlleitschuh.gradle.ktlint Gradle plugin
- Update io.gitlab.arturbosch.detekt Gradle plugin

[Unreleased]: https://github.com/TobiasHorst/jenkins-linter-idea-plugin/compare/v1.0.1...HEAD
[1.0.1]: https://github.com/TobiasHorst/jenkins-linter-idea-plugin/compare/v1.0.0...v1.0.1
[1.0.0]: https://github.com/TobiasHorst/jenkins-linter-idea-plugin/commits/v1.0.0
