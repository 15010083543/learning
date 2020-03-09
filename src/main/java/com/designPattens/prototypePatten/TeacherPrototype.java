package com.designPattens.prototypePatten;

import lombok.Data;

@Data
public class TeacherPrototype implements Cloneable {

    private int age;
    private String name;

    @Override
    protected Object clone() {
        TeacherPrototype teacherPrototype = null;
        try {
            teacherPrototype = (TeacherPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return teacherPrototype;
    }
}
