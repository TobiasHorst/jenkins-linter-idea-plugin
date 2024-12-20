package com.github.mikesafonov.jenkins.linter.api

import com.intellij.credentialStore.Credentials
import com.intellij.util.net.IdeHttpClientHelpers
import com.intellij.util.net.ssl.CertificateManager
import org.apache.commons.codec.binary.Base64.encodeBase64
import org.apache.http.HttpHeaders
import org.apache.http.client.config.RequestConfig
import org.apache.http.conn.ssl.NoopHostnameVerifier
import org.apache.http.conn.ssl.SSLConnectionSocketFactory
import org.apache.http.conn.ssl.TrustSelfSignedStrategy
import org.apache.http.impl.client.BasicCredentialsProvider
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.message.BasicHeader
import org.apache.http.ssl.SSLContextBuilder
import java.nio.charset.StandardCharsets
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext

/**
 * @author Mike Safonov
 * @author Tobias Horst
 */
object HttpClientFactory {
    fun get(
        url: String,
        trustSelfSigned: Boolean,
        ignoreCertificate: Boolean,
        credentials: Credentials?,
        useTokenAsOAuthToken: Boolean,
    ): CloseableHttpClient {
        val clientBuilder = HttpClients.custom()

        // proxy support
        val provider = BasicCredentialsProvider()
        IdeHttpClientHelpers.ApacheHttpClient4.setProxyCredentialsForUrlIfEnabled(provider, url)
        val requestConfig = RequestConfig.custom()
        IdeHttpClientHelpers.ApacheHttpClient4.setProxyForUrlIfEnabled(requestConfig, url)

        clientBuilder
            .setDefaultRequestConfig(requestConfig.build())
            .setDefaultCredentialsProvider(provider)
        if (ignoreCertificate) {
            val sslContext: SSLContext =
                SSLContextBuilder()
                    .loadTrustMaterial(
                        null,
                    ) { _: Array<X509Certificate?>?, _: String? -> true }.build()
            clientBuilder
                .setSSLContext(sslContext)
                .setSSLHostnameVerifier(NoopHostnameVerifier())
        } else {
            // ssl support
            clientBuilder
                .setSSLContext(CertificateManager.getInstance().sslContext)
            if (trustSelfSigned) {
                val builder = SSLContextBuilder()
                builder.loadTrustMaterial(TrustSelfSignedStrategy())
                clientBuilder.setSSLSocketFactory(
                    SSLConnectionSocketFactory(builder.build()),
                )
            }
        }
        if (credentials != null) {
            if (useTokenAsOAuthToken) {
                val authHeader = "Bearer ${credentials.getPasswordAsString()}"
                clientBuilder.setDefaultHeaders(
                    listOf(BasicHeader(HttpHeaders.AUTHORIZATION, authHeader)),
                )
            } else {
                val auth = "${credentials.userName!!}:${credentials.getPasswordAsString()}"
                val encodedAuth: ByteArray =
                    encodeBase64(
                        auth.toByteArray(StandardCharsets.ISO_8859_1),
                    )
                val authHeader = "Basic ${String(encodedAuth)}"
                clientBuilder.setDefaultHeaders(
                    listOf(BasicHeader(HttpHeaders.AUTHORIZATION, authHeader)),
                )
            }
        }
        return clientBuilder.build()
    }
}
