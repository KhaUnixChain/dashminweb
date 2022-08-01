package com.fpt.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailInfo {
    String from;
    String to;
    String[] cc;
    String[] bcc;
    String subject;
    String body;
    String[] attachments;

    public MailInfo(String to, String subject, String body) {
        this.from = "khannpd05178@fpt.edu.vn";
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.cc = null;
        this.bcc = null;
        this.attachments = null;
    }

    public MailInfo(String to, String[] cc, String[] bcc, String subject, String body, String[] attachments) {
        this.from = "khannpd05178@fpt.edu.vn";
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.body = body;
        this.attachments = attachments;
    }

    
}
