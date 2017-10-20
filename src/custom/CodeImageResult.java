package custom;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import org.apache.struts2.ServletActionContext;

import java.awt.image.BufferedImage;

/**
 * Created by dllo on 17/10/20.
 */
public class CodeImageResult implements Result {
    @Override
    public void execute(ActionInvocation actionInvocation) throws Exception {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        ActionContext.getContext().getApplication().put("verifyCode",verifyCode.getText());
        System.out.println(verifyCode.getText());
        VerifyCode.output(image, ServletActionContext.getResponse().getOutputStream());
    }
}
