# jenkins-linter-idea-plugin

<!-- Plugin description -->
**jenkins-linter-idea-plugin** is an Intellij Idea plugin to validate Jenkinsfiles by
the [Pipeline Linter](https://www.jenkins.io/doc/book/pipeline/development/#linter) of a Jenkins server.

## Notice

This plugin is a fork of https://github.com/MikeSafonov/jenkins-linter-idea-plugin with additional features.

## Features

- [x] Supports declarative pipeline only
- [x] HTTP linter integration
- [x] Linting errors highlighting
- [x] Jenkins authorization
- [x] OAuth support

## Installation

The plugin can be installed with **Settings | Plugins | Marketplace** and searching for **Jenkins Pipeline Linter**.

## Settings

Settings for the plugin can be found under **Settings | Tools | Jenkins Linter**.

## Usage

- Configure Jenkins server connection via plugin settings.
- Open context menu on file and click **Validate by Jenkins Linter**

<!-- Plugin description end -->

![Jenkins Linter menu](images/menu.png)

## Proxy and SSL support

Starting from `0.5.0` plugin support builtin proxy (**File | Settings | Appearance & Behavior | System Settings | HTTP
Proxy**) and SSL(**File | Settings | Tools | Server Certificates**) settings.

## OAuth Support

For Jenkins instances secured by an OAuth provider just check the "Use OAuth Token" option and provide the token via the
password/token field.

## Contributing

Feel free to contribute.
New feature proposals and bug fixes should be submitted as GitHub pull requests.
Fork the repository on GitHub, prepare your change on your forked copy, and submit a pull request.

**IMPORTANT!**
> Before contributing please read about [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/)
