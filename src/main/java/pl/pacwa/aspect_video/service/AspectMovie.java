package pl.pacwa.aspect_video.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;


@Aspect
@Component
public class AspectMovie {

    private MailService mailService;

    public AspectMovie(MailService mailService) {
        this.mailService = mailService;
    }

    @After("@annotation(MailAnnotation)")
    private void sendEmail() throws MessagingException {
        mailService.sendEmail(
                        "javakrys47@gmail.com",
                        "Video List",
                        "Your movie has been added to Video list", true);
    }

}
