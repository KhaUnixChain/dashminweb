package com.fpt.assignment.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.fpt.assignment.repository.CustomerDAO;
import com.fpt.assignment.model.Customer;
import com.fpt.assignment.service.CustomerInterface;

import net.bytebuddy.utility.RandomString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class CustomerService implements CustomerInterface{
    @Autowired
    CustomerDAO dao;
    @Autowired
    SessionService session;

    /** */
     
    @Autowired
    private JavaMailSender mailSender;


    /**
     * 
     */
    @Override
    public List<Customer> findAll() {
        return dao.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        Page<Customer> page = dao.findAll(pageable);
        return page;
    }

    @Override
    public Customer findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public Page<Customer> findPhoneAndName(String keyword, Pageable pageable) {
        Page<Customer> page = dao.findCustomers(keyword, pageable);
        return page;
    }

    @Override
    public Long getCount() {
        return dao.count();
    }

    @Override
    public Customer findByEmailAndPassword(String email, String pass) {
        return dao.findByEmailAndPassword(email, pass);
    }

    @Override
    public void save(Customer customer) {
        dao.save(customer);
    }
    

    /**
     * 
     * 
     * 
     * 
     * 
     */
    public void register(Customer customer, String siteURL) throws UnsupportedEncodingException, MessagingException {        
        String randomCode = RandomString.make(64);
        customer.setVerificationCode(randomCode);
        customer.setEnabled(false);
        
        dao.save(customer);
        
        sendVerificationEmail(customer, siteURL);
    }

    
    private void sendVerificationEmail(Customer customer, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddress = customer.getEmail();
        String fromAddress = "Your email address";
        String senderName = "Your company name";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";
        
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        
        content = content.replace("[[name]]", customer.getName());
        String verifyURL = siteURL + "/verify?code=" + customer.getVerificationCode();
        
        content = content.replace("[[URL]]", verifyURL);
        
        helper.setText(content, true);
        
        mailSender.send(message);
    }

    
    public boolean verify(String verificationCode) {
        Customer user = dao.findByVerificationCode(verificationCode);
         
        if (user == null || user.getEnabled()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            dao.save(user);
             
            return true;
        }
         
    }
}
