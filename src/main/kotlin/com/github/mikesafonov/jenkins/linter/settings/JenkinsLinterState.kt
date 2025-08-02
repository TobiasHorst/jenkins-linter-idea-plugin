package com.github.mikesafonov.jenkins.linter.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

/**
 * @author Mike Safonov
 * @author Tobias Horst
 */
@State(name = "JenkinsLinterState", storages = [Storage("JenkinsLinter.xml")])
class JenkinsLinterState : PersistentStateComponent<JenkinsLinterState> {
    var jenkinsUrl = ""
    var trustSelfSigned = false
    var ignoreCertificate = false
    var useCrumbIssuer = false
    var useTokenAsOAuthToken = false

    companion object {
        fun getInstance() = ApplicationManager.getApplication().getService(JenkinsLinterState::class.java)!!
    }

    override fun getState(): JenkinsLinterState = this

    override fun loadState(state: JenkinsLinterState) {
        XmlSerializerUtil.copyBean(state, this)
    }
}
