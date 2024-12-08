package com.github.mikesafonov.jenkins.linter.api

import com.github.mikesafonov.jenkins.linter.JenkinsLinterException
import com.intellij.credentialStore.Credentials

/**
 * @author Mike Safonov
 * @author Tobias Horst
 */
class JenkinsConnectionVerifyer {
    fun verify(
        host: String,
        trustSelfSigned: Boolean = false,
        ignoreCertificate: Boolean = false,
        credentials: Credentials?,
        useTokenAsOAuthToken: Boolean,
    ) {
        val jenkinsServer =
            JenkinsServerFactory.get(host, trustSelfSigned, ignoreCertificate, credentials, useTokenAsOAuthToken)
        jenkinsServer.use {
            val response = jenkinsServer.checkConnection()
            if (!response.success) {
                throw JenkinsLinterException("Request return status code ${response.code}", response.code)
            }
        }
    }
}
