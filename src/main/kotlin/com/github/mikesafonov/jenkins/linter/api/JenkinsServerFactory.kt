package com.github.mikesafonov.jenkins.linter.api

import com.github.mikesafonov.jenkins.linter.settings.JenkinsLinterCredentials
import com.intellij.credentialStore.Credentials

/**
 * @author Mike Safonov
 * @author Tobias Horst
 */
object JenkinsServerFactory {
    fun get(
        url: String,
        trustSelfSigned: Boolean = true,
        ignoreCertificate: Boolean = false,
        useTokenAsOAuthToken: Boolean = false,
        useCrumbIssuer: Boolean = false,
    ): JenkinsServer {
        val credentials = JenkinsLinterCredentials.get()
        return JenkinsServerImpl(
            url,
            trustSelfSigned,
            ignoreCertificate,
            credentials,
            useTokenAsOAuthToken,
            useCrumbIssuer,
        )
    }

    fun get(
        url: String,
        trustSelfSigned: Boolean = true,
        ignoreCertificate: Boolean = false,
        credentials: Credentials?,
        useTokenAsOAuthToken: Boolean,
    ): JenkinsServer = JenkinsServerImpl(url, trustSelfSigned, ignoreCertificate, credentials, useTokenAsOAuthToken)
}
