package que3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class email {
    private String Email;
    public email(String e){
        Email=e;
    }
    public boolean LegalEmail(){
        Pattern p=Pattern.compile("^[0-9a-zA-z_-]+@[0-9a-zA-Z-_]+(\\.[0-9a-zA-Z_-]+)+$");
        Matcher m=p.matcher(Email);
        if (m.matches())
        {
            return true;
        }
        else
        {
            System.out.println("邮箱不合法");
            return false;
        }
    }
}
