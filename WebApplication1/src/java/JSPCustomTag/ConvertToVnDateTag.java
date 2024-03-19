/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSPCustomTag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Admin
 */

public class ConvertToVnDateTag extends SimpleTagSupport {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("MM-dd-yyyy");
            Date date = inputFormat.parse(value);

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd, MMMM, yyyy", new Locale("vi", "VN"));
            String formattedDate = outputFormat.format(date);

            getJspContext().getOut().write(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

