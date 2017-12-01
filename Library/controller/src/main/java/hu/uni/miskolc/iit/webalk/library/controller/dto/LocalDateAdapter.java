package hu.uni.miskolc.iit.webalk.library.controller.dto;

import hu.uni.miskolc.iit.webalk.library.exceptions.LocalDateUnmarshalException;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String v) throws LocalDateUnmarshalException {
        return LocalDate.parse(v);
    }

    @Override
    public String marshal(LocalDate v) {
        if (v != null) {
            return v.toString();
        } else {
            return null;
        }
    }
}