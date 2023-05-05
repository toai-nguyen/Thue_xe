package qlxm.entity;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
	public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}
