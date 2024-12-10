package com.github.mikesafonov.jenkins.linter

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

/**
 * @author Mike Safonov
 * @author Tobias Horst
 */
class FileContentReader {
    fun read(event: AnActionEvent): FileContent? {
        val editor = event.getData(CommonDataKeys.EDITOR)
        val virtualFile = event.getData(CommonDataKeys.VIRTUAL_FILE)
        return if (editor != null && virtualFile != null) {
            val document = editor.document
            FileContent(virtualFile.name, document.text)
        } else {
            null
        }
    }
}
