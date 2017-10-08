package com.example.demo.service.impl

import com.example.demo.service.EmailService
import org.springframework.http.MediaType.TEXT_HTML_VALUE
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring4.SpringTemplateEngine

@Service
class EmailServiceImpl(private val sender: JavaMailSender, private val engine: SpringTemplateEngine): EmailService {

    override fun sendConfirmation(email: String, token: String) {
        val context = Context().apply {
            setVariable("token", token)
        }
        val mimeMessage = sender.createMimeMessage().apply {
            setContent(engine.process("confirmation", context), TEXT_HTML_VALUE)
            with(receiver = MimeMessageHelper(this, false)){
                setTo(email)
                setSubject("Confirmation")
                setText(token)
            }
        }
        sender.send(mimeMessage)
    }
}