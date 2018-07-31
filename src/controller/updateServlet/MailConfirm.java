package controller.updateServlet;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/mailConfirm")
public class MailConfirm extends HttpServlet {
    private static final String MyAccount = "726979224@qq.com";
    private static final String HOST = "smtp.qq.com";
    private static final String MYPASS = "gdxsnhszgklvbebc";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", HOST);
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MyAccount, MYPASS);
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(MyAccount));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(userName));

            // Set Subject: 头部头字段
            message.setSubject("Verification code to register toLearn!");

            // 设置消息体
            Integer code = getCode();
            message.setText(code.toString() + " is your verification code to register toLearn!");

            // 发送消息
            Transport.send(message);

            //将code存到用户session中以供验证
            req.getSession().setAttribute("code", code);
            System.out.println(code);
        } catch (MessagingException e){
            e.printStackTrace();
        }
    }

    private Integer getCode(){
        return (int) (Math.random() * 10000);
    }
}
