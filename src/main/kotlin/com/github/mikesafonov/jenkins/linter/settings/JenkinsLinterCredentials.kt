package com.github.mikesafonov.jenkins.linter.settings

import com.intellij.credentialStore.CredentialAttributes
import com.intellij.credentialStore.Credentials
import com.intellij.credentialStore.generateServiceName
import com.intellij.ide.passwordSafe.PasswordSafe

/**
 * @author Mike Safonov
 * @author Tobias Horst
 */
object JenkinsLinterCredentials {
    fun get(): Credentials? {
        val attributes = credentialAttributes()
        return PasswordSafe.instance.get(attributes)
    }

    fun store(credentials: Credentials) {
        val attributes = credentialAttributes()
        PasswordSafe.instance.set(attributes, credentials)
    }

    private fun credentialAttributes() =
        CredentialAttributes(
            generateServiceName(
                "Jenkins linter",
                "jenkins instance",
            ),
        )
}
